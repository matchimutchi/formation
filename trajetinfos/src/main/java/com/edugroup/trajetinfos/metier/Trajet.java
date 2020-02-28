package com.edugroup.trajetinfos.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trajet {
	
	@JsonIgnore
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String trajetId;
	
	@Column(length = 100,nullable = false)
	private String nom;
	
	@Column(length = 100,nullable = false)
	private String nomhotel;
	private String ville1;
	private String ville2;
	private LocalDate dateDebut;
	private LocalDate dateArrive;
	private double distance;
	private double tarifParcours;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getNomhotel() {
		return nomhotel;
	}
	public void setNomhotel(String nomhotel) {
		this.nomhotel = nomhotel;
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getTarifParcours() {
		return tarifParcours;
	}
	public void setTarifParcours(double tarifParcours) {
		this.tarifParcours = tarifParcours;
	}
	
	
	
	
	public Trajet(int id, String trajetId, String nom, String nomhotel, String ville1, String ville2,
			LocalDate dateDebut, LocalDate dateArrive, double distance, double tarifParcours) {
		super();
		this.id = id;
		this.trajetId = trajetId;
		this.nom = nom;
		this.nomhotel = nomhotel;
		this.ville1 = ville1;
		this.ville2 = ville2;
		this.dateDebut = dateDebut;
		this.dateArrive = dateArrive;
		this.distance = distance;
		this.tarifParcours = tarifParcours;
	}
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	

}
