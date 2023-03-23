package controller;

import java.util.concurrent.Semaphore;  

public class ThreadBilheteria extends Thread {
	
	private int IDComprador;
	private static int estoque= 100;
	private Semaphore semaforo;
	
	public ThreadBilheteria(int IDComprador, Semaphore semaforo) {
		this.IDComprador = IDComprador;  
		this.semaforo = semaforo;
			}
	
	private void tempoLogin() {
		double t_espera = (Math.random() * 1.95) + 0.05;
		int t_limite = 1;
		
		if (t_espera > t_limite) {
			System.out.println("Comprador " + IDComprador + " expirou o seu tempo de login. ");
		}
		else {
			try {
				sleep((int)t_espera);                               
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			
		}

	}
	
	private void processoCompra() {
		double t_processo = (Math.random() * 3) + 1;
		double t_lim = 2.5;
		
		if (t_processo > t_lim) {
			System.out.println("Comprador " + IDComprador + " estourou o seu tempo de compra. ");
		}
		else {
			try {
				sleep((int)t_processo);                               
			} catch (InterruptedException e) {
			e.printStackTrace();			
			}
	   }
	}
	
   private void validacao() {
	   int pedido = (int)(Math.random() * 4) + 1;  	  
	   if (pedido > estoque) {
		   System.out.println("Não há ingressos suficientes.");
	     }
	   else {
		   System.out.println("Comprador " + IDComprador + " adquiriu " + pedido + " ingressos. ");
		   estoque = estoque - pedido;
		   System.out.println("Restam " + estoque + " ingressos.");
	   }
	  }   
		@Override		
		public void run() {
			tempoLogin();
			try {
				semaforo.acquire();
				processoCompra();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				validacao();
			}
		}	

}
