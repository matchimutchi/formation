package com.edugroup.mescircuits.metier;


import com.fasterxml.jackson.annotation.JsonIgnore;


public class Hotel {
	

	private String nomHotel;
	private double tarif;
	private String nom;
	
	

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
	public Hotel(String nomHotel, double tarif, String nom) {
		this.nomHotel = nomHotel;
		this.tarif = tarif;
		this.nom = nom;
	}
	
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
