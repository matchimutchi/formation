package tauxInteret;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);    
        int sommeInit;
        int pourcent;
        int sommeAt;
        int pourcentage;        
        int division;

        System.out.println("Quel est le pourcentage du taux? : ");
        
        pourcent = Integer.parseInt(lecteur.nextLine());
        
        System.out.println("Entrez la valeur de la somme initiale ");
        
        sommeInit = Integer.parseInt(lecteur.nextLine());
        
        System.out.println("Entrez la valeur de la somme a atteindre ");
        
        sommeAt = Integer.parseInt(lecteur.nextLine());
        
        
        int annee = 0;
        while(sommeInit < sommeAt) {
            division = sommeInit / 100;
            pourcentage = pourcent * division ;
            sommeInit = sommeInit + pourcentage;
        	annee++;
        }
        
        System.out.println("nombre d'année " + annee);
        

	}
	

	


}
