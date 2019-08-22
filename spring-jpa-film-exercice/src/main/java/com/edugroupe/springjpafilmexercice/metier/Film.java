package com.edugroupe.springjpafilmexercice.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"acteurs","realisateur"})
@Entity
public class Film {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int duree;
	private int annee;
	@ManyToMany
	private Set<Acteur> acteurs;
	@ManyToOne
	private Realisateur realisateur;
	
	public Film(int id, String nom, int duree, int annee) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.annee = annee;
	}
	
	
	
	
	
	
}
