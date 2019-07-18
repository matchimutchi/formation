package multiThread3;

import java.util.concurrent.Callable;

public class FibonacciCollable implements Callable<String> {

	private long value;
	private String workerName;
	
	//constructeur
	public FibonacciCollable(long value, String workerName) {
		this.value = value;
		this.workerName = workerName;
	}

	// je renvoie un message avec le resultat du calcul
	@Override
	public String call() throws Exception {
		System.out.println(" Calcul par thread" + Thread.currentThread().getName() + " pour " + value + " avec worker " + workerName);
		//return Thread.currentThread().getName() + "fibonacci de " + value + " = " + fibonacci(value);
		return workerName + " fibonacci de " + value + " = " + fibonacci(value);
	}

	private long fibonacci(long n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
