
package controller;

import java.util.concurrent.Semaphore;

public class ThreadCompra extends Thread{
	private int clientID;
	private static int ingressos = 100;
	private int pedido;
	private Semaphore semaforo;
	
	public ThreadCompra (int clientID, int pedido, Semaphore semaforo) {
		this.clientID = clientID;
		this.semaforo = semaforo;
		this.pedido = pedido;
		
	}
	
	private boolean login() {
		int tempo = (int)((Math.random()*196)+5);
		try {
			sleep (tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo > 100) {
			System.out.println("Time out - cliente " + clientID + " não pôde concluir o login.");
			return false;
		}
		else {
			System.out.println("Cliente " + clientID + " concluiu o seu login.");
			return true;
		}
		
	}
	private boolean pedido() {
		int tempo = (int)((Math.random()*201)+100);
		pedido = (int)((Math.random()*4)+1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo > 250) {
			System.out.println("Time out - cliente " + clientID + " não pôde realizar o seu pedido.");
			return false;
		}
		else {
			System.out.println("Cliente " + clientID + " realizou o pedido de " + pedido + " ingressos.");
			return true;
		}
	}	
	private void validacao() {
		if (pedido <= ingressos) {
			ingressos = ingressos - pedido;
			System.out.println("cliente " + clientID + " comprou " + pedido + " ingressos com sucesso.");
			if (ingressos > 0){
				System.out.println("Restam " + ingressos + " ingressos.");	
			}
			else {
				System.out.println("Esgotaram os ingressos.");
			}
		}
		else {
			System.out.println("cliente " + clientID + "  não pôde comprar ingressos pois o número de pedidos está acima da quantia restante.");
		}
	}
	
	@Override
	public void run() {
		login();
		if (ingressos > 0) {
			try {
				semaforo.acquire();
				pedido();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
					validacao();
			}
		}

		
		
	}
}
