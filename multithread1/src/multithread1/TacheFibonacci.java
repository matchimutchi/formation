package multithread1;

public class TacheFibonacci extends Thread {

	//constructeur
	public TacheFibonacci(String name) {
		super(name);
	}
	
	
	//run(source -> overide/implement Methods -> run)
	@Override
	public void run() {
		for(int i = 0 ; i < 40 ; i++) {
			System.out.println(getName() + " ->" + fibonacci(i));
		}
	}

	
	//ceci est le calcul de fibonacci
	private long fibonacci(long n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
	
}
