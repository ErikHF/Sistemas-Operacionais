package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Queue;

import javax.swing.JOptionPane;

import java.io.IOException;
import model.NetflixSeries;

public class NetflixController implements INetflixController{
	
	public NetflixController() {
		super();
	}

	@Override
	public void leDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.isDirectory() && dir.exists()) {
			File[] vetFiles = dir.listFiles();
			for (File f : vetFiles) {
				if (f.isDirectory()) {
					System.out.println("<DIR> "+f.getName());
				} else {
					System.out.println("      "+f.getName());
				}
			}
		}
	}
	
	private String geraConteudo() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while (!linha.equals("fim")) {
			linha = JOptionPane.showInputDialog(null,
					"Digite a entrada",
					"ENTRADA",
					JOptionPane.INFORMATION_MESSAGE);
			if (!linha.equals("fim")) {
				buffer.append(linha+"\r\n");
			}
		}
		return buffer.toString();
	}
	
	@Override
	public void escreveArquivo(String path, String arquivo) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, arquivo);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraConteudo();
			FileWriter abreArq = new FileWriter(arq, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			escreveArq.write(conteudo);
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	@Override	
	public void leArquivo(String path, String arquivo) throws IOException {
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = 
					new FileInputStream(arq);
			InputStreamReader leitorFluxo = 
					new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = 
					new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			int count = -1;
			String genre_aux = null ;
			while (linha != null) {				
				String[] vetLinha = linha.split(";");
				if (count > 0) {
					if(genre_aux != vetLinha[0]) {

						genre_aux = vetLinha[0];
					}
					System.out.println( vetLinha[0]);
					linha = buffer.readLine();
				}		
				count =+ 1;
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}

	@Override
	public void abreArquivo(String path, String arquivo) throws IOException {
		Desktop desktop = Desktop.getDesktop();
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			desktop.open(arq);
		}
	}
}
