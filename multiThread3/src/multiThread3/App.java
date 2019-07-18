package multiThread3;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		
		//interface fonctionnelle
		// collable est un runnable mais qui renvoi un resultat
		
		//TravailAttente ta = new TravailAttente(40);
		
		//un executorService va se charger a votre place d'instancier et gerer les thread
		// on fourni au service les runnable a executer
		// le executoService se charge de presque tt reste
		
		//poom de 4 thread pret a executer nos runnable
		/*ExecutorService executeur = Executors.newFixedThreadPool(8);
		
		FibonacciRunnable f1 = new FibonacciRunnable(ta);
		FibonacciRunnable f2 = new FibonacciRunnable(ta);
		FibonacciRunnable f3 = new FibonacciRunnable(ta);
		FibonacciRunnable f4 = new FibonacciRunnable(ta);
		FibonacciRunnable f5 = new FibonacciRunnable(ta);
		FibonacciRunnable f6 = new FibonacciRunnable(ta);
		FibonacciRunnable f7 = new FibonacciRunnable(ta);
		FibonacciRunnable f8 = new FibonacciRunnable(ta);
		
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Appuyer sur entre pour démarrer");
		reader.nextLine();
		
		long debut = System.currentTimeMillis();
		
		
		//DEBUT execution
		System.out.println("Je soumet mes taches a l'executeur");
		executeur.execute(f1);
		executeur.execute(f2);
    	executeur.execute(f3);
		executeur.execute(f4);
		executeur.execute(f5);
		executeur.execute(f6);
    	executeur.execute(f7);
		executeur.execute(f8);
		System.out.println("J'attend la fin de toutes mes taches");
		
		//arret "propre" de l'executeur il terminera les taches en cours,
		// et n'en accepte plus
		executeur.shutdown();
		
		//j'attend 2 min avant la fin
		try {
			executeur.awaitTermination(2, TimeUnit.MINUTES);
			System.out.println("Fini d'executer!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Fin execution
		long fin = System.currentTimeMillis();
		System.out.println("Temps écoulé: " + (fin - debut) + "millisecondes");*/
		
		
		//ExecutorService executeur = Executore.newFixedThreadPool(8);
		
		ExecutorService executeur = Executors.newFixedThreadPool(4);
		ArrayList<FibonacciCollable> workers = new ArrayList<>();
		Random rd = new Random();
		for(int i = 0; i < 40; i++) {
			workers.add(new FibonacciCollable((int)(38 + rd.nextInt(5)),  " worker no " + i));
			
		}
		
		ArrayList<Future<String>> resultats = new ArrayList<>();
		
		for(FibonacciCollable w : workers) {
			resultats.add(executeur.submit(w));
		}
		
		//on arrete l'executeur
		executeur.shutdown();
		
		
		try {
			
			Thread.sleep(4000);
			System.out.println("future alors que pas terminé");
			for(Future<String> result : resultats) {
				if(result.isDone()) {
					System.out.println(result.get());
				}else {
					System.out.println("pas fini");
				}	
			}

			executeur.awaitTermination(2, TimeUnit.MINUTES);
			System.out.println("Fini d'executer!");
			System.out.println("Les résultats");
			for(Future<String> result : resultats) {
				System.out.println(result.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
		File f = new File("C:\\Program FIles");
		if(f.exists() && f.isDirectory()) {
			String[] names = f.list();
			for(String name : names ) {
				System.out.println(name);
			}
		}
		

	}

}
