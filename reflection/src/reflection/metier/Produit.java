package reflection.metier;

import reflection.util.PromptMessage;
import reflection.util.PromptSaisie;

public class Produit {

	private int id;
	private String nom;
	private double prix;
	private double poids;
	
	
	public int getId() {
		return id;
	}
	@PromptMessage(message="id produit",order= 1)
	@PromptSaisie
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	@PromptMessage(message="nom produit",order= 2)
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	@PromptMessage(message="prix produit",order= 3) 
	@PromptSaisie
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPoids() {
		return poids;
	}
	
	@PromptMessage(message="poids produit",order= 4)
	@PromptSaisie
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	
	
	public Produit(int id, String nom, double prix, double poids) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
	}
	
	
	public Produit() {
	}
	
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", poids=" + poids + "]";
	}
	
	
	
	
}
