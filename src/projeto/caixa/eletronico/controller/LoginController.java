package projeto.caixa.eletronico.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import projeto.caixa.eletronico.beans.Agencia;
import projeto.caixa.eletronico.beans.Banco;
import projeto.caixa.eletronico.beans.Conta;
import projeto.caixa.eletronico.model.Acesso;
import projeto.caixa.eletronico.view.TelaGerarCodigo;
import projeto.caixa.eletronico.view.TelaLogin;

public class LoginController extends TelaLogin implements ActionListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Acesso acesso;
	private Conta conta;
	public LoginController(Locale localeparam, ResourceBundle bundleparam) {
		super(localeparam, bundleparam);
		acesso = new Acesso();


	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso( String numConta, String senha, int numBanco, int numAgencia) {
		this.acesso = new Acesso(numConta,senha,numBanco,numAgencia);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (acesso.validarAcesso()) {
			JOptionPane.showMessageDialog(null, "Login efetuado");
			TelaGerarCodigo gc = new TelaGerarCodigo(locale, BundleLocale, acesso);
			dispose();

		}else JOptionPane.showMessageDialog(null, "Login/senha invalido");

	}

}
