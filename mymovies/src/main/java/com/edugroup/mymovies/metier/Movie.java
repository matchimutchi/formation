package com.edugroup.mymovies.metier;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private LocalDate dateSOrtie;
	private int dureeMinutes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public LocalDate getDateSOrtie() {
		return dateSOrtie;
	}
	public void setDateSOrtie(LocalDate dateSOrtie) {
		this.dateSOrtie = dateSOrtie;
	}
	public int getDureeMinutes() {
		return dureeMinutes;
	}
	public void setDureeMinutes(int dureeMinutes) {
		this.dureeMinutes = dureeMinutes;
	}
	
	
	
	public Movie(int id, String titre, LocalDate dateSOrtie, int dureeMinutes) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateSOrtie = dateSOrtie;
		this.dureeMinutes = dureeMinutes;
	}
	
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
