package multithread1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// quand votre programme démarre
		// il y a en fait un Thread en execution
		//généralement appelé "Main"
		
		//pour exploiter la programmation multiThread
		//il nous faut des instances de Thread(une par tache parallele)
		//plusieurs strategie possibles
		// -> instancier un Thread basique et lui passer en parametre
		// un objet qui implements l'interface Runnable
		// -> creer une classe héritant de la classe Thread, et overrider
		//certaines des méthodes
		// -> utiliser les services d'un Executor
		
		
		/*TacheFibonacci t1 = new TacheFibonacci("worker fib A");
		Scanner reader = new Scanner(System.in);
		System.out.println("Appuyer sur entrer pour démarrer");
		reader.nextLine();
		// pour voir le temp ecoulé
		long debut = System.currentTimeMillis();
		
		//premiere boucle fibonacci
		t1.run();
		//deuxieme boucle
		t1.run();
		long fin = System.currentTimeMillis();
		
		System.out.println("Fini ! en " + (fin - debut) + " millisecondes");
		

		TacheFibonacci t2 = new TacheFibonacci("worker fib B");
		TacheFibonacci t3 = new TacheFibonacci("worker fib C");
		
		System.out.println("Appuyer sur entrer pour démarrer");
		reader.nextLine();
		// pour voir le temp ecoulé
		debut = System.currentTimeMillis();
		// ca execute le contenu de run dans un veritable thread en parallele
		t1.start();
		t2.start();
		t3.start();
		// on a 3 thread : Main , t2 et t3
		System.out.println("thread lancés");
		
		//pour attendre et ralentir le processuce
		try {
			t1.join();
			//attendre la fin du thread t2
			t2.join();
			//attendre la fin du thread t3
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fin = System.currentTimeMillis();
		System.out.println("Fini ! en " + (fin - debut) + " millisecondes");*/
		
		
		Runnable r1 = new RunEnableFibonacci();
		Runnable r2 = new RunEnableFibonacci();
		
		//r1.run
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Appuyer sur entrer pour démarrer");
		reader.nextLine();
		
		long debut = System.currentTimeMillis();
		t1.start();
		t2.start();

		try {
			System.out.println("J'attend la fin de t1 et t2");
			t1.join();
			t2.join();
			System.out.println("Fini!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long fin = System.currentTimeMillis();
		System.out.println("Fini ! en " + (fin - debut) + " millisecondes");

	} 

}
