package controller;

import java.util.concurrent.Semaphore;

public class ThreadCar  extends Thread{
	
	private int IDCar;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadCar(int IDCar, Semaphore semaforo) {
		this.IDCar = IDCar;
		this.semaforo = semaforo;
			}
	
		private void carroAndando() {
			int distanciaTotal = (int)((Math.random() * 2001) + 1000);
			int distanciaPercorrida = 0;
			int deslocamento = 100;
			int tempo = 30;
			while (distanciaPercorrida < distanciaTotal) {
				distanciaPercorrida += deslocamento;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Carro #" + IDCar + " já percorreu " + distanciaPercorrida + "m. ");
			}
			posChegada++;
			System.out.println("Carro #" + IDCar + " foi o " + posChegada + "º a chegar. ");
		}
		
		private void carroEstacionado() {
			System.out.println("Carro #" + IDCar + " estacionou. ");
			int tempo = (int)((Math.random() * 2001) + 1000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private void carroSaindo () {
		 posSaida++;
		 System.out.println("O Carro#" + IDCar + " foi o " + posSaida + "º a sair. ");
		}
		
		@Override		
		public void run() {
			carroAndando();
			try {
				semaforo.acquire();
				carroEstacionado();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				carroSaindo();
			}
		}	
	}
