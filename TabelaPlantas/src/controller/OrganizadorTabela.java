package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class OrganizadorTabela implements IOrganizadorTabela{
	
	public OrganizadorTabela() {
		super();
	}

	@Override
	public void leDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.isDirectory() && dir.exists()) {
			File[] vetFiles = dir.listFiles();
			for (File f : vetFiles) {
				if (f.isDirectory()){
					System.out.println("<DIR> "+f.getName());
				} else {
					System.out.println("      "+f.getName());
				}
			}
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
			while (linha != null) {
				String[] vetLinha = linha.split(",");
					if (vetLinha[2].equals("Fruits")){
						System.out.println(vetLinha[0] + "\t\t\t\t" + 
						vetLinha[1] + "\t\t\t\t" +
						vetLinha[3]);
					}
					linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}


}


