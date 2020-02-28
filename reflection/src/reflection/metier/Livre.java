package reflection.metier;

import reflection.util.PromptMessage;
import reflection.util.PromptSaisie;

public class Livre {
	private int id;
	private String titre;
	private String auteur;
	private int nbPages;
	private double prix;
	
	
	
	public int getId() {return id;}
	@PromptMessage(message = "identifiant livre")
	@PromptSaisie
	public void setId(int id) {this.id = id;}
	public String getTitre() {return titre;}
	@PromptMessage(message = "titre livre")
	public void setTitre(String titre) {this.titre = titre;}
	public String getAuteur() {return auteur;}
	@PromptMessage(message = "auteur livre")
	public void setAuteur(String auteur) {this.auteur = auteur;}
	public int getNbPages() {return nbPages;}
	@PromptMessage(message = "nbPages livre")
	@PromptSaisie(value = 10)
	public void setNbPages(int nbPages) {this.nbPages = nbPages;}
	public double getPrix() {return prix;}
	@PromptMessage(message = "prix livre")
	@PromptSaisie(value=1)
	public void setPrix(double prix) {this.prix = prix;}
	
	
	public Livre(int id, String titre, String auteur, int nbPages, double prix) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.nbPages = nbPages;
		this.prix = prix;
	}
	
	
	public Livre() {
	}
	
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", nbPages=" + nbPages + ", prix=" + prix
				+ "]";
	}
	
	
	
	
	
	

}
