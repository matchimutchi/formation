package tableauFichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// tableau basique en java
		// type [] -> variable tableau
		// c'est un type reference
		
		String[] villes = {"Paris","Lyon", "Bordeux", "Toulouse","Nantes"};
		//numeroté a partir de 0
		System.out.println(villes[3]);
		
		villes[3] = "Dax";
		//affichage du tableau
		System.out.println(Arrays.toString(villes));
		
		System.out.println("---------------Tableau Simple String--------------");
		//variable tableau non initialisée
		String[] plats;
		//allouer/creer un tableau avec le mot clef new
		// attention, les tableaux basique java sont de taille fixe crée
		plats = new String[4];// tableau de 4 chaine de caracteres
		plats[0] = "poulet frites";
		plats[1] = "pizza 4 fromages";
		plats[2] = "salade landaise";
		plats[3] = "lasagne fait maison";
		
		
		//parcours du tableau
		for(int position = 0; position < plats.length; position++) {
			System.out.println(plats[position]);
		}
		
		System.out.println(Arrays.toString(plats));
		
		System.out.println("\n");
		// redimensionné le tableau ( plats = new String[4];)
		plats = Arrays.copyOf(plats, 6);
		plats[4] = "beignets de crevette";
		plats[5] = "raviolis";
		System.out.println(Arrays.toString(plats));
		
		
		double [][] matrice1 = {
				{4.5,2.3,11},
				{8.5,-2.3,5},
				{3.3,0.5,7.4,1.8}
		};
		
		//deeptoString va ecremente les nombre
		System.out.println(Arrays.deepToString(matrice1));
		
		
		//afficher le deuxieme tableau et le troisieme nombre
		System.out.println("---------------Tableau simple--------------");
		System.out.println(matrice1[1][2]);
		System.out.println(matrice1.length);
		System.out.println(matrice1[2].length);
		
		
		
		System.out.println("---------------Tableau multiple--------------");
		//allocation "manuelle" d'un tableau de double bidimensionel régulier
		double [][] matrice2 = new double[3][4];
		System.out.println(Arrays.deepToString(matrice2));
		
		
		System.out.println("---------------ACCES FICHIER--------------");
		//acces fichier
		// la classe File permet de manipuler des fichiers et repertoires
		// une instance de File represente un fichier
		File fichier = new File("noms");
		// fichier.exists permet de savoir si le fichier existe
		if(fichier.exists()) {
			// lecteur sur le fichier
			Scanner lecteur = new Scanner(fichier);
			// hasNext sert a savoir si il reste quelque chose à lire dans le fichier
			while(lecteur.hasNext()) {
				//affiche la ligne
				System.out.println(lecteur.nextLine());
			}
			// refermer le fichier en lecteur
			lecteur.close();
		}
	}

}
