package projeto.caixa.eletronico.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import projeto.caixa.eletronico.beans.Agencia;
import projeto.caixa.eletronico.beans.Banco;
import projeto.caixa.eletronico.beans.Conta;
import projeto.caixa.eletronico.dao.AcessoBD;
import projeto.caixa.eletronico.model.Acesso;
import projeto.caixa.eletronico.model.Transferencia;
import projeto.caixa.eletronico.view.TelaTransferencia;

public class TransferenciaController extends TelaTransferencia implements ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Conta conta;
	private Agencia agencia;
	private Banco banco;
	private Transferencia transferencia;
	private int numContaOrigem =0;
	private int numContaDestino =0;
	private int numAgenciaOrigem=0;
	private int numAgenciaDestino=0;
	private int numBancoOrigem = 0;
	private int numBancoDestino =0;

	public TransferenciaController(Locale localeParam, ResourceBundle bundleParam,Acesso acesso) {
		super(localeParam, bundleParam, acesso);
		conta = new Conta();
		agencia = new Agencia();
		banco = new Banco();
		numContaOrigem = Integer.parseInt(acesso.getConta().getNumConta());
		numAgenciaOrigem = acesso.getAgencia().getNumAgencia();
		numBancoOrigem = acesso.getBanco().getNumBanco();

	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(int numAgencia) {
		this.agencia.setNumAgencia(numAgencia);
		numAgenciaDestino = numAgencia;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(int numBanco) {
		this.banco.setNumBanco(numBanco);
		banco.getBancos().add(banco);
		numBancoDestino = numBanco;
	}

	public Conta getConta() {
		return conta;
	}
	public void setConta(String numConta) {
		this.conta.setNumConta(numConta);
		this.conta.getContas().add(conta);
		numContaDestino = Integer.parseInt(numConta);
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}
	public void setTransferencia(int tipoMovimento, double valor) {
		this.transferencia = new Transferencia(tipoMovimento, valor);
	}
	public void actionPerformed(ActionEvent e) {

		Connection conn = null;
		double saldoOrigem = 0.0;
		double saldoDestino = 0.0;

		// obtem conexao com o banco

					AcessoBD bd = new AcessoBD() ;

					try {
						conn = bd.obtemConexao();
						// *** Força o uso de transação.
						conn.setAutoCommit(false);
						saldoOrigem = conta.consultaSaldo(conn, numContaOrigem, numAgenciaOrigem, numBancoOrigem);
						conta.atualizarSaldo(conn, saldoOrigem - transferencia.getValor(), numContaOrigem);
						transferencia.inserirTransferencia(conn, 1, -transferencia.getValor(), numContaOrigem, numAgenciaOrigem, numBancoOrigem);
						transferencia.inserirTransferencia(conn, 1, +transferencia.getValor(), numContaDestino, numAgenciaDestino, numBancoDestino);
						saldoDestino = conta.consultaSaldo(conn, numContaDestino, numAgenciaDestino, numBancoDestino);
						conta.atualizarSaldo(conn, saldoDestino + transferencia.getValor(), numContaDestino);
						conn.commit();
						JOptionPane.showMessageDialog(null, "Transferencia efetuada");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Ocorreu erro na Transferencia!");
						e1.printStackTrace();
						try {
							conn.rollback();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
					}


//		if (acesso.validarAcesso()) {
//			JOptionPane.showMessageDialog(null, "Login efetuado");
//			TelaGerarCodigo gc = new TelaGerarCodigo(locale, bundleLocale);
//			dispose();
//
//		}else JOptionPane.showMessageDialog(null, "Login/senha invalido");

	}

}
