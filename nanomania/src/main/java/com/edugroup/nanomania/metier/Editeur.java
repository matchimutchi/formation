package com.edugroup.nanomania.metier;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Editeur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String email;
	
	@JsonIgnore @OneToMany(mappedBy = "editeur")
	private Set<JeuVideo> jeuVideos;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<JeuVideo> getJeuVideos() {
		return jeuVideos;
	}

	public void setJeuVideos(Set<JeuVideo> jeuVideos) {
		this.jeuVideos = jeuVideos;
	}

	public Editeur(int id, String nom, String email, Set<JeuVideo> jeuVideos) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.jeuVideos = jeuVideos;
	}

	public Editeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
