package projeto.caixa.eletronico.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class TelaRealizarTransferencia extends JFrame implements ActionListener{
	private JLabel frase;
	private JButton imprimir;
	private JButton voltar;
	private JButton terminar;
	private JLabel lblBanco;
	private JLabel lblAgencia;
	private JLabel lblConta;
	private JLabel lblValor;
	private JTextField tfBanco;
	private JTextField tflAgencia;
	private JTextField tflConta;
	private JTextField tflValor;
	private JPanel botoes;
	private JPanel principal;
	private JPanel conteudo;
	private JPanel opc;
	private ImageIcon imgUsr;
	public Locale locale;
	public ResourceBundle bundleLocale;

	TelaRealizarTransferencia(Locale localeParam, ResourceBundle bundleParam){
		super(bundleParam.getString("tela.realizarTransferencia.titulo"));
		setLocation(localeParam, bundleParam);
		imgUsr = new ImageIcon("images/login.png");
		frase = new JLabel("<NOME DO CLIENTE> - "+bundleLocale.getString("tela.realizarTransferencia.titulo"), imgUsr, SwingConstants.CENTER);
		frase.setHorizontalAlignment(SwingConstants.LEFT);
		imprimir = new JButton(bundleLocale.getString("tela.button.imprimir"));
		terminar = new JButton(bundleLocale.getString("tela.button.terminar"));
		voltar = new JButton(bundleLocale.getString("tela.button.voltar"));
		lblBanco = new JLabel(bundleLocale.getString("tela.realizarTransferencia.label1"));
		lblAgencia = new JLabel(bundleLocale.getString("tela.realizarTransferencia.label2"));
		lblConta = new JLabel(bundleLocale.getString("tela.realizarTransferencia.label3"));
		lblValor = new JLabel(bundleLocale.getString("tela.realizarTransferencia.label4"));
		tfBanco = new JTextField(10);
		tflAgencia = new JTextField(10);
		tflConta = new JTextField(10);
		tflValor = new JTextField(10);
		botoes = new JPanel();
		principal = new JPanel();
		conteudo = new JPanel();

		opc = new JPanel(new GridLayout(4,1,10,10));
			//Opc.setLayout(new GridLayout(4,2,20,20));
			JPanel Aux1 = new JPanel(new FlowLayout());
				Aux1.add(lblBanco);
				Aux1.add(tfBanco);
			JPanel Aux2 = new JPanel(new FlowLayout());
				Aux2.add(lblAgencia);
				Aux2.add(tflAgencia);
			JPanel Aux3 = new JPanel(new FlowLayout());
				Aux3.add(lblConta);
				Aux3.add(tflConta);
			JPanel Aux4 = new JPanel(new FlowLayout());
				Aux4.add(lblValor);
				Aux4.add(tflValor);
			opc.add(Aux1);
			opc.add(Aux2);
			opc.add(Aux3);
			opc.add(Aux4);
		conteudo.setLayout(new FlowLayout());
		conteudo.add(opc);
		opc.setAlignmentX(SwingConstants.CENTER);
		opc.setAlignmentY(SwingConstants.BOTTOM);
		botoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		botoes.add(imprimir);
		botoes.add(terminar);
		botoes.add(voltar);

		principal.setLayout(new BorderLayout());
		principal.add(BorderLayout.NORTH, frase);
		principal.add(BorderLayout.CENTER, conteudo);
		principal.add(BorderLayout.SOUTH, botoes);
	//	Principal.add(BorderLayout.EAST, j1);
	//	Principal.add(BorderLayout.WEST, j2);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario MU = new MenuUsuario(locale, bundleLocale);
				dispose();
			}
		});

		getContentPane().add(principal);
		setSize(800, 600);
		setVisible(true);
	}

	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.bundleLocale = bundle;
	}

//	public static void main(String[] args) {
//		RealizarTransferencia lc = new RealizarTransferencia();
//		lc.setVisible(true);
//		lc.setSize(800,600);
//		//lc.pack();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
