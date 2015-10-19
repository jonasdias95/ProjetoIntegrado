package projeto.caixa.eletronico.beans;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	private int numAgencia;
	private String endereco;
	private List<Agencia> agencias;


	public Agencia() {
		super();
		agencias = new ArrayList<Agencia>();
	}
	public Agencia(int numAgencia) {
		this.numAgencia = numAgencia;
		this.agencias = new ArrayList<Agencia>();
	}
	public int getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Agencia> getAgencias() {
		return agencias;
	}
	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}
	public void instanceAgencias(){
		agencias = new ArrayList<Agencia>();
	}


}
