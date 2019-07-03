package structureControle;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// les structures de controle se sont les elements du langage
		// permettant de faire des chiox/branchement, ou des répétitions (boucles)
		
		// comment demander une saisie à l'utilisateur
		// System.out -> sortie standard
		// System.in -> entree strandard
		
		// le Scanner est un objet new pour l'instancier et 
		//permet de lire ceux qui a été ecrit sur le clavier
		Scanner lecteur = new Scanner(System.in);
		System.out.println("quelle heure est-il?");
		// recupération saisie
		String saisie = lecteur.nextLine();
		
		// conversion de chaine -> chiffre
		int heure = Integer.parseInt(saisie);
		
		if (heure <= 10) {
			System.out.println("Bonjour, un café?");
		}
		else if(heure <= 12){
			System.out.println("ou sont les madeleines?");
		}
		else {
			System.out.println("bon appétit");
		}
		
		// == -> comparaison d'égalité
		// != -> différent
		
		if (heure == 17) {
			System.out.println("bon retour!");
		}

		System.out.println("code de votre pays?");
		// toLowerCase() mais la chaine de caractére en minuscule
		String code = lecteur.nextLine().toLowerCase();
		
		// le switch est possible sur les chaines de caractére
		switch(code) {
			case "be":
				System.out.println("La langue dans ce pays est le Flamand");
			case "fr" : 
				System.out.println("La langue dans ce pays est le Français");
				break;
			case "us":
			case "uk" :
				System.out.println("La langue dans ce pays est l'Anglais");
				break;
			case "es" :
				System.out.println("La langue dans ce pays est l'Espagnol");
				break;
			case "de":
				System.out.println("La langue dans ce pays est l'Allemand");
				break;
			default:
				System.out.println("La langue dans ce pays est l'Esperanto");
				break;
		
		}
		
		
		System.out.println("quelle est votre âge?");
		int age =Integer.parseInt(lecteur.nextLine());
		// operateur ternaire 
		// ? correspond à un if
		age = (age >= 0)? age : 0;
		System.out.println("votre age : " +age);
		

		
		
	}

}
