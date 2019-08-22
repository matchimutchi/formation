package com.edugroupe.springjpafilmexercice.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"films"})
@Entity
public class Realisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String societe;
	@OneToMany(mappedBy = "realisateur")
	private Set<Film> films;
	
	
	public Realisateur(int id, String nom, String prenom, String societe) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.societe = societe;
	}
	
	
	
	
}
