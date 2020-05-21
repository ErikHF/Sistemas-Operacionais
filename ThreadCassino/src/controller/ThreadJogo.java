package controller;

public class ThreadJogo extends Thread{

	private int ponto;
	private int jogador;
	private static int colocacao;
	
	public ThreadJogo (int ponto, int jogador ) {
		
		this.ponto = ponto;
		this.jogador = jogador;
		
	}
	
	private void JogarDados () {
		do {
			int soma = 0;
			for (int i = 0; i < 2; i++) {
			int tempo = (int)((Math.random() *12) + 3);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int dado = (int)((Math.random() * 5) + 1);
			soma = dado + soma;
				if (soma == 7 || soma == 11) {
					ponto = ponto + 1;		
					System.out.println("Jogador " + jogador + " marcou 1 ponto.  " + " / " + "total de pontos: " + ponto );
				}	
			}
		} while (ponto != 5 && colocacao <= 3);

	}
		private void Premio () {
			colocacao++;
			double premio[] = new double [3];
			premio[0] = 5000.00;
			premio[1] = 4000.00;
			premio[2] = 3000.00;
			if (colocacao <= 3){
				System.out.println("O jogador " + jogador + " foi o " + colocacao + "º a marcar 5 pontos e recebeu o prêmio de " + premio[colocacao -1] + " reais.");
				
			}
			
		}
		
		@Override
		public void run() {
			try {
				JogarDados ();
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				if (colocacao <= 3) {
				Premio ();					
				}
				
			}
	}
}
			
			
