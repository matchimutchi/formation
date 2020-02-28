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
public class Genre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	@JsonIgnore @ManyToMany(mappedBy = "genres")
	private Set<JeuVideo> jeuVideos;

	public int getId() {
		return id;
	}

	public Genre(int id, String libelle, Set<JeuVideo> jeuVideos) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.jeuVideos = jeuVideos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<JeuVideo> getJeuVideos() {
		return jeuVideos;
	}

	public void setJeuVideos(Set<JeuVideo> jeuVideos) {
		this.jeuVideos = jeuVideos;
	}

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
