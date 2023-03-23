package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;


public class Validacao {

	
	public static void main(String[] args) {
		int permissoes = 1;              
		Semaphore semaforo = new Semaphore(permissoes);      
		for (int IDComprador = 1; IDComprador < 300; IDComprador++) {    
			Thread compra = new ThreadBilheteria(IDComprador, semaforo);
			compra.start();
		}
	}

}
