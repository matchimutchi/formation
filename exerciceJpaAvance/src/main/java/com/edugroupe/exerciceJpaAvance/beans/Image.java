package com.edugroupe.exerciceJpaAvance.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper = true,exclude = "galerie")
@Entity
public class Image extends Contenu{
	private String fileName;
	private String nomAuteur;
	@ManyToOne 
	private Galerie galerie;
	
	
	public Image(int id, String nom, LocalDate dateCreation, LocalDate dateEdition, String fileName,
			String nomAuteur) {
		super(id, nom, dateCreation, dateEdition);
		this.fileName = fileName;
		this.nomAuteur = nomAuteur;
	}
	
	public void addToGalerie(Galerie ga) {
		setGalerie(ga);
		ga.getImages().add(this);
	}
	
	
//	@PreRemove
//	public void cleanGalerieBeforeRemove() {
//		System.out.println("Passage par clean Cours");
//		for(Galerie ga : getGalerie()) {
//			ga.getImages().remove(this);
//		}
//		
//		getGalerie().clear();
//	}
	
	
}
