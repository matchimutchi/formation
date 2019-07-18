package multiThread2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		CompteurPartage cp1 = new CompteurPartage(0);
		
		IncrementeWorker w1 = new IncrementeWorker(cp1);
		IncrementeWorker w2 = new IncrementeWorker(cp1);
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Appuyer sur entre pour démarrer");
		reader.nextLine();
		
		long debut = System.currentTimeMillis();
		System.out.println(cp1);
		//w1.run();
		//w2.run();
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		
		t1.start();
		t2.start();
		
		try {
			System.out.println(" Attente de t1 et t2");
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(cp1);
		long fin = System.currentTimeMillis();
		System.out.println("Temps écoulé: " + (fin - debut) + "millisecondes");
		

	}

}
