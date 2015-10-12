package projeto.caixa.eletronico.model;

import projeto.caixa.eletronico.beans.Conta;
import projeto.caixa.eletronico.dao.AcessoDAO;

public class Acesso {
	private Conta conta;
	private AcessoDAO acessoDAO;
	private boolean flagCodigo;
	public Acesso() {
		conta = new Conta();
		acessoDAO = new AcessoDAO();
	}
	public Acesso(String numConta, String senha){
		conta = new Conta();
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

}
