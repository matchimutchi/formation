package dateEtLambda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//import javaInterface.Voiture;

public class App {

	public static void main(String[] args) {
		//date origienel de java avant java7
		Date d = new Date();
		
		//afficher date actuelle
		System.out.println(d);
		
		System.out.println("----------Date-------------");
		Date d2 = new Date(2019, 3, 15);
		System.out.println(d2);
		
		System.out.println("----------LocalDate-------------");
		//introduction des classes Calendar dans java 7 (6?)
		//introduction dans java8 : LocalDate, etc....
		//LocalDate -> cohérent, gestion des timezone, immutable
		//on ne peut pas faire new LocalDate car le constructeur est privée
		LocalDate ld1 = LocalDate.of(2019,4,15);
		System.out.println(ld1);
		
		System.out.println("----------LocalDateTime-------------");
		LocalDateTime ldt1 = LocalDateTime.of(2019, 4,15,13,45);
		System.out.println(ldt1);
		System.out.println("----------LocalDate plus 1 mois-------------");
		LocalDate ld2 = ld1.plusMonths(1);
		System.out.println(ld2);
		
		System.out.println("----------Durée-------------");
		Duration dur1 = Duration.of(15, ChronoUnit.HOURS);
		System.out.println(dur1);
		
		
		ArrayList<Voiture> voitures = new ArrayList<>();
		
		voitures.add(new Voiture("peugot 206", 80, "rouge", LocalDate.of(1998, 10, 15)));
		voitures.add(new Voiture("tesla model s", 150, "bleu", LocalDate.of(2018, 12, 17)));
		voitures.add(new Voiture("alpha romeo guiletta", 120, "blanche", LocalDate.of(2005, 8, 30)));
		voitures.add(new Voiture("Porche", 200, "Violet", LocalDate.of(2018, 2, 16)));
		voitures.add(new Voiture("Fiat stilo", 90, "Gris", LocalDate.of(2003, 3, 3)));
		voitures.add(new Voiture("Mercedes Cla", 190, "Noir", LocalDate.of(2019, 12, 31)));
		voitures.add(new Voiture("Kia sportage", 133, "Marron", LocalDate.of(2019, 9, 1)));
		voitures.add(new Voiture("Mini Countryman", 125, "Blanc", LocalDate.of(2016, 7, 14)));
		
		
		//comparator est une interface
		//utilisation d'une classe anonyme interne implementant l'interface COmparator
//		voitures.sort(new Comparator<Voiture>() {
//			//classé par ordre de puissance
//			@Override
//			public int compare(Voiture o1, Voiture o2) {
//				return Integer.compare(o1.getPuissanceChevaux(), o2.getPuissanceChevaux());
//			}
//			
//		});
		
				
		//les lambdas c'est la meme chose que la method au dessus mais en plus simple et plus court
		// les lambdas ne fonctionnent qu'avec les interfaces fonctionnelles( comparator , comparable ) 
		// les interfaces fonctionnelles sont celle qui ont qu'une seule fonction ( comparator -> compare)
		voitures.sort((o1,o2) -> Integer.compare(o1.getPuissanceChevaux(), o2.getPuissanceChevaux()));
		
		for(Voiture v : voitures) {
			System.out.println(v);
		}
		
		// un stream ( un flux) permet d'appliquer des traitements a tt les element d'un flux
		// comme une collection  et d'enchainer ces traitements
		//typiquement les stream s'utilisent avec des lambdas
		System.out.println("-------------------------------------");
		List<String> noms = voitures.stream().filter(v -> v.getDateConstruction().isAfter(LocalDate.of(2010, 1, 1)))
			.map(v -> v.getNom())
			.map(s -> s.toUpperCase())
			.collect(Collectors.toList());
//			.forEach(s -> System.out.println(s));
			noms.stream().forEach(n -> System.out.println(n));

	}

}
