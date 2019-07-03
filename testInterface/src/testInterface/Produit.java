package testInterface;

public class Produit extends Object implements Comparable<Produit>{
	private String nom;
	private double prix;
	private double poids;
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	
	public Produit(String nom, double prix, double poids) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
		
	}
	
	
	@Override//remplace la class de son parent
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + ", poids=" + poids + "]";
	}
	
	//compare et classe par ordre de prix croissant
	@Override
	public int compareTo(Produit o) {
		if(this.prix > o.prix) return 1;//plus grand
		if (this.prix < o.prix)return -1;//plus petit
		return 0;//egal
	}
	
	
	
	

}
