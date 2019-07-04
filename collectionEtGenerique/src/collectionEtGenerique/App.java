package collectionEtGenerique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class App {

	public static void main(String[] args) {
		
		// les plus courante sont les ARRAYLIST les HASHMAP et les STACK
		
		
		// java inclus de nombreuse collection
		// les collections non generique (anciennes)
		// les collections generique ( "nouvelles")
		
		ArrayList tab = new ArrayList();
		//grossi automatiquement quand on ajout des elements
		// qui reduit aussi si on enleve
		// on y accede via un index ( case numerote )
		
		tab.add("fraise");
		tab.add("orange");
		tab.add("framboise");
		tab.add("pomme");
		
		for(Object fruit : tab) {
			System.out.println(fruit);
		}
		
		System.out.println("--------------CHERCHER LA VARIABLE N 2 dans le tableau----------------");
		System.out.println("tab[2] --> " + tab.get(2));
		
		
		//remplacer le contenu d'une case
		tab.set(1,  "mandarine");
		System.out.println("-------------------");
		for(Object fruit : tab) {
			System.out.println(fruit);
		}
		
		
		//rajoute un objet 
		System.out.println("-----------ajoute l'objet a l'emplacement numero 2-----------------");
		tab.add(2,  "poire");
		for(Object fruit : tab) {
			System.out.println(fruit);
		}
		
		System.out.println("---------Supprime l'objet numero 2-------");
		tab.remove(2);
		for(Object fruit : tab) {
			System.out.println(fruit);
		}
		
		
		
		System.out.println("-------------LES GENERIQUE-----------------");
		ArrayList<String> tab2 = new ArrayList<>();
		tab2.add("brocoli");
		tab2.add("navet");
		tab2.add("petit pois");
		tab2.add("carotte");
		
		
		for(String legume : tab2) {
			System.out.println(legume);
		}
		// compte le nombre de lettre dans le mot
		System.out.println(tab2.get(2).length());
		
		
		System.out.println("---------------------Moyenne-------------------");
		//la petite limitation
		ArrayList<Integer> tab3 = new ArrayList<>();
		tab3.add(15);
		tab3.add(12);
		tab3.add(9);
		tab3.add(16);
		
		int total = 0;
		for(int note : tab3) {
			total += note;
			System.out.println("note =" + note);
		}
		
		System.out.println("moyenne = "+ ((float)total / tab3.size()));
		
		
		System.out.println("---------------LA PILE OU STACK-------------------");
		Stack<String> pile = new Stack<>();
		
		pile.push("moutarde");
		pile.push("ketshup");
		pile.push("mayonnaise");
		pile.push("bearnaise");
		
		System.out.println("---------------PEEK ne retire pas du dessus et elle reste dans la pile-------------------");
		System.out.println("peek -> " + pile.peek());
		System.out.println("---------------POP retire du dessus de la pile-------------------");
		System.out.println("pop -> " + pile.pop());
		
		
		System.out.println("---------------POP retire du dessus de la pile-------------------");
		for(String condiment : pile) {
			System.out.println(condiment);
		}
		
		
		System.out.println("---------------Ajout barbecue-------------------");		
		pile.push("barbecue");
		for(String condiment : pile) {
			System.out.println(condiment);
		}
		
		System.out.println("---------------HASHMAP-------------------");
		//les dictionnaires ou map ou encore tableau associatif
		// une collection qui associe a une clef, une donnee
		// le type de la clef et de la donnee sont a votre choix
		HashMap<String, Double> map1 = new HashMap<>();
		
		map1.put("patrick", 3.5);
		map1.put("bob", 7.5);
		map1.put("sandy", 17.5);
		map1.put("carlo", 12.5);
		
		System.out.println("map1[sandy] = " + map1.get("sandy"));
		
		
		System.out.println("-------------PARCOURIR MAP1-----------");
		for(String nom : map1.keySet()) {
			System.out.println(nom + " --> " + map1.get(nom));
		}
		
		
		System.out.println("-----------PARCOURIR LE COUPLE KEY VALEUR------------");
		for(Entry<String, Double> entry : map1.entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println("-------------------");
		
		Paire<String , Double> p1 = new Paire<String, Double>("Fraise", 12.99);
		System.out.println(p1);
		
		
		Paire<Double , Integer> p2 = new Paire<Double, Integer>(3.4, 5);
		System.out.println(p2);
	}

}
