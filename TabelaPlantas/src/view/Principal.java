package view;

import java.io.IOException;

import controller.OrganizadorTabela;
import controller.IOrganizadorTabela;

public class Principal {
	public static void main(String[] args) {
		IOrganizadorTabela arqCont = new OrganizadorTabela();
		String path1 = "C:\\";
		String path = "C:\\TEMP";
		try {
			arqCont.leDir(path1);
			arqCont.leDir(path);
//			arqCont.leArquivo(path, "generic_food.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
