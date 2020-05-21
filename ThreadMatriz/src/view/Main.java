package view;

import controller.ThreadSoma;

public class Main {
	static int Mat[][] = new int [3][5];
	int i;
	static int j;
	
	
	public static void main (String[] args){

		for(int i = 0; i <= 3; i++){
			Thread tcc = new ThreadSoma(Mat, i, j);
			tcc.start();
		}
		
	}

}
