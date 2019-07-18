package multiThread3;

public class FibonacciRunnable implements Runnable {

	// ce que j'ai a traiter
	private TravailAttente travailAttente;
	
	//constructeur
	public FibonacciRunnable(TravailAttente travailAttente) {
		this.travailAttente = travailAttente;
	}

	@Override
	public void run() {
		try {
			//je calcul des valeur de fibonacci tant qu'il en reste dans le file d'attente
			while(true) {
				System.out.println("Travailleur " + Thread.currentThread().getName() +" attente nouvelle valeur");
				long valeur = travailAttente.getNextValue();
				System.out.println("Travailleur " + Thread.currentThread().getName() +" r�cup�re" + valeur);
				long resultat = fibonacci(valeur);
				System.out.println("Travailleur " + Thread.currentThread().getName() +" r�sultat calcul " + resultat);
			
		}
		}catch(RuntimeException ex) {
			System.out.println("file d'attente termin�");
		}
		System.out.println("travailleur " + Thread.currentThread().getName() + "fini!");
	}
	
	private long fibonacci(long n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
