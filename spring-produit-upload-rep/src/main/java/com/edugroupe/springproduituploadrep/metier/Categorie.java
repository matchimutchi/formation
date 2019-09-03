package com.edugroupe.springproduituploadrep.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Categorie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@JsonIgnore @OneToMany(mappedBy = "categorie")
	private Set<Produit> produits;
	
	
	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	
}
