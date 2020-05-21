package controller;

public class ThreadCalcController extends Thread {

	private int a, b, operacao;
	
	public ThreadCalcController(int a, int b, int operacao) {
		this.a = a;
		this.b = b;
		this.operacao = operacao;		
	}
	
	@Override
	public void run() {
		calc();
	    // TODO Auto-generated method stub
		super.run();
	}

	private void calc() {
		// TODO Auto-generated method stub
		String op ="";
		int res = 0;
		switch (operacao) {
		case 0:
			res = a + b;
			op = "+";
			break;
		case 1:
			res = a - b;
			op = "-";
			break;
		case 2:
			res = a * b;
			op = "*";
			break;
		case 3:
			res = a / b;
			op = "/";
			break;
		}
		System.out.println(getId()+" ==> " + a + " " + op + " " + b + " = " + res);
	}
}
