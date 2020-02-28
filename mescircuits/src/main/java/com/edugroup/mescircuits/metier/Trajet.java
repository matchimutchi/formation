package com.edugroup.mescircuits.metier;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;


public class Trajet {


	private String trajetId;
	private String nom;
	private String nomhotel;
	private String ville1;
	private String ville2;
	private LocalDate dateDebut;
	private LocalDate dateArrive;
	

	public String getTrajetId() {
		return trajetId;
	}
	public void setTrajetId(String trajetId) {
		this.trajetId = trajetId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille1() {
		return ville1;
	}
	public void setVille1(String ville1) {
		this.ville1 = ville1;
	}
	public String getVille2() {
		return ville2;
	}
	public void setVille2(String ville2) {
		this.ville2 = ville2;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(LocalDate dateArrive) {
		this.dateArrive = dateArrive;
	}
	
	
	
	public Trajet(String trajetId, String nom, String ville1, String ville2, LocalDate dateDebut,
			LocalDate dateArrive) {
		this.trajetId = trajetId;
		this.nom = nom;
		this.ville1 = ville1;
		this.ville2 = ville2;
		this.dateDebut = dateDebut;
		this.dateArrive = dateArrive;
	}
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
