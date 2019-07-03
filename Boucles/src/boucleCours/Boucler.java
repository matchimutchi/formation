package boucleCours;

public class Boucler {

	public static void main(String[] args) {
		System.out.println("------------------WHILE--------------------------");
		//les boucles
		
		int compteur = 0;
		while(compteur < 10) {
			if(compteur == 6)
				break;
			System.out.println("compteur = " + compteur);
			compteur++; //postinscrement --> compteur += --> compteur = compteur +1
		}
		
		
		
		System.out.println("------------------DO WHILE--------------------------");
		compteur = 15;
		do {
			System.out.println("compteur = " + compteur);
			compteur++;
		}while(compteur < 10);
		
		System.out.println("--------------------FOR------------------------");
		// boucle for
		
		// for (initialisation; test d'arret; mise a jour/iteration)
		for(int k=1; k<12; k++) {
			if(k == 9) {
				break;
			}
			if(k == 4) {
				continue; // saute à la prochaine itération
			}
				
			System.out.println("k = " + k);
		}
		
		System.out.println("-----------------FOREACH---------------------------");
		
		// itérer sur des collections
		String[] jours = { "lundi","mardi","mercredi","jeudi","vendredi"};
		
		// pour chaque chaine de caractere dans le tableau jours
		// executer le code avec la chaine de caractere j
		for(String j : jours) {
			System.out.println("jour = " + j);
		}

	}

}
