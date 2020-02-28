package com.edugroup.meslectures.metier;




public class Livre {

	private String isbn;
	private String titre;
	private String description;
	private int nbPages;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public Livre(String isbn, String titre, String description, int nbPages) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.description = description;
		this.nbPages = nbPages;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
