package exerciceNewForm;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println("-------------------PALINDROME---------------");
		
//		
//		Scanner lecteurs = new Scanner(System.in);
//		System.out.println("Saisir un nom?");
//		String saisieNom = lecteurs.nextLine();
//	
//		
//		
//		// le switch est possible sur les chaines de caractére
//		switch(saisieNom) {
//			case "anna":
//				System.out.println("c'est un palindrome");
//				break;
//			case "toto" : 
//				System.out.println("Ce n'est pas un palindrome");
//				break;
//			case "kayak" :
//				System.out.println("c'est un palindrome");
//				break;
//			default:
//				System.out.println("Le nom n'est probablement pas un palindrome");
//				break;
//		
//		}
		
		
		System.out.println("saisissez un mot a tester");
		Scanner lecteur = new Scanner(System.in);
		String mot = lecteur.nextLine();
		
		int debut = 0;
		int fin = mot.length() -1;
		boolean estPalindrome = true;
		
		while(debut < fin) {
			if(mot.charAt(debut) != mot.charAt(fin)) {
				estPalindrome = false;
				break;
			}
			
			debut++;
			fin--;
		}
		
		if(estPalindrome) {
			System.out.println("c'est un palindrome");
		}else {
			
			System.out.println("ce n'est pas un palindrome");
		}

	}

}
