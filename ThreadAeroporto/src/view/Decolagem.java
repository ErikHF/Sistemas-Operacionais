package view;

import java.util.concurrent.Semaphore; 

import controller.ThreadAeroporto;

public class Decolagem {
	
	
	public static void main(String[] args) {
		int permissoes = 2;              
		Semaphore semaforo = new Semaphore(permissoes);      
		for (int IDAviao = 1; IDAviao < 12; IDAviao++) {    
			Thread voo = new ThreadAeroporto(IDAviao, semaforo);
			voo.start();
		}
	}


}
