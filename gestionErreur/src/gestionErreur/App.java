package gestionErreur;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		// le code a surveiller
		try {
			
			int age = saisieAge();
			System.out.println("Vous avez " + age +" ans");
//		System.out.println("quel est votre age");
//		int age = Integer.parseInt(reader.nextLine());
//
//		System.out.println("vous avez " + age + " ans");
		}	
		// gestion des erreurs pour le bloc de code juste avant (le try)
		catch (NumberFormatException ex) {
			System.out.println("erreur de format : " + ex.getMessage());
		}
		catch(AgeException ex) {
			System.out.println("Vous mentez" + ex.getMessage());
		}
		catch (Exception ex) {
			System.out.println("autre erreur : " + ex.getMessage());
		}
		
		System.out.println("fini!!!!!!!!!!!!");

	}
	
	
	public static int saisieAge(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Quel est votre age?");
		int age = Integer.parseInt(reader.nextLine());
		if( age < 0) {
			throw new AgeException(" Un age ne peut �tre n�gatif");
		}
		return age;
	}

}
