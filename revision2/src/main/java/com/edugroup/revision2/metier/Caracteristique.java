package com.edugroup.revision2.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Caracteristique {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	@ManyToMany(mappedBy = "caracteristiques") @JsonIgnore
	private Set<Vin> vins;
	
	@PreRemove
	public void avantEffacement() {
		if(getVins() != null) {
			for(Vin v : getVins()) {
				//je retire ma caracteristique du vin associé
				v.getCaracteristiques().remove(this);
			}
			getVins().clear();
		}
	}
	
	
}
