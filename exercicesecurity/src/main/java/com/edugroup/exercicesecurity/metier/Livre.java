package com.edugroup.exercicesecurity.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String isbn;
	@JsonIgnore @ManyToMany(mappedBy = "livres") 
	private Set<Lecteur> lecteurs;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Set<Lecteur> getLecteurs() {
		return lecteurs;
	}
	public void setLecteurs(Set<Lecteur> lecteurs) {
		this.lecteurs = lecteurs;
	}
	public Livre(int id, String titre, String isbn, Set<Lecteur> lecteurs) {
		super();
		this.id = id;
		this.titre = titre;
		this.isbn = isbn;
		this.lecteurs = lecteurs;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
