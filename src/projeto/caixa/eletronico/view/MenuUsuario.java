package projeto.caixa.eletronico.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class MenuUsuario extends JFrame implements ActionListener{
	private JPanel base;
	private JPanel topo;
	private JPanel conteudo;
	private JPanel baixoDir;
	private JPanel topoEsq;
	private JPanel baixo;
	private JButton opcSaque;
	private JButton opcSaldo;
	private JButton opcExtrato;
	private JButton opcTransf;
	private JButton opcDebito;
	private JLabel frase;
	private JButton cancelar;
	private ImageIcon imgUsr;
	private ImageIcon imgSaque;
	private ImageIcon imgSaldo;
	private ImageIcon imgExtrato;
	private ImageIcon imgTransf;
	private ImageIcon imgDebito;
	public Locale locale;
	public ResourceBundle BundleLocale;
	MenuUsuario(Locale localeParam, ResourceBundle bundleParam){
		super(bundleParam.getString("tela.menuOpcoes.titulo"));
		setLocation(localeParam, bundleParam);
		imgUsr = new ImageIcon("images/login.png");
		imgSaque = new ImageIcon("images/saque");
		imgSaldo = new ImageIcon("images/saldo");
		imgExtrato = new ImageIcon("images/extrato");
		imgTransf = new ImageIcon("images/transferencia");
		imgDebito = new ImageIcon("images/debitoAut");
		frase = new JLabel("<NOME DO CLIENTE>", imgUsr, SwingConstants.CENTER);
		opcSaque = new JButton(BundleLocale.getString("tela.menuOpcoes.button1"));
			opcSaque.setIcon(imgSaque);
		opcSaldo = new JButton(BundleLocale.getString("tela.menuOpcoes.button2"));
			opcSaldo.setIcon(imgSaldo);
		opcExtrato = new JButton(BundleLocale.getString("tela.menuOpcoes.button5"));
			opcExtrato.setIcon(imgExtrato);
		opcTransf = new JButton(BundleLocale.getString("tela.menuOpcoes.button3"));
			opcTransf.setIcon(imgTransf);
		opcDebito = new JButton(BundleLocale.getString("tela.menuOpcoes.button4"));
			opcDebito.setIcon(imgDebito);

		cancelar = new JButton(BundleLocale.getString("tela.button.cancelar"));
		base = new JPanel();
		topo = new JPanel();
		conteudo = new JPanel();
		topoEsq = new JPanel();
		baixo = new JPanel(new BorderLayout());
		baixoDir = new JPanel(new FlowLayout(SwingConstants.LEFT));
		topoEsq.setLayout(new FlowLayout(FlowLayout.LEFT));
			topoEsq.add(frase);
		topo.setLayout(new BorderLayout());
			topo.add(BorderLayout.WEST, topoEsq);
		conteudo.setLayout(new FlowLayout(FlowLayout.CENTER));
			conteudo.add(opcSaque);
			conteudo.add(opcSaldo);
			conteudo.add(opcExtrato);
			conteudo.add(opcTransf);
			conteudo.add(opcDebito);
		baixoDir.add(cancelar);
		baixo.add(baixoDir, BorderLayout.SOUTH);
		base.setLayout(new BorderLayout());
			base.add(BorderLayout.NORTH, topo);
			base.add(BorderLayout.CENTER, conteudo);
			base.add(BorderLayout.SOUTH, baixo);

		this.setLayout(new GridLayout(3,1,20,20));
		this.getContentPane().add(topo, BorderLayout.NORTH);
		this.getContentPane().add(conteudo, BorderLayout.CENTER);
		this.getContentPane().add(baixo, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(800, 600);

	opcSaque.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			RealizarSaque sq = new RealizarSaque(locale, BundleLocale);
			dispose();
		}
	});
	opcSaldo.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			ConsultarSaldo cs = new ConsultarSaldo(locale, BundleLocale);
			dispose();
		}
	});
	opcExtrato.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			TelaExtrato TE = new TelaExtrato(locale, BundleLocale);
			dispose();
		}
	});

	opcTransf.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			TelaRealizarTransferencia RT = new TelaRealizarTransferencia(locale, BundleLocale);
			dispose();
		}
	});

	opcDebito.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CadastrarDebito CD = new CadastrarDebito(locale, BundleLocale);
			dispose();
		}
	});

	}

	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.BundleLocale = bundle;
	}

//	public static void main(String[] args) {
//		MenuUsuario us = new MenuUsuario();
//		//saque.pack();
//		us.setSize(800,600);
//		us.setVisible(true);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
