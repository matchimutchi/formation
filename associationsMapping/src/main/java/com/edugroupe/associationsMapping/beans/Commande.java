package com.edugroupe.associationsMapping.beans;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomClient;
	private LocalDate dateCommande;
	@ManyToMany
	private Set<Produit> produits;
	
	
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNomClient() { return nomClient; }
	public void setNomClient(String nomClient) { this.nomClient = nomClient; }
	public LocalDate getDateCommande() { return dateCommande; }
	public void setDateCommande(LocalDate dateCommande) { this.dateCommande = dateCommande; }
	public Set<Produit> getProduits() { 	
		if(produits == null) {
			produits = new HashSet<>();
		}
		return produits; 
	}
	public void setProduits(Set<Produit> produits) { this.produits = produits; }
	
	
	
	
	
	public Commande() {}
	
	
	public Commande(int id, String nomClient, LocalDate dateCommande) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.dateCommande = dateCommande;
	}
	
	
	
	@Override
	public String toString() {
		return "Commande [id=" + id + ", nomClient=" + nomClient + ", dateCommande=" + dateCommande + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
