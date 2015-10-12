package projeto.caixa.eletronico.view;
//Escrito em 21/04/15 - Guilherme F. Souza
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projeto.caixa.eletronico.beans.Conta;
import projeto.caixa.eletronico.controller.LoginController;

public class TelaLogin extends JFrame {
	private JLabel frase;
	private JLabel labelConta;
	private JLabel labelSenha;
	private JLabel labelAgencia;
	private JLabel labelBanco;
	private JButton ok;
	private JButton cancelar;
	private JTextField txtConta;
	private JPasswordField senha;
	private JTextField agencia;
	private JTextField banco;
	private ImageIcon imgConta;
	private ImageIcon imgSenha;
	private ImageIcon imgAg;
	private ImageIcon imgBanco;
	private Color fundo;
	private Conta conta = new Conta();
	public Locale locale;
	public ResourceBundle BundleLocale;


	public TelaLogin(Locale localeparam, ResourceBundle bundleparam){
		super(bundleparam.getString("tela.login.titulo1"));
		setLocation(localeparam, bundleparam);
		fundo = new Color(42,45,60);
		imgBanco = new ImageIcon("images/Banco");
		frase = new JLabel(BundleLocale.getString("tela.login.titulo2"), imgBanco,SwingConstants.CENTER);
	//	frase.setForeground(Color.WHITE);
		frase.setHorizontalTextPosition(SwingConstants.CENTER);
		frase.setIconTextGap(10);
		frase.setVerticalTextPosition(SwingConstants.BOTTOM);
		JPanel Topo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel Centro = new JPanel(new GridLayout(4,1,20,10) );
		JPanel Baixo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		imgAg = new ImageIcon("images/agencia.png");
		imgConta = new ImageIcon("images/login.png");
		imgSenha = new ImageIcon("images/Senha.png");
		labelConta = new JLabel(BundleLocale.getString("tela.login.label3"), imgConta, SwingConstants.CENTER);
		//labelConta.setForeground(Color.white);
		labelSenha = new JLabel(BundleLocale.getString("tela.login.label4"), imgSenha, SwingConstants.CENTER);
		labelSenha.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelAgencia = new JLabel(BundleLocale.getString("tela.login.label2"), imgAg, SwingConstants.CENTER);
		labelBanco = new JLabel(BundleLocale.getString("tela.login.label1"), SwingConstants.CENTER);
		txtConta = new JTextField(BundleLocale.getString("tela.login.label3"));
		agencia = new JTextField(BundleLocale.getString("tela.login.label2"));
		senha = new JPasswordField(BundleLocale.getString("tela.login.label4"));
		banco = new JTextField(BundleLocale.getString("tela.login.label1"));
		ok = new JButton("OK");
		cancelar = new JButton(BundleLocale.getString("tela.button.cancelar"));
		Topo.add(frase);
		Centro.add(labelBanco);
		Centro.add(banco);
		Centro.add(labelAgencia);
		Centro.add(agencia);
		Centro.add(labelConta);
		Centro.add(txtConta);
		Centro.add(labelSenha);
		Centro.add(senha);
		Baixo.add(ok);
		Baixo.add(cancelar);
		this.setLayout(new BorderLayout(50,50));
		this.getContentPane().add(Topo, BorderLayout.NORTH);
		this.getContentPane().add(Centro, BorderLayout.CENTER);
		this.getContentPane().add(Baixo, BorderLayout.SOUTH);
		setVisible(true);
		setSize(800,600);
		try {

			ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					LoginController loginController = new LoginController(locale, BundleLocale);
					loginController.setAcesso(txtConta.getText(), senha.getText());
					loginController.actionPerformed(e);
					dispose();
				}
			});

	} catch (Exception e) {
		e.printStackTrace();
	}

}

	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.BundleLocale = bundle;

}



}
