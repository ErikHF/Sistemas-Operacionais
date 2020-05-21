package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCar;

public class Park {
	
	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int IDCar = 0; IDCar < 10; IDCar++) {
			Thread car = new ThreadCar(IDCar, semaforo);
			car.start();
		}
	}

}
