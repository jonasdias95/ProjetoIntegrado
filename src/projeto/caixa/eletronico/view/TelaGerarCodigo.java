package projeto.caixa.eletronico.view;
//Escrito em 21/04/15 - Guilherme F. Souza
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import projeto.caixa.eletronico.model.Acesso;

public class TelaGerarCodigo extends JFrame implements ActionListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel frase;
	private JLabel frase2;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton ok;
	private JButton cancelar;
	public Locale locale;
	public ResourceBundle BundleLocale;

	public TelaGerarCodigo(Locale localeParam, ResourceBundle bundleParam, final Acesso acesso){
		super(bundleParam.getString("tela.gerarCodigo.titulo"));
		setLocation(localeParam, bundleParam);
		frase = new JLabel(bundleParam.getString("tela.gerarCodigo.label1"));
		frase.setHorizontalAlignment(0);
		frase2 = new JLabel(bundleParam.getString("tela.gerarCodigo.label2"));
		frase2.setVerticalAlignment(FlowLayout.LEADING);
		frase2.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel Esquerdo = new JPanel(new GridLayout(3,1));
		JPanel Centro = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
		Centro.setAlignmentX(SwingConstants.CENTER);
		Centro.setAlignmentY(SwingConstants.CENTER);
		JPanel CentroGrid = new JPanel(new GridLayout(2,1,10,10));
		CentroGrid.setAlignmentX(SwingConstants.CENTER);
		CentroGrid.setAlignmentY(SwingConstants.CENTER);
		JPanel Botoes = new JPanel(new GridLayout(1, 5,10,10));
		JPanel Direito = new JPanel(new GridLayout(3,1));
		JPanel Baixo = new JPanel(new FlowLayout());
		b1 = new JButton("0 "+ bundleParam.getString("tela.gerarCodigo.buttonCod") + " 1");
		b2 = new JButton("2 "+ bundleParam.getString("tela.gerarCodigo.buttonCod") + " 3");
		b3 = new JButton("4 "+ bundleParam.getString("tela.gerarCodigo.buttonCod") + " 5");
		b4 = new JButton("6 "+ bundleParam.getString("tela.gerarCodigo.buttonCod") + " 7");
		b5 = new JButton("8 "+ bundleParam.getString("tela.gerarCodigo.buttonCod") + " 9");
		ok = new JButton("OK");
		cancelar = new JButton(bundleParam.getString("tela.button.cancelar"));
		Centro.add(CentroGrid);
		Botoes.add(b1);
		Botoes.add(b2);
		Botoes.add(b3);
		Botoes.add(b4);
		Botoes.add(b5);
		//Botoes.setAlignmentY(BOTTOM_ALIGNMENT);
		CentroGrid.add(frase2);
		CentroGrid.add(Botoes);
		Centro.add(CentroGrid);
		/*Esquerdo.add(b1);
		Esquerdo.add(b2);
		Esquerdo.add(b3);
		Direito.add(b4);
		Direito.add(b5); */
		Baixo.add(ok);
		Baixo.add(cancelar);
		this.setLayout(new BorderLayout(10,10));
		this.getContentPane().add(frase, BorderLayout.NORTH);
		//this.getContentPane().add(frase2, BorderLayout.CENTER);
		this.getContentPane().add(Esquerdo, BorderLayout.WEST);
		this.getContentPane().add(Direito, BorderLayout.EAST);
		this.getContentPane().add(Baixo, BorderLayout.SOUTH);
		this.getContentPane().add(Centro, BorderLayout.CENTER);
		this.setVisible(true);
		this.setSize(800, 600);

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaMenuUsuario MU = new TelaMenuUsuario(locale, BundleLocale,acesso);
				dispose();
			}
		});
	}
	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.BundleLocale = bundle;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public void setAcesso(Acesso acesso ){

	}

}
