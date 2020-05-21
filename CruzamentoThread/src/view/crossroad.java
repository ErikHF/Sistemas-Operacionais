package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class crossroad {
	
	public static void main(String[] args) {
		int permissoes = 2;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int IDCar = 0; IDCar < 10; IDCar++) {
			Thread car = new ThreadCarro(IDCar, semaforo);
			car.start();
		}
	}
}