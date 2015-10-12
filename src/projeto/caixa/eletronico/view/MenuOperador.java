package projeto.caixa.eletronico.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class MenuOperador extends JFrame{
	private JPanel Base;
	private JPanel Topo;
	private JPanel Conteudo;
	//private JPanel TopoDir;
	private JPanel TopoEsq;
	private JPanel Baixo;
	private JButton opcNotas;
	private JButton opcEstat;
	private JLabel frase;
	private JButton cancelar;
	private ImageIcon imgUsr;
	public Locale locale;
	public ResourceBundle bundleLocale;

	MenuOperador(Locale localeParam, ResourceBundle bundleParam){
		super(bundleParam.getString("tela.menuOpcoesGerenciais.titulo"));
		setLocation(localeParam, bundleParam);
		imgUsr = new ImageIcon("images/login.png");
		frase = new JLabel("<NOME DO FUNCIONÁRIO>", imgUsr, SwingConstants.CENTER);
		frase.setHorizontalAlignment(SwingConstants.LEFT);
		opcNotas = new JButton(bundleLocale.getString("tela.menuOpcoesGerenciais.button1"));
		opcEstat = new JButton(bundleLocale.getString("tela.menuOpcoesGerenciais.button2"));
		cancelar = new JButton(bundleLocale.getString("tela.button.cancelar"));
		Base = new JPanel();
		Topo = new JPanel();
		Conteudo = new JPanel();
		TopoEsq = new JPanel();
		Baixo = new JPanel();
		Conteudo.setLayout(new FlowLayout(FlowLayout.CENTER));
			Conteudo.add(opcNotas);
			Conteudo.add(opcEstat);
		Baixo.setLayout(new FlowLayout(FlowLayout.RIGHT));
			Baixo.add(cancelar);
		this.setLayout(new BorderLayout());
			this.add(BorderLayout.NORTH, frase);
			this.add(BorderLayout.CENTER, Conteudo);
			this.add(BorderLayout.SOUTH, Baixo);
		//this.setLayout(new BorderLayout());
		//this.getContentPane().add();
			setSize(800,600);
			setVisible(true);

		opcNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNotas TN = new TelaNotas(locale, bundleLocale);
				dispose();
			}
		});

		opcEstat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 TelaExtrairEstatistica ee = new TelaExtrairEstatistica(locale, bundleLocale);
			 dispose();
			}
		});

	}

	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.bundleLocale = bundle;
	}
//	public static void main(String[] args) {
//		MenuOperador us = new MenuOperador();
//		//saque.pack();
//		us.setSize(800,600);
//		us.setVisible(true);
//	}
}
