package projeto.caixa.eletronico.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import projeto.caixa.eletronico.model.Acesso;
import projeto.caixa.eletronico.view.TelaGerarCodigo;
import projeto.caixa.eletronico.view.TelaLogin;

public class LoginController extends TelaLogin implements ActionListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Acesso acesso;

	public LoginController(Locale localeparam, ResourceBundle bundleparam) {
		super(localeparam, bundleparam);

		acesso = new Acesso();

	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso( String numConta, String senha) {
		this.acesso = new Acesso(numConta,senha);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (acesso.validarAcesso()) {
			JOptionPane.showMessageDialog(null, "Login efetuado");
			TelaGerarCodigo gc = new TelaGerarCodigo(locale, BundleLocale);
			dispose();

		}else JOptionPane.showMessageDialog(null, "Login/senha invalido");

	}

}
