package multiThread2;

import java.util.concurrent.atomic.AtomicLong;

public class CompteurPartage {
		
		private long compteur;
		private AtomicLong compteurAtomic;

		//getter setter
		public long getCompteur() { return compteur; }
		public void setCompteur(long compteur) { this.compteur = compteur; }
		
		
		//constructeur
		public CompteurPartage(long compteur) {
			this.compteur = compteur;
			this.compteurAtomic = new AtomicLong(compteur);
		}
		
		//synchronized denote une methode pu un bloc de code critique
		// c 'est a dire qui ne doit etre executer alors qu'elle est deja en cours d'execution
		//si un autre thread veut l'executer alors qu'elle est deja en cours d'execution
		// il devra patienter pour avoir son tour
		public synchronized long incrementCompteur() {
			this.compteur = this.compteur + 1;
			return this.compteur;
		}
		
		
		//incremente compteur optimiser
		// incrementAndGet() optimise le temp
		public long incrementCompteurOptimise() {
			return this.compteurAtomic.incrementAndGet();
		}
		
		
		@Override
		public String toString() {
			return "CompteurPartage [compteur=" + compteur + ", compteurAtomic=" + compteurAtomic + "]";
		}
		
		
	
		
}
