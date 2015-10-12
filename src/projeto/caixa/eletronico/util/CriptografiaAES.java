package projeto.caixa.eletronico.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Formatter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import projeto.caixa.eletronico.dao.AcessoDAO;

public class CriptografiaAES {
	private Formatter output;
	private BufferedReader buffer;
	CryptoAES aes = new CryptoAES();
	public CriptografiaAES(){
		try {
			aes.geraChave(new File("chave.aes"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void criptografa(){
		byte[] msgOriginal = null;
		AcessoDAO txt = new AcessoDAO();
		try {
			msgOriginal = txt.carregaRegistro("Acesso.txt").getBytes("ISO-8859-1");
			aes.geraChave(new File("chave.aes"));
			aes.geraCifra(msgOriginal, new File("chave.aes"));
			byte[] bMsgCifrada = aes.getTextoCifrado();
			String sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
		/*	aes.geraCifra(msgOriginal, new File ("chave.aes"));
			txt.fecharArquivo();
			txt.abrirArquivo("ContaESenhaCripto.txt");
			txt.adicionaRegistro(sMsgCifrada);
			txt.fecharArquivo();*/
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("AcessoCripto.txt")));
			oos.writeObject(sMsgCifrada);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String descriptografa(String arquivo){
		CryptoAES aes2 = new CryptoAES();
		AcessoDAO txt = new AcessoDAO();
		String txtDecifrado ="";
		byte[] btxtcifrado;
		String txtCifrado = null;
		try{
		ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("AcessoCripto.txt"));
		txtCifrado = (String)ois.readObject();
		btxtcifrado = txtCifrado.getBytes("ISO-8859-1");
		aes.geraDecifra(txtCifrado.getBytes("ISO-8859-1"), new File("chave.aes"));
		txtDecifrado = new String(aes.getTextoDecifrado(), "ISO-8859-1");
		//txt.abrirArquivo("ContaESenhaDescripto.txt");
		//txt.adicionaRegistro(txtDecifrado);
		//txt.fecharArquivo();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("AcessoDescripto.txt")));
		oos.writeObject(txtDecifrado);
		oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return txtDecifrado;
	}

	public void organizaLinhas(){
		String saida = "";
		AcessoDAO txt = new AcessoDAO();
		String registros = txt.carregaRegistro("AcessoDescripto.txt");
		//boolean conta = true, flagDl = false;
		for(int i=7; i<registros.length(); i++){
			if(registros.charAt(i) != '*'){
				saida += registros.charAt(i);
			}else{
				saida += "*\r\n";
			}
		}
		//System.out.println(registros);
		//System.out.println(saida);
		txt.fecharArquivo();
		txt.abrirArquivo("AcessoDescriptografado.txt");
		txt.adicionaRegistro(saida);
		txt.fecharArquivo();
	}
}
