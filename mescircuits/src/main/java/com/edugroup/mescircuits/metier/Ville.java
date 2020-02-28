package com.edugroup.mescircuits.metier;



public class Ville {
	
	private String nom;
	private String pays;
	private String description;
	
	
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
	public Ville(String nom, String pays, String description) {
		this.nom = nom;
		this.pays = pays;
		this.description = description;
	}
	
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

}
