package performanceString;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner lecteur = new Scanner(System.in);
		
		System.out.println("appuyer sur entree pour démarrer");
		lecteur.nextLine();
		long debut = System.currentTimeMillis();
		
		
		String buffer = "";
		for(int i = 0; i < 200000 ; i++) {
			buffer += "ho";
			// tout les 1000 afficher le message 
			if(i% 1000 == 0) {
				System.out.println("iteration no " + i );
			}
		}
		
		long fin = System.currentTimeMillis();
		System.out.println("terminé en " + ((fin - debut)/ 1000.0)+ " secondes");
		
		System.out.println("appuyer sur entree pour démarrer");
		lecteur.nextLine();
		
		
		debut = System.currentTimeMillis();
		// la classe StringBuilder est spécialement dédiée
		// au manipulation de chaine massive et répété
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 200000 ; i++) {
			sb.append("ho");
			// tout les 1000 afficher le message 
			if(i% 1000 == 0) {
				System.out.println("iteration no " + i + " - " + sb.capacity());
			}
		}
		
		buffer = sb.toString();
		fin = System.currentTimeMillis();
		System.out.println("terminé en " + ((fin - debut) / 1000.0) + "seconde");
	}

}
