package view;

import controller.ThreadIdentificacao;

public class Principali {
	
	public static void main (String[] args) {
		
		  int cont = 0;
		
	   	  for (cont = 0; cont <= 100; cont ++) {
	   		 Thread tcc = new ThreadIdentificacao(cont);
	   		 tcc.start();  
	   	  }
	}
}
