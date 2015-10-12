package projeto.caixa.eletronico.util;

import projeto.caixa.eletronico.dao.AcessoDAO;

public class Wordlist {
	public static void main(String[] args){
	AcessoDAO tf = new AcessoDAO();
	tf.abrirArquivo("Acesso.txt");
		for(int i = 0; i < 100; i++){
			String conta = ""+i;
			String senha = ""+(999-i);
			if(i <= 9){
				//conta+="0";
				tf.adicionaRegistro("0"+conta+senha,"0"+senha+conta);
			}else{
			tf.adicionaRegistro(conta+senha, senha+conta);
			}
		}
	tf.fecharArquivo();
	}
}