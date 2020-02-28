package com.edugroup.nanomania.metier;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class JeuVideo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private LocalDate dateSortie;
	
	@JsonIgnore @ManyToMany
	private Set<Genre> genres;
	@JsonIgnore @ManyToMany
	private Set<Plateforme> plateFormes;
	@JsonIgnore @ManyToOne
	private Editeur editeur;
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
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public Set<Genre> getGenres() {
		return genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	public Set<Plateforme> getPlateFormes() {
		return plateFormes;
	}
	public void setPlateFormes(Set<Plateforme> plateFormes) {
		this.plateFormes = plateFormes;
	}
	public Editeur getEditeur() {
		return editeur;
	}
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}
	
	public JeuVideo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JeuVideo(int id, String nom, LocalDate dateSortie, Set<Genre> genres, Set<Plateforme> plateFormes,
			Editeur editeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateSortie = dateSortie;
		this.genres = genres;
		this.plateFormes = plateFormes;
		this.editeur = editeur;
	}
	
	
	
}
