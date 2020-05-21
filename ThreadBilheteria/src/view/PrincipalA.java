package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCompra;

public class PrincipalA {
	
	public static void main(String[] args) {
		int permissoes = 1;
		int pedido = 0;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int clientID = 0; clientID < 300; clientID++) {
			Thread compra = new ThreadCompra(clientID, pedido, semaforo);
			compra.start();
		}
	}

}
