package com.edugroupe.exerciceJpaAvance.beans;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @ToString(callSuper = true,exclude = {"images"})
@Entity
public class Galerie extends Contenu{
	private String titre;
	@OneToMany( mappedBy = "galerie")
	private Set<Image> images;
	
	
	public Galerie(int id, String nom, LocalDate dateCreation, LocalDate dateEdition, String titre) {
		super(id, nom, dateCreation, dateEdition);
		this.titre = titre;
	}


	public String getTitre() { return titre; }


	public void setTitre(String titre) { this.titre = titre; }
	public Set<Image> getImages() { 
		if (images == null)
			images = new HashSet<>();
		return images; }
	public void setImages(Set<Image> images) { this.images = images; }
	

	public void addImages(Image im) {
		im.addToGalerie(this);
	}


	
	
}
