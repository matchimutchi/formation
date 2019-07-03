package helloWorld;

import java.util.Arrays;

public class App {
	
	// point d'entrée du programme java
	public static void main(String[] args) {
		
		//le langage est impératif, suite d'instruction
		//séparé par des ';'
		//java est sensible à la casse ! Toto <> toto
		
		//les types de variables/données en java
		// en java, langage fortement typés
		//toutes les variables ont un type à la déclaration
		
		// un byte fait 8 bites
		
		//entier 64 bits -> long
		// -9223372036854775808 et +9223372036854775807 (-263 et 263-1)
		long entierB = 127;
		System.out.println(entierB);
		
		// entier litteraux sont par défaut 32 bits
		// utiliser le suffix L pour specifier un litteral 64 bits
		entierB = 12456789123456789L;//le L remplace le (long)
		System.out.println(entierB);
		
		// numérique
		// un entier 32 bits signé 15
		//  -2147483648 et +2147483647 (-231 et 231-1)
		int entierA = 15;
		System.out.println(entierA);
		entierA = entierA + 12;
		System.out.println(entierA);
		

		
		
		// la conversation 32 bits -> 64 bits est implicite(automatique)
		entierB = entierA;
		System.out.println(entierB);
		
		// dans le sens inverse, ce n'est pas le cas
		// la conversion est possible, mais doit être explicite
		entierA = (int)entierB;
		System.out.println(entierA);
		
		// entier 16 bits
		//  -32768 et +32767 (-215 et 215-1)
		short entierC = 32767;
		System.out.println(entierC);
		
		// quand une conversion marche a tt les coups
		// plus petit -> plus grand, pas besoin de cast, implicite
		// dans le cas inverse, cas nécéssaire
		
		entierA = entierC;
		System.out.println(entierA);
		
		//l'entier 8bits ou octect -> byte 127 -128
		// -128 et +127 (-27 et 27-1)
		byte entierD = 125;
		System.out.println(entierD);
		
		
		// java n'a pas d'entier non signé
		
		//numerique a virgule flottante
		// double flottant 65 bits
		// les litteraux flottant sont 64 bits par defaut
		double flottantA = 3.1415171819132156;
		System.out.println(flottantA);
		
		//flottant 32 bits -> float
		float flottantB = 3.14151617181920212322F; //remplace le signe (float) devant le chiffre
		System.out.println(flottantB);
		
		// le type caractere unicode
		char c1 = 'e';
		System.out.println(c1);
		
		// le type boolean
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " +b2);
		System.out.println("b1 ou b2 "+ (b1 || b2));
		System.out.println("b1 et b2 "+ (b1 && b2));
		System.out.println("not b1 = "+ !b1);
		
		// le type string est un objet 
		// on peut voir qu'il a une majuscule cela signifie que c'est un objet
		String str1 = "hello world";
		System.out.println(str1);
		
		// vous avez deux grand type de variable en java
		// les types "valeurs"
		// les types "référence"
		// les types valeurs sont les types simples
		//qui tiennent directement dans une cas mémoires/registre
		// en java -> type valeur = minuscule
		// vous ne pouvez pas déclarer vos propres types valeurs personnalisé
		// avantage des types valeurs -> performance, pas d'allocation mémoire
		
		// tous le reste est type référence (un pointeur vers un objet/tableau)
		
		// tableau d'entier
		int[] tabA = {10,20};
		int [] tabB ; // tableau non alloué
		
		System.out.println(Arrays.toString(tabA));
		tabB = tabA; // ce n'est pas une copie tabB et tabA référence le meme tableau
		tabA[0] = 15;
		
		System.out.println(Arrays.toString(tabB));
		
		// en java, pour acceder aux attributs ou méthodes
		// d'un objet (type référence), utiliser '.'
		System.out.println("longueur str1 = " + str1.length());
		// quelques autres manipulations de chaines
		System.out.println("acceder au caractere à la position 2 de la chaine: "+ str1.charAt(2));
		System.out.println(str1);
		// extraire sous chaine (position debut, position fin exclue)
		System.out.println("sous chaine : " + str1.substring(3, 5));
		
	}

}
