package projeto.caixa.eletronico.util;

import projeto.caixa.eletronico.dao.AcessoDAO;

public class TesteCripto {

	public static void main(String[] args) {
		CriptografiaAES aes = new CriptografiaAES();
		aes.criptografa();
		aes.descriptografa("AcessoCripto.txt");
		//System.out.println(desc);
		TesteCripto tc = new TesteCripto();
		aes.organizaLinhas();
		tc.geraMatriz();
	}

	public int[][] geraMatriz(){
		AcessoDAO txt = new AcessoDAO();
		String saida = txt.carregaRegistro("AcessoDescriptografado.txt");
		int [][] contaesenha = new int [100][2];
		boolean conta = true;
		String buffer = "";
		for(int i=0; i<100; i++){
			if(saida.charAt(i) != ';' & conta == true){
				buffer+=saida.charAt(i);
			}else if(saida.charAt(i) == ';'){
				contaesenha[i][0] = Integer.parseInt(buffer);
				conta = false;
				buffer = "";
			}else if(saida.charAt(i) != '*' && conta == false){
				buffer += saida.charAt(i);
			}else if(saida.charAt(i) == '*'){
				contaesenha[i][1] = Integer.parseInt(buffer);
				conta = true;
				buffer = "";
			}
		}
		return contaesenha;
	}
}
