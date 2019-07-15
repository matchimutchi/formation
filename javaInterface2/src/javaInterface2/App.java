package javaInterface2;

import java.time.LocalDate;
import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		
		//creation de ma liste calendrier
		Calendrier c1 = new Calendrier(LocalDate.of(2019, 7, 1),LocalDate.of(2019, 8, 1));
		
		System.out.println(c1);
		
		for(LocalDate jour : c1) {
			System.out.println(jour);
		}
		
		//autre method de d'appeler Iterator
//		Iterator<LocalDate> ci = c1.iterator();
//		while(ci.hasNext()) {
//			LocalDate jour = ci.next();
//			System.out.println(jour);
//		}

	}

}
