package controller;

public class OperacoesController {
	
	public OperacoesController() {
		super();
	}

	public void operacaoString() {
		String valor = "";
		double tempoInicial = System.nanoTime();
		for (int i = 0; i < 32768 ; i++) {
			valor = valor + "a";
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("String ==>"+tempoTotal+" segundos.");
	}
	
	public void operacaoBuffer() {
		StringBuffer buffer = new StringBuffer();
		double tempoInicial = System.nanoTime();
		for (int i = 0; i < 32768 ; i++) {
			buffer.append("a");
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("Buffer ==>"+tempoTotal+" segundos.");
	}
	
	public void operacaoFrase(String frase) {
		String[] palavras = frase.split(" ");
		for (String palavra : palavras) {
			System.out.println(palavra);
		}
	}
	
	
}
