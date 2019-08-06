package com.edugroupe.exerciceUniversiteJPA.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;





@Entity
public class Matiere {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@OneToMany(mappedBy = "matieres")
	private Set<Cours> cours;
	
	
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public Set<Cours> getCours() {
		if(cours == null) {
			cours = new HashSet<>();
		}
		return cours; }
	public void setCours(Set<Cours> cours) { this.cours = cours; }
	
	
	
	public Matiere() {}
	public Matiere(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
	
	
	
}
