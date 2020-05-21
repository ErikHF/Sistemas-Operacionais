package controller;

public class ThreadSoma extends Thread{
	
	private int Mat[][] = new int [3] [5];
	private int i;
	private int j;
	
	public ThreadSoma (int Mat[][], int i, int j){
		
		this.Mat = Mat;
		this.i = i;
		this.j = j;
	}
	
	@Override
	public void run(){
			if (i < 1){
				PreencherMatriz();	
			}
			if (Mat[i][j] > 0){
				SomaMatriz();
			}
			else
			{
				i--;
			}
		super.run();
	}

	private void PreencherMatriz() {

		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 5; j++){
				Mat[i][j] = (int)((Math.random()*101) + 4);
				System.out.println("Valor matriz " + i + " " + j + " " + " é " + Mat[i][j]);
			}
		}
		
	}
	
	private void SomaMatriz(){
		int linha = i + 1;
		int Soma = 0;
		for (int j = 0; j < 5; j++){
			Soma = Soma + Mat[i][j];
		}
		System.out.println("ID" + getId() + " => " + " A soma da linha " + linha + " vale " + Soma);
	}
}
