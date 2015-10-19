package projeto.caixa.eletronico.model;

import java.sql.Connection;

import projeto.caixa.eletronico.dao.TransferenciaDAO;

public class Transferencia {

	private int tipoMovimento;
	private double valor;
	private TransferenciaDAO transferenciaDAO;
	public Transferencia(int tipoMovimento, double valor) {
		super();
		this.tipoMovimento = tipoMovimento;
		this.valor = valor;
		this.transferenciaDAO = new TransferenciaDAO();
	}
	public int getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void inserirTransferencia(Connection conn, int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco){
		transferenciaDAO.inserirMovimento(conn, tipoMovimento, valor, numConta, numAgencia, numBanco);
		int id_movimento = transferenciaDAO.consultaMovimento(conn,valor, numConta, numAgencia, numBanco);
		transferenciaDAO.inserirTransferencia(conn, tipoMovimento, id_movimento);
	}




}
