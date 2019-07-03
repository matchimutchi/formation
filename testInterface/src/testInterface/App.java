package testInterface;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		
		//j'appelle ma class Produit.java
		Produit[]catalogue = {
			new Produit("steack de lama", 39.99, 0.75),
			new Produit("biere d'algues", 7.99, 1.0),
			new Produit("miel des carpathes", 14.99, 0.5),
			new Produit("tofu tout fou", 25.99, 1.5)
		};
		
		System.out.println(Arrays.toString(catalogue));
		
		//trier le catalogue
		Arrays.sort(catalogue);
		
		
		//affiche a nouveau mais en ordre de prix croissant
		System.out.println(Arrays.toString(catalogue));

	}

}
