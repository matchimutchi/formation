package com.adugroupe.biobio.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//entité qui va sauvegarder tout seul en base de donné
@Entity
public class Produit {
	//clef primaire
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//nommer nos objets métier
	private int id;
	private String nom;
	private double prix;
	private String description;
	
	//créer nos objets métier 
	//( clique droit -> source -> Generate Getter and Setter)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
