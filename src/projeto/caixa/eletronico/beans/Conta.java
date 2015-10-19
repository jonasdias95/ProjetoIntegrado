package projeto.caixa.eletronico.beans;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import projeto.caixa.eletronico.dao.ContaDAO;

public class Conta {
	private String numConta;
	private String senha;
	private double saldo;
	private List<Conta> contas;
	private ContaDAO contaDAO;


	public Conta() {
		super();
		contas =  new ArrayList<Conta>();
		this.contaDAO = new ContaDAO();
	}
	public Conta(String numConta) {
		super();
		this.numConta = numConta;
		this.contas =  new ArrayList<Conta>();
		this.contaDAO = new ContaDAO();

	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;

	}
	public void instanceContas(){
		contas =  new ArrayList<Conta>();
	}
	public double consultaSaldo(Connection conn, int numConta, int numAgencia, int numBanco){
		try {
			this.saldo = contaDAO.consultaSaldo(conn, numConta, numAgencia, numBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saldo;
	}
	public void atualizarSaldo(Connection conn, double saldo, int numConta){
		contaDAO.atualizarSaldo(conn, saldo, numConta);
	}
	public boolean validarConta(Connection conn, int numConta, int numAgencia, int numBanco){
		boolean contaValida = false;
		try {
			 contaValida =contaDAO.validarConta(conn, numConta, numAgencia, numBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contaValida;
	}



}
