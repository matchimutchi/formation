package etoile;

import java.util.Scanner;

public class FormeEtoile {

	public static void main(String[] args) {
		System.out.println("-------------------TRIANGLE---------------");
		
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Taille de votre triangle?");
		int taille = Integer.parseInt(lecteur.nextLine());

        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colonne = 0; colonne < taille-ligne; colonne++) {
            	// est ce un caractere de bord
                if(ligne == 0 || colonne == 0 || colonne == taille-ligne -1)
                	System.out.print("*");
                else
                	System.out.print("-");
            }

            System.out.println("");
        }
        
        System.out.println("-------------------LOSANGE---------------");
        
        System.out.println("Taille de votre losange?");
        taille = Integer.parseInt(lecteur.nextLine());
        
        int demitaille = taille / 2;
        String losangeHaut = "";
        String losangeBas = "";
        for(int ligne = 0; ligne <= demitaille; ligne++) {
        	String texteLigne = "";
        	//affichage du retrait
        	for(int marge = 0; marge < demitaille - ligne; marge++) {
        		texteLigne += " ";
        	}
        	// affichege de la ligne du losange
        	for(int colonne = 0; colonne < ligne * 2 +1; colonne++) {
        		if(colonne == 0 || colonne ==  ligne * 2) {
        			texteLigne += "*";
        		}else {
        			texteLigne += "-";
        		}
        		}
        		texteLigne += "\n";
        		losangeHaut += texteLigne;
        		if(ligne < demitaille) {
        			losangeBas = texteLigne + losangeBas;
        		}
        		
        	
        	System.out.println(losangeHaut + losangeBas);
        }
        
        

	}

}
