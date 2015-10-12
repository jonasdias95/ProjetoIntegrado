package projeto.caixa.eletronico.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExtrairEstatistica extends JFrame implements ActionListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel frase;
	private JButton imprimir;
	private JButton voltar;
	private JButton terminar;
	private JPanel botoes;
	private JPanel principal;
	private JPanel conteudo;
	private ImageIcon imgUsr;

	ExtrairEstatistica(){
		super("Extrair Estatistica");
		imgUsr = new ImageIcon("images/login.png");
		frase = new JLabel("<IDENTIFICAÇÃO DO USUARIO> - Extrair Estatística do Terminal", imgUsr, SwingConstants.CENTER);
		frase.setHorizontalAlignment(SwingConstants.LEFT);
		imprimir = new JButton("Imprimir");
		terminar = new JButton("Terminar");
		voltar = new JButton("Voltar");
		botoes = new JPanel();
		principal = new JPanel();
		conteudo = new JPanel();

		botoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		botoes.add(imprimir);
		botoes.add(terminar);
		botoes.add(voltar);

		principal.setLayout(new BorderLayout());
		principal.add(BorderLayout.NORTH, frase);
		principal.add(BorderLayout.CENTER, conteudo);
		principal.add(BorderLayout.SOUTH, botoes);

		getContentPane().add(principal);
		setVisible(true);
		setSize(800, 600);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	MenuOperador mo = new MenuOperador();
				dispose();
			}
		});
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
