package com.edugroupe.associationsMapping.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double prix;
	private int stock;
	
	@ManyToOne(cascade = CascadeType.PERSIST/*, fetch = FetchType.LAZY*/)
	private Categorie categorie;
	@ManyToMany(mappedBy = "produits")
	private Set<Commande> commandes;
	
	
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public double getPrix() { return prix; }
	public void setPrix(double prix) { this.prix = prix; }
	public int getStock() { return stock; }
	public void setStock(int stock) { this.stock = stock; }
	public Categorie getCategorie() { return categorie; }
	public void setCategorie(Categorie categorie) { this.categorie = categorie; }
	public Set<Commande> getCommandes() { 
		if(commandes == null) {
			commandes = new HashSet<>();
		}
		return commandes; 
	}
	public void setCommandes(Set<Commande> commandes) { this.commandes = commandes; }
	
	
	public Produit() {}
	
	
	public Produit(int id, String nom, double prix, int stock) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}
	
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", stock=" + stock + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
