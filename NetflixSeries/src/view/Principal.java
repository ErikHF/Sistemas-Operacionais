package view;

import java.io.IOException;

import controller.NetflixController;
import controller.INetflixController;

public class Principal {
	

	public static void main(String[] args) {
		INetflixController arqCont = new NetflixController();
		String path1 = "C:\\Windows";
		String path = "C:\\TEMP";

		try {
//			arqCont.leDir(path1);
//			arqCont.escreveArquivo(path, "NetflixSeries.csv");
			arqCont.leArquivo(path, "NetflixSeries.csv");
//			arqCont.abreArquivo(path, "NetflixSeries.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
