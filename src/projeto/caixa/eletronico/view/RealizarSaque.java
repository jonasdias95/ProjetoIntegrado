package projeto.caixa.eletronico.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class RealizarSaque extends JFrame implements ActionListener{
	private JLabel frase;
	private JButton Imprimir;
	private JButton voltar;
	private JButton terminar;
	private JPanel botoes;
	private JPanel principal;
	private JPanel conteudo;
	private JButton v10; JButton v20; JButton v50; JButton v100; JButton v200; JButton v500;
	private JLabel lblvalor;
	private JTextField Tfvalor;
	private JPanel OpcBase;
	private JPanel Opc;
	private JPanel Opc2;
	private ImageIcon imgUsr;
	private Dimension tam;
	public Locale locale;
	public ResourceBundle bundleLocale;

	RealizarSaque(Locale localeParam, ResourceBundle bundleParam){
		super(bundleParam.getString("tela.realizarSaque.titulo"));
		setLocation(localeParam, bundleParam);
		tam = new Dimension(100, 100);
		imgUsr = new ImageIcon("Interface/login.png");
		frase = new JLabel("<NOME DO CLIENTE> - "+ bundleLocale.getString("tela.realizarSaque.titulo") , imgUsr, SwingConstants.CENTER);
		frase.setHorizontalAlignment(SwingConstants.LEFT);
		Imprimir = new JButton(bundleLocale.getString("tela.button.imprimir"));
		terminar = new JButton(bundleLocale.getString("tela.button.terminar"));
		voltar = new JButton(bundleLocale.getString("tela.button.voltar"));
		botoes = new JPanel();
		principal = new JPanel();
		conteudo = new JPanel(new BorderLayout());
		v10 = new JButton(bundleLocale.getString("tela.realizarSaque.button.10"));
			v10.setPreferredSize(tam);
		v20 = new JButton(bundleLocale.getString("tela.realizarSaque.button.20"));
			v20.setPreferredSize(tam);
		v50 = new JButton(bundleLocale.getString("tela.realizarSaque.button.50"));
			v50.setPreferredSize(tam);
		v100 = new JButton(bundleLocale.getString("tela.realizarSaque.button.100"));
			v100.setPreferredSize(tam);
		v200 = new JButton(bundleLocale.getString("tela.realizarSaque.button.200"));
			v200.setPreferredSize(tam);
		v500 = new JButton(bundleLocale.getString("tela.realizarSaque.button.500"));
			v500.setPreferredSize(tam);
		lblvalor = new JLabel(bundleLocale.getString("tela.realizarSaque.label"));
		Tfvalor = new JTextField(20);

		Opc = new JPanel();
			Opc.setLayout(new FlowLayout());
			Opc.add(v10);
			Opc.add(v20);
			Opc.add(v50);
			Opc.add(v100);
			Opc.add(v200);
			Opc.add(v500);
		Opc2 = new JPanel(new FlowLayout());
			Opc2.add(lblvalor);
			Opc2.add(Tfvalor);
		Opc2.setAlignmentY(Opc.getAlignmentY());
	//	Conteudo.setLayout(new BorderLayout());
		OpcBase = new JPanel(new FlowLayout());
			OpcBase.add(Opc, SwingConstants.CENTER);
			OpcBase.add(Opc2);
		conteudo.add(OpcBase, BorderLayout.CENTER);
		botoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
			botoes.add(Imprimir);
			botoes.add(terminar);
			botoes.add(voltar);

		principal.setLayout(new BorderLayout());
		principal.add(BorderLayout.NORTH, frase);
		principal.add(BorderLayout.CENTER, conteudo);
		principal.add(BorderLayout.SOUTH, botoes);

		getContentPane().add(principal);
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario MU = new MenuUsuario(locale, bundleLocale);
				dispose();
			}
		});
	}
	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.bundleLocale = bundle;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
