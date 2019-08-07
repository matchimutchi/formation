package com.edugroupe.exerciceJpaAvance.beans;



import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper = true)
@Entity
public class DocumentPdf extends Contenu{
	
	private String nom;
	private String nomAuteur;
	
	
	public DocumentPdf(int id, String nom, LocalDate dateCreation, LocalDate dateEdition, String nom2,
			String nomAuteur) {
		super(id, nom, dateCreation, dateEdition);
		nom = nom2;
		this.nomAuteur = nomAuteur;
	}
	
	
	
}
