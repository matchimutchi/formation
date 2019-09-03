package com.edugroupe.springproduituploadrep.metier;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Image {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String fileName;
	@Column(length = 100)
	private String contentType;
		
	@JsonIgnore @Column(length = 60)
	private String storageid;	
	@JsonIgnore @Column(length = 60)
	private String thumbStorageId;	
	@JsonIgnore @ManyToOne
	private Produit produit;
	
	
	public Image(int id, String nom, String fileName, String contentType, String storageid, String thumbStorageId) {
		this.id = id;
		this.nom = nom;
		this.fileName = fileName;
		this.contentType = contentType;
		this.storageid = storageid;
		this.thumbStorageId = thumbStorageId;
	}
	
	
	

}
