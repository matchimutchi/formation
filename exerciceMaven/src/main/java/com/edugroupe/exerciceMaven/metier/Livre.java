package com.edugroupe.exerciceMaven.metier;

public class Livre {

	private int id;
	private String titre;
	private String isbn;
	private int nbPages;
	private String auteur;
	
	
	//getter setter
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	public String getIsbn() { return isbn; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public int getNbPages() { return nbPages; }
	public void setNbPages(int nbPages) { this.nbPages = nbPages; }
	public String getAuteur() { return auteur; }
	public void setAuteur(String auteur) { this.auteur = auteur; }
	
	
	//constructeur
	public Livre() {
	}
	
	
	//constructeur
	public Livre(int id, String titre, String isbn, int nbPages, String auteur) {
		this.id = id;
		this.titre = titre;
		this.isbn = isbn;
		this.nbPages = nbPages;
		this.auteur = auteur;
	}
	
	
	//tostring
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", isbn=" + isbn + ", nbPages=" + nbPages + ", auteur=" + auteur
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
