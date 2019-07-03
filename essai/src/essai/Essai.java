package essai;

import java.util.Scanner;

public class Essai {

	public static void main(String[] args) {
		
		
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Combien de note avez vous?");
		String saisie = lecteur.nextLine();
		int nbNote = Integer.parseInt(saisie);
		
		double total = 0.0;
		int compteur = 0;
		while(compteur < nbNote) {
			System.out.println("Quelle est votre note?");
			String saisies = lecteur.nextLine();
			int note = Integer.parseInt(saisies);
			total = total + note;
			
			compteur++;
			
		}
		System.out.println("Votre moyenne est " + total /nbNote);

	}

}
