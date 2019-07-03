package calendrier;

import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class App {

	public static void main(String[] args) {
		Scanner lecteur = new Scanner(System.in);
		System.out.println("anne ?");
		int annee = Integer.parseInt(lecteur.nextLine());
		System.out.println("mois ?");
		int mois = Integer.parseInt(lecteur.nextLine());
		
		calendrier(annee, mois);
		
		//System.out.print( nomMois(mois)+" " + annee);
		
	}
	
	public static void calendrier(int annee, int mois) {
		calendrier_header(annee, mois);
		System.out.println(nbJoursMois(annee, mois ));
	}
	
	public static void calendrier_header(int annee, int mois) {
		System.out.println("      "+ nomMois(mois) +"      " + annee);
		System.out.println("LUN MAR MER JEU VEN SAM DIM");
		if(estBissextile(annee)) {
		System.out.println("C'est une année bissextile");
		}else {
			System.out.println("Ce n'est pas une année bissextile");
		}
	}
	
	public static String nomMois(int mois) {
		switch (mois) {
		case 1:	return "Janvier";
		case 2: return "Février";
		case 3: return "Mars";
		case 4: return "Avril";
		case 5: return"Mai";
		case 6: return"Juin";
		case 7: return "Juillet";
		case 8: return "Aout";
		case 9: return "Septembre";
		case 10: return "Octobre";
		case 11: return"Novembre";
		case 12: return "Decembre";
		}
	return "";
	}
	
	
	public static int nbJoursMois(int annee, int mois) {
		switch(mois) {
			case 1: 
			case 3 : 
			case 5 : 
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				return 31;
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				return 30;
			case 2 :
				return (estBissextile(annee))? 29 : 28 ;		
		}
		return 0;
	}
	
	
	public static boolean estBissextile(int annee) {
		return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0) ;

	}

}
