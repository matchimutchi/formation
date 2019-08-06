package com.edugroupe.exerciceUniversiteJPA.beans;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;





@Entity
public class Cours {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private int capacite;
	private LocalDate dateDebut;
	private LocalDate dateFin;
//	@JoinTable(name = "participations", joinColumns = {@JoinColumn(name= "c_id")},inverseJoinColumns  = {@JoinColumn(name= "e_id")} )
	@ManyToMany
	private Set<Etudiant> etudiants;
	@ManyToOne
	private Professeur professeurs;
	//cette annotation permet de modifier le nom et definition de 
	//la colonne de clef etrangere
//	@JoinColumn(name = "mat_id")
	@ManyToOne
	private Matiere matieres;
	
	
	
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public int getCapacite() { return capacite; }
	public void setCapacite(int capacite) { this.capacite = capacite; }
	public LocalDate getDateDebut() { return dateDebut; }
	public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
	public LocalDate getDateFin() { return dateFin; }
	public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
	public Set<Etudiant> getEtudiants() { 
		if(etudiants == null) {
			etudiants = new HashSet<>();
		}
		return etudiants; }
	public void setEtudiants(Set<Etudiant> etudiants) { this.etudiants = etudiants; }
	public Professeur getProfesseurs() { return professeurs; }
	public void setProfesseurs(Professeur professeurs) { this.professeurs = professeurs; }
	public Matiere getMatieres() { return matieres; }
	public void setMatieres(Matiere matieres) { this.matieres = matieres; }
	
	
	
	public Cours() {}
	
	
	public Cours(int id, String libelle, int capacite, LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.capacite = capacite;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	
	@Override
	public String toString() {
		return "Cours [id=" + id + ", libelle=" + libelle + ", capacite=" + capacite + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}
	
	
	public void addEtudiants(Etudiant e) {
		if(!getEtudiants().contains(e)) {
			getEtudiants().add(e);
			e.getCours().add(this);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
