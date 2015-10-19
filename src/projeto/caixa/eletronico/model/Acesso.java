package projeto.caixa.eletronico.model;

import projeto.caixa.eletronico.beans.Agencia;
import projeto.caixa.eletronico.beans.Banco;
import projeto.caixa.eletronico.beans.Conta;
import projeto.caixa.eletronico.dao.AcessoDAO;

public class Acesso {
	private Conta conta;
	private Banco banco;
	private Agencia agencia;
	private AcessoDAO acessoDAO;
	private boolean flagCodigo;
	public Acesso() {
		conta = new Conta();
		acessoDAO = new AcessoDAO();
	}
	public Acesso(String numConta, String senha, int numBanco, int numAgencia){
		conta = new Conta();
		banco = new Banco(numBanco);
		banco.getBancos().add(banco);
		agencia = new Agencia(numAgencia);
		agencia.getAgencias().add(agencia);

		acessoDAO = new AcessoDAO();
		conta.setNumConta(numConta);
		conta.setSenha(senha);
	}
	public boolean validarAcesso(){
		flagCodigo = false;
		acessoDAO.geraMatriz();
	    flagCodigo = AcessoDAO.buscaBinaria(acessoDAO.getContaesenha(), Integer.parseInt(conta.getNumConta()), Integer.parseInt(conta.getSenha() ));
	    return flagCodigo;

	}
	public Banco getBanco() {
		return banco;
	}

	public Agencia getAgencia() {
		return agencia;
	}
	public Conta getConta() {
		return conta;
	}
	public void setNumAgencia(int numAgencia) {

		this.agencia.getAgencias().add(agencia);
	}

	public void setBancos(int numBanco) {
		this.banco = new Banco(numBanco);
		banco.instanceBancos();
		banco.getBancos().add(banco);
	}
	public void setContas(String numConta) {
		conta = new Conta(numConta);
		conta.instanceContas();
		conta.getContas().add(conta);
	}


}
