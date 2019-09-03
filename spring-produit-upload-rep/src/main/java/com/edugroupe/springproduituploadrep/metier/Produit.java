package com.edugroupe.springproduituploadrep.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Produit {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double prix;
	private double poids;
	
	@JsonIgnore @ManyToOne
	private Categorie categorie;
	@JsonIgnore @OneToMany(mappedBy = "produit")
	private Set<Image> images;
	
	
	
	public Produit(int id, String nom, double prix, double poids) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
	}
	
	
	
	
}
