package view;

import controller.ThreadJogo;

public class Principal {
	public static void main(String[] args) {
		int ponto=0;
		for (int jogador = 0; jogador < 300; jogador ++) {
			Thread jogo = new ThreadJogo(ponto, jogador);
					jogo.start();
		}
	}

}
