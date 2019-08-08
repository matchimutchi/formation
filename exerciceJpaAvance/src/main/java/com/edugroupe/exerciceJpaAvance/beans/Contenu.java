package com.edugroupe.exerciceJpaAvance.beans;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok
@NoArgsConstructor  @ToString(exclude = {"tags"})
//JPA
@Entity @Inheritance(strategy = InheritanceType.JOINED)
public class Contenu {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private LocalDate dateCreation;
	private LocalDate dateEdition;
	@ManyToMany
	private Set<Tag> tags;
	
	
	
	public Contenu(int id, String nom, LocalDate dateCreation, LocalDate dateEdition) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.dateEdition = dateEdition;
	}



	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public LocalDate getDateCreation() { return dateCreation; }
	public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }
	public LocalDate getDateEdition() { return dateEdition; }
	public void setDateEdition(LocalDate dateEdition) { this.dateEdition = dateEdition; }
	public Set<Tag> getTags() { 
		if (tags == null)
			tags = new HashSet<>();
		return tags; }
	public void setTags(Set<Tag> tags) { this.tags = tags; }
	
	
	public void addTag(Tag ta) {
		ta.addToContenu(this);
	}
	

}
