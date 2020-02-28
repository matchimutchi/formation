package com.edugroup.nanomania.metier;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Plateforme {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String marque;
	
	@JsonIgnore @ManyToMany(mappedBy = "plateFormes")
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

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Set<JeuVideo> getJeuVideos() {
		return jeuVideos;
	}

	public void setJeuVideos(Set<JeuVideo> jeuVideos) {
		this.jeuVideos = jeuVideos;
	}

	public Plateforme(int id, String nom, String marque, Set<JeuVideo> jeuVideos) {
		super();
		this.id = id;
		this.nom = nom;
		this.marque = marque;
		this.jeuVideos = jeuVideos;
	}

	public Plateforme() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
