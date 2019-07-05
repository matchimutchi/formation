package heritage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import heritage.metier.Client;
import heritage.metier.Employe;
import heritage.metier.Personne;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Personne> peoples =  new ArrayList<>();
		
		//tirer une date au hazard
		Random rd = new Random();
		for(int i = 1; i <= 10; i++) {
			if(rd.nextBoolean()) {
				peoples.add(new Client(i, "éponge" + i,"bob" + i, LocalDate.of(rd.nextInt(20) + 1980, 7, 5), "457895142" + i, LocalDate.of(rd.nextInt(5) + 2010,1,1 )));
				/*peoples.add(new Personne(i, "éponge" + i,"bob" + i, LocalDate.of(rd.nextInt(20) + 1980, 7, 5)));*/
			}else {
				peoples.add(new Employe(i, "starfish" + i, "patrick" + i, LocalDate.of(rd.nextInt(20) + 1980, 7,5), "accueil", rd.nextDouble() * 1000.0 + 1000.0));
			}
		}
		
		for(Personne p : peoples) {
			System.out.println(p.description());
			
		}
		
		//Creation du nom du fichier
		File repertoire = new File("repertoire.csv");
		
		//Ecrit dans le fichier
		PrintWriter pw = new PrintWriter(repertoire);
		
		//Copie la class personne dans le fichier 
		for(Personne p : peoples) {
			pw.println(p.saveToCsv());
		}
		
		//ATTENTION en ecriture il est absolument necessaire
		// de fermer( ou flusher) le printWriter à la fin
		// SInon le fichier risque de ne pas être ecrit ou partiellement
		pw.close();

	}

}
