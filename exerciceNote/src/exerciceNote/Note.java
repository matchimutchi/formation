package exerciceNote;

import java.util.Scanner;

public class Note {

	public static void main(String[] args) {
		
		
		System.out.println("-------------------NOTE---------------");
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Combien de notes avez vous?");
		String saisie = lecteur.nextLine();
		
		// conversion de chaine -> chiffre
		int nbNote = Integer.parseInt(saisie);
		
		double total = 0.0;
		int compteur = 0;
		while(compteur < nbNote) {
			System.out.println("qu'elle est votre note?");
			String notestr = lecteur.nextLine();
			int note = Integer.parseInt(notestr);
			total = total + note;
			compteur++;
	
		}
		
		System.out.println("Ta moyenne est de " + total / nbNote);
		
		total = total/nbNote;
		
		if(total < 10) {
			System.out.println("Tu redoubles");
		}else {
			System.out.println("Félicitation tu passes en classe supérieur");
		}
		

		
	}

}
