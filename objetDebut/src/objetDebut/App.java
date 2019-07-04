package objetDebut;

import objetDebut.metier.Livre;
import objetDebut.metier.Vecteur;

public class App {

	public static void main(String[] args) {
		
	/*	Livre l1;//livre non instancié -->
		l1 = new Livre();//j'ai instancié un livre mais vide
		// pour acceder aux attributs d'un objet, utiliser le "."
		l1.id = 1;
		l1.titre = "ghost in the shell";
		l1.auteur = "Masamune Shirow";
		l1.setNbPages(-200);
		l1.setPrix(-9.99);
		
		
		//pour appeler une méthode, utiliser '.'
		System.out.println("Livre 1 = " +l1.description());
		System.out.println("Livre 1 = " +"Il coute " + l1.getPrix() +" Euros");
		
		
		
		Livre l2 = new Livre();
		l2.id = 2;
		System.out.println("Livre 2 = " +l2.description());
		
		Livre l3 = new Livre(3,"dragon ball","akira toriyama", 120,8.99);
		System.out.println("Livre 3 = " + l3.description());*/
		
		System.out.println("----------------VECTEUR avec une instance static---------------");
		//debut du compteur
		System.out.println("nb vecteur creer" + Vecteur.getNbVecteurCree());
		
		
		
		
		System.out.println("----------------VECTEUR---------------");
		Vecteur v1 = new Vecteur(1.0,5.0,-2.0);
		Vecteur v2 = new Vecteur(2.0,4.0,0.5);
		
		System.out.println("-------------AFFICHE RESULTAT-----------------");
		System.out.println(v1);
		System.out.println(v2);
		
		
		System.out.println("-------------AJOUT v2 a v1-----------------");
		v1.add(v2);
		System.out.println(v1);
		
		System.out.println("-------------AJOUT v2 et v4-----------------");
		Vecteur v4 = new Vecteur(v2);
		System.out.println("v2 = " + v2);
		System.out.println("v4 = " + v4);
		
		System.out.println("-------------AJOUT v2 et v4-----------------");
		//v5 et v2 reference la meme instance de vecteur
		Vecteur v5 = v2;
		System.out.println("v2 == v5 --> " + (v2 == v5));
		System.out.println("v2 == v4  --> " + (v2 == v4));
		System.out.println("v2 == v1 --> " + (v2 == v1));
		
		// equals est une classe qui vient de la classe Object
		System.out.println("v2 equals v5 --> " + (v2.equals(v5)));
		System.out.println("v2 equals v4 --> " + (v2.equals(v4)));
		System.out.println("v2 equals v1 --> " + (v2.equals(v1)));
		
		
		System.out.println("----------------Compteur VECTEUR avec une instance static---------------");
		//fin  du compteur
		System.out.println("nb vecteur creer " + Vecteur.getNbVecteurCree());
	}

}
