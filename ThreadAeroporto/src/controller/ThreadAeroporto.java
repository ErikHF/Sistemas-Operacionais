package controller;

import java.util.concurrent.Semaphore; 

public class ThreadAeroporto extends Thread {

	private int IDAviao;
	private Semaphore semaforo;
	
	public ThreadAeroporto(int IDAviao, Semaphore semaforo) {
		this.IDAviao = IDAviao;  
		this.semaforo = semaforo;
			}
	
	private void manobra() {
		double t_manobra = (Math.random() * 5) + 3;
		System.out.println("Aviâo " + IDAviao + " foi manobrado. ");
		try {
			sleep((int)t_manobra);                               
		} catch (InterruptedException e) {
		e.printStackTrace();
		}		
		
 
	}
	
	private void taxiamento() {
		double t_taxiamento = (Math.random() * 6) + 5;
		System.out.println("Aviâo " + IDAviao + " foi taxiado. ");
		try {
			sleep((int)t_taxiamento);                               
		} catch (InterruptedException e) {
		e.printStackTrace();
		}		
		
 
	}
	
	private void decolagem() {
		double t_decolagem = (Math.random() * 4) + 1;
		System.out.println("Aviâo " + IDAviao + " decolou. ");
		try {
			sleep((int)t_decolagem);                               
		} catch (InterruptedException e) {
		e.printStackTrace();
		}		
		
 
	}
	private void afastamento() {
		double t_afastamento = (Math.random() * 5) + 3;
		System.out.println("Aviâo " + IDAviao + " se afastou da área. ");
	
		try {
			semaforo.acquire();
			sleep((int)t_afastamento);                               
		} catch (InterruptedException e) {
			e.printStackTrace();
			}	
	}
		@Override		
		public void run() {
			manobra();
			taxiamento();
			try {
				semaforo.acquire();
				decolagem();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {						
				semaforo.release();
				afastamento();
			}
		}
	}


		
 

