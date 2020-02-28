package com.edugroup.villeinfos.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100,nullable = false,unique = true)
	private String nom;
	private String pays;
	private String description;
	
	
	
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
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Ville(int id, String nom, String pays, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
		this.description = description;
	}
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

}
