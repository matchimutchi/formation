package exerciceInterface;


public class Film extends Object implements Comparable<Film>{
	private int id;
	private String film;
	private int longueur;
	private int score;
	
	//getter setter
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getFilm() {return film;}
	public void setFilm(String film) {this.film = film;}
	public int getLongueur() {return longueur;}
	public void setLongueur(int longueur) {this.longueur = longueur;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	
	//constructeur simple
	public Film() {}
	
	//constructeur
	public Film(int id, String film, int longueur, int score) {
		this.id = id;
		this.film = film;
		this.longueur = longueur;
		this.score = score;
	}
	
	
	//tostring
	@Override
	public String toString() {
		return "Film [id=" + id + ", film=" + film + ", longueur=" + longueur + ", score=" + score + "]";
	}
	
	//compareTo
	@Override
	// o est un argument qui signifie un autre
	// film comparé a un autre film
	public int compareTo(Film o) {
		if(score != o.score)
			// - devant le Integer renvoi le sense inverse(decroissant)
			return -Integer.compare(getScore(), o.getScore());
		else
			return Integer.compare(getLongueur(), o.getLongueur());
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
