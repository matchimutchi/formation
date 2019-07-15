package javaInterface2;

import java.time.LocalDate;
import java.util.Iterator;

public class Calendrier implements Iterable<LocalDate>{
	private LocalDate debut;
	private LocalDate fin;
	
	
	public LocalDate getDebut() {return debut;}
	public void setDebut(LocalDate debut) {this.debut = debut;}
	public LocalDate getFin() {return fin;}
	public void setFin(LocalDate fin) {this.fin = fin;}
	
	
	//constructeur
	public Calendrier(LocalDate debut, LocalDate fin) {
		this.debut = debut;
		this.fin = fin;
	}
	
	
	//toString
	//remplace la methid toString de object
	@Override
	public String toString() {
		return "Calendrier [debut=" + debut + ", fin=" + fin + "]";
	}
	
	
	//method Iterator aprés avoir implementer Iterable
	//iterator est un curseur pour pouvoir se déplacer dans l'interface
	//Iterable permet de parcourir l'interface
	//Iterable est plus ou moins un foreach
	@Override
	public Iterator<LocalDate> iterator() {
		//curseur de parcours de ma collection
		return new CalendrierIterator();
	}
	
	
	// class interne
	public class CalendrierIterator implements Iterator<LocalDate>{
		//connaitre son emplacement
		private LocalDate currentDay;
		
		//Constructeur
		public CalendrierIterator() {
			//une classe interne a acces ai attributs meme privé de sa classe
			//externe
			this.currentDay = debut;
		}

		// il y a t'il une valeur a parcourir aprés
		@Override
		public boolean hasNext() {
			// et on avant la fin ou sur le jour de fin lui-même(avant fin +1)
			return currentDay.isBefore(fin.plusDays(1));
		}

		//renvoie le jour actuelle et renvoie le suivant
		
		@Override
		public LocalDate next() {
			LocalDate current = currentDay;// je renvoie le jours courant
			this.currentDay = currentDay.plusDays(1);// je passe au jour suivant
			return current;
		}
	}
	
	
	
	
	
}
