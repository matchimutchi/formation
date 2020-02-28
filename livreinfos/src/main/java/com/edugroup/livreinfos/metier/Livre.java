package com.edugroup.livreinfos.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20,nullable = false,unique = true)
	private String isbn;
	private String titre;
	private String description;
	private int nbPages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Livre(int id, String isbn, String titre, String description, int nbPages) {
		super();
		this.id = id;
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
