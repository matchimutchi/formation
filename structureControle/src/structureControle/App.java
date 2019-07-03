package structureControle;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// les structures de controle se sont les elements du langage
		// permettant de faire des chiox/branchement, ou des r�p�titions (boucles)
		
		// comment demander une saisie � l'utilisateur
		// System.out -> sortie standard
		// System.in -> entree strandard
		
		// le Scanner est un objet new pour l'instancier et 
		//permet de lire ceux qui a �t� ecrit sur le clavier
		Scanner lecteur = new Scanner(System.in);
		System.out.println("quelle heure est-il?");
		// recup�ration saisie
		String saisie = lecteur.nextLine();
		
		// conversion de chaine -> chiffre
		int heure = Integer.parseInt(saisie);
		
		if (heure <= 10) {
			System.out.println("Bonjour, un caf�?");
		}
		else if(heure <= 12){
			System.out.println("ou sont les madeleines?");
		}
		else {
			System.out.println("bon app�tit");
		}
		
		// == -> comparaison d'�galit�
		// != -> diff�rent
		
		if (heure == 17) {
			System.out.println("bon retour!");
		}

		System.out.println("code de votre pays?");
		// toLowerCase() mais la chaine de caract�re en minuscule
		String code = lecteur.nextLine().toLowerCase();
		
		// le switch est possible sur les chaines de caract�re
		switch(code) {
			case "be":
				System.out.println("La langue dans ce pays est le Flamand");
			case "fr" : 
				System.out.println("La langue dans ce pays est le Fran�ais");
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
		
		
		System.out.println("quelle est votre �ge?");
		int age =Integer.parseInt(lecteur.nextLine());
		// operateur ternaire 
		// ? correspond � un if
		age = (age >= 0)? age : 0;
		System.out.println("votre age : " +age);
		

		
		
	}

}
