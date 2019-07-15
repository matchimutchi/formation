package exerciceInterface;


import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		
		
		ArrayList<Film> films = new ArrayList<>();
		
		films.add(new Film(1,"La belle et la bete", 125, 5));
		films.add(new Film(2,"Aladdin", 152, 8));
		films.add(new Film(3,"Cendrillon", 178, 8));
		films.add(new Film(4,"Rebelle", 169, 9));
		
		for(Film f : films) {
			System.out.println(f);
		}
		
		Collections.sort(films);
		
		System.out.println("-------Liste film trié---------");
		for(Film f : films) {
			System.out.println(f);
		}
		
		
		
		
		System.out.println("-------Chiffre de 2 à 20 de 2 en 2-----------");
		Decompte d1 = new Decompte( 2, 20);

		System.out.println(d1);
		
		for(Integer entier : d1) {
			System.out.println(entier);
		}
		
		ArrayList<Decompte> intervals = new ArrayList<>();
		intervals.add(new Decompte(4,8));
		intervals.add(new Decompte(10,24));
		intervals.add(new Decompte(-2,15));
		intervals.add(new Decompte(5,9));
		intervals.add(new Decompte(23,52));
		intervals.add(new Decompte(1,8));
		
		
		System.out.println("-------Afficher la liste ---------");
		for(Decompte it : intervals) {
			System.out.println(it);
		}
		System.out.println("-------Afficher dans l'ordre de longueur---------");
		Collections.sort(intervals);
		for(Decompte it : intervals) {
			System.out.println(it);
		}
//		Iterator<Integer> di = d1.iterator();
//		while(di.hasNext()) {
//			Integer entier = di.next();
//			System.out.println(entier);
//		}
//		
		int i = 0;
		while(i < 255) {
			
			if(i < 255 ) {
				int j = 0;
				if(j < 10) {
//					System.out.println("i = " + i + " j = " + j);
				}
				j++;
				System.out.println("i = " + i + " j = " + j);
			}
			i++;
				
		}
		
		
	}

}
