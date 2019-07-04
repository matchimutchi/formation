package exerciceMateriel;

import exerciceMateriel.article.Articles;
import exerciceMateriel.article.Materiel;

public class App {

	public static void main(String[] args) {
		Materiel m1;
		Articles a1;
		a1 = new Articles("lenovo","Jolie","ordinateur");
		m1 = new Materiel("12456","Bordeaux",3,a1);
		
		Materiel m2;
		Articles a2;
		a2 = new Articles("Asus","Pourri","ordinateur");
		m2 = new Materiel("12458","Paris",2,a2);
		
		
		Materiel m3;
		m3 = new Materiel("12456","Lyon",1,a1);
		
		
		System.out.println("---------------------------AFFICHER MON ORDINATEUR--------------");
		System.out.println("Mon ordi n°1 " + m1 );
		System.out.println("Mon ordi n°2 " + m2 );
		System.out.println("Mon ordi n°3 " + m3);
		System.out.println("---------------------------EQUALS---------------");
		System.out.println("m1 equals m2 --> " + (m1.equals(m2)));
		System.out.println("m1 equals m3 --> " + (m1.equals(m3)));
	

	}



}
