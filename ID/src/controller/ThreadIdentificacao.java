package controller;

public class ThreadIdentificacao extends Thread{
		
	private int cont;
	 
	public ThreadIdentificacao(int cont) {
		this.cont = cont;
	}
	 
	@Override
	public void run() {
		id();
		// TODO Auto-generated method stub
		super.run();
	}
	 
	private void id() {
		// TODO Auto-generated method stub
			int n = cont;
			System.out.println( "Thread " + n + " ==> " + " ID " + getId());
	}
}




