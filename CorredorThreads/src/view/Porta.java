package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPassageiro;

public class Porta {
	
	public static void main(String[] args) {
		int permissoes = 1;              
		Semaphore semaforo = new Semaphore(permissoes);      //
		for (int IDPessoa = 1; IDPessoa < 5; IDPessoa++) {   // 
			Thread pessoa = new ThreadPassageiro(IDPessoa, semaforo);
			pessoa.start();
		}
	}

}
