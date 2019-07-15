package exerciceInterface;

//import java.util.Comparator;
import java.util.Iterator;


public class Decompte implements Iterable<Integer>, Comparable<Decompte>{
	
	private int debut;
	private int fin;
	
	
	public int getDebut() {return debut;}
	public void setDebut(int debut) {this.debut = debut;}
	public int getFin() {return fin;}
	public void setFin(int fin) {this.fin = fin;}
	
	
	public Decompte(int debut, int fin) {
		this.debut = debut;
		this.fin = fin;
	}
	
	
	@Override
	public String toString() {
		return "Decompte [debut=" + debut + ", fin=" + fin + "]";
	}
	@Override
	public Iterator<Integer> iterator() {
		return new DecompteIterator();
	}
	
	
	public class DecompteIterator  implements Iterator<Integer> {
		
		private int currentDebut;
		private int currentFin;
		
		public DecompteIterator() {
			this.currentDebut = debut;
			this.currentFin = fin;
		}
		
		
		@Override
		public boolean hasNext() {
			return currentDebut <= currentFin;
			
		}

		@Override
		public Integer next() {
			int current = currentDebut;
			this.currentDebut = currentDebut + 2;
			return current;
//			return current ++;
		}
		

	}


	@Override
	public int compareTo(Decompte o) {
		return Integer.compare(Math.abs(fin - debut), Math.abs(o.fin - o.debut));
	}


	

}
