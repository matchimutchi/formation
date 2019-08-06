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
public class Professeur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private double salaire;
	@OneToMany(mappedBy = "professeurs")
	private Set<Cours> cours;
	
	
	
	
	
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public double getSalaire() { return salaire; }
	public void setSalaire(double salaire) { this.salaire = salaire; }
	public Set<Cours> getCours() { 
		if(cours == null) {
			cours = new HashSet<>();
		}
		return cours; }
	public void setCours(Set<Cours> cours) { this.cours = cours; }



	public Professeur() {}



	public Professeur(int id, String nom, String prenom, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}



	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
	}
	
	
	
	
	
	
}




