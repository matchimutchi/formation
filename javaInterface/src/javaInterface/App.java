package javaInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class App {

	public static void main(String[] args) {
		
		
		ArrayList<Voiture> voitures = new ArrayList<>();
		
		voitures.add(new Voiture("peugot 206", 80, "rouge", LocalDate.of(1998, 10, 15)));
		voitures.add(new Voiture("tesla model s", 150, "bleu", LocalDate.of(2018, 12, 17)));
		voitures.add(new Voiture("alpha romeo guiletta", 120, "blanche", LocalDate.of(2005, 8, 30)));
		voitures.add(new Voiture("nissan leaf", 100, "rouge", LocalDate.of(2010, 10, 15)));
		
		for(Voiture v : voitures) {
			System.out.println(v);
		}
		
		
		//Pour pouvoir afficher ce gars modifier la Class Voiture ( implement Comparable )
		Collections.sort(voitures);
		
		
		System.out.println("-------------code trié grace à collection.sort-----------");
		for(Voiture v : voitures) {
			System.out.println(v);
		}
		
		
		//une voiture herite de l'interface Comparable, donc c'est un type particulier de comparaison
		//on ajoute une voitue a comparable de la class Voiture
		// Comparable est type d'interface
		Comparable<Voiture> cp1= new Voiture("peugeot 206", 80, "rouge", LocalDate.of(1998, 10, 15));
		
		//
		System.out.println("----------afficher la voiture ajouter dans la Class Comparable---------");
		
		System.out.println("\n");
		
		System.out.println("---------------Démonstration avec un tableau String-----------");
		//demonstration avec les string pas de besoin de comparable si c'est des string
		ArrayList<String> plats = new ArrayList<>();
		plats.add("poulet frite");
		plats.add("saumon riz");
		plats.add("paella savoyarde");
		
		// String fait déjà parti de Comparable sans même lui indiqué
		Collections.sort(plats);
		for(String p : plats) {
			System.out.println(p);
		}
		
		//Ajouter une comparaison
		Comparable<String> cp2 = "bonjour";
		
		//Comparer au revoir avec bonjour
		System.out.println("au revoir".compareTo((String) cp2));
		System.out.println("\n");
		System.out.println("--------AJOUTER DES COMPTES-----------");
		ArrayList<Compte> comptes = new ArrayList<>();
		comptes.add(new CompteSG(1500,"123456"));
		comptes.add(new CompteSG(1800,"126498"));
		comptes.add(new CompteSG(1200,"789456"));
		
		
		for(Compte c : comptes) {
			System.out.println(c);
		}
		System.out.println("--------------AJOUTER 250EUROS---------------");
		for(Compte c : comptes) {
			c.deposer(250);
		}
		
		for(Compte c : comptes) {
		System.out.println(c);
		}
		System.out.println("\n");
		System.out.println("--------------Transferer de l'argent d'un compte à un autre---------------");
		//transférer de l'argent à un autre
		// creer une methode
		
		CompteSG csg1 = new CompteSG(500,"123456");
		CompteLCL clcl1 = new CompteLCL(300,"454712");
		System.out.println("-----COMPTE CSG--------");
		System.out.println(csg1);
		System.out.println("------COMPTE LCL-------");
		System.out.println(clcl1);
		System.out.println("------TRANSFERT DU COMPTE CSG AU COMPTE LCL-------");
		System.out.println("\n");
		//appelle de la method transfert et donnée des argument 
		transfert(csg1,clcl1,150);
		System.out.println("-----COMPTE CSG avec -150 euros--------");
		System.out.println(csg1);
		System.out.println("------COMPTE LCL avec +150euros-------");
		System.out.println(clcl1);
		
		//impossible de mettre en negatif le compte cela passe en false
		// du coup la method ne s'applique pas
		System.out.println("\n");
		System.out.println("----------ajout 1500 euros impossible");
		transfert(csg1,clcl1,1500);
		System.out.println("-----COMPTE CSG avec -150 euros--------");
		System.out.println(csg1);
		System.out.println("------COMPTE LCL avec +150euros-------");
		System.out.println(clcl1);

	}
	
	// cette fonction travail sur l'interface compte
	// elle marchera pour toutes class qui implemente cette interface
	// pas besoin de connaitre le type concret du compte
	//déclaration des arguments
	public static boolean transfert(Compte source, Compte destination, double somme) {
		if(source.retirer(somme)) {
			destination.deposer(somme);
			return true;
		}
		return false;
	}
}
