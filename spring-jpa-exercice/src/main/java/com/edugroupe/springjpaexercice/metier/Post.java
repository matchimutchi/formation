package com.edugroupe.springjpaexercice.metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String corps;
	private LocalDate dateCreation;
	private String auteur;
	
	
	
	//ce getter sera accessible depuis jsp comme un champ normal nommé "formatedDateCreation"
	//il sera ignoré par hibernate car on a annoté les attributs et non les getters
	public String getFormatedDateCreation() {
		return dateCreation.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	
	@PrePersist
	public void avantInsertion() {
		setDateCreation(LocalDate.now());
	}
}
