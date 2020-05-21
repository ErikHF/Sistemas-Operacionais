package controller;

import java.util.concurrent.Semaphore;                          

public class ThreadPassageiro  extends Thread{   
	                                                            
	private int IDPessoa;                
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadPassageiro(int IDPessoa, Semaphore semaforo) {
		this.IDPessoa = IDPessoa;                               
		this.semaforo = semaforo;
			}
	
		private void pessoaAndando() {
			int distanciaTotal = 200;                           
			int distanciaPercorrida = 0;                        
			int deslocamento = (int)(Math.random() * 3) + 4;    
			int tempo = 1;                                      
			while (distanciaPercorrida < distanciaTotal) {
				distanciaPercorrida += deslocamento;            
				try {
					sleep(tempo);                               
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Passageiro " + IDPessoa + " percorreu " + distanciaPercorrida + "m. ");
			}
			posChegada++;
			System.out.println("Passageiro " + IDPessoa + " foi a " + posChegada + "º a chegar. ");
		}
		
		private void pessoaEsperando() {                        
			System.out.println("Passageiro " + IDPessoa + " está cruzando a porta. "); 
			int tempo = (int)((Math.random() * 2) + 1);
			try {
				sleep(tempo);                                  
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private void pessoaSaindo () {
		 posSaida++;
		 System.out.println("O passageiro " + IDPessoa +" foi a "+ posSaida + "ª a passar pela porta. ");
		}
		
		@Override		
		public void run() {
			pessoaAndando();
			try {
				semaforo.acquire();
				pessoaEsperando();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				pessoaSaindo();
			}
		}	
	}
