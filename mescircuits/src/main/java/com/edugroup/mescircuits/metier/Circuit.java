package com.edugroup.mescircuits.metier;

public class Circuit {

	private String trajetId;
	private Trajet trajet;
	private Hotel hotel;
	private Ville ville;
	public String getTrajetId() {
		return trajetId;
	}
	public void setTrajetId(String trajetId) {
		this.trajetId = trajetId;
	}
	public Trajet getTrajet() {
		return trajet;
	}
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public Circuit(String trajetId, Trajet trajet, Hotel hotel, Ville ville) {
		super();
		this.trajetId = trajetId;
		this.trajet = trajet;
		this.hotel = hotel;
		this.ville = ville;
	}
	public Circuit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
