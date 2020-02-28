package com.edugroup.exerciceIntervention.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Intervention {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private LocalDate dateIntervention;
	private LocalDateTime heureDebut;
	private LocalDateTime heureFin;
	private String lieu;
	@ManyToOne
	private Intervenant intervenant;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateIntervention() {
		return dateIntervention;
	}
	public void setDateIntervention(LocalDate dateIntervention) {
		this.dateIntervention = dateIntervention;
	}
	public LocalDateTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalDateTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	public LocalDateTime getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(LocalDateTime heureFin) {
		this.heureFin = heureFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Intervenant getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}
	
	
	
	public Intervention(int id, String description, LocalDate dateIntervention, LocalDateTime heureDebut,
			LocalDateTime heureFin, String lieu, Intervenant intervenant) {
		super();
		this.id = id;
		this.description = description;
		this.dateIntervention = dateIntervention;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.lieu = lieu;
		this.intervenant = intervenant;
	}
	
	
	
	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Intervention(int id2, LocalDate of, String string, LocalDateTime of2, LocalDateTime of3, String lieu2,
			int i) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Intervention [id=" + id + ", description=" + description + ", dateIntervention=" + dateIntervention
				+ ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + ", lieu=" + lieu + ", intervenant="
				+ intervenant + "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
