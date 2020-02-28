package com.edugroup.hotelinfos.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hotel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomHotel;
	private double tarif;
	@Column(length = 100,nullable = false)
	private String nom;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Hotel(int id, String nomHotel, double tarif, String nom) {
		super();
		this.id = id;
		this.nomHotel = nomHotel;
		this.tarif = tarif;
		this.nom = nom;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
