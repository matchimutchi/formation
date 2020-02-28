package com.edugroup.springbootfirstmongo.metier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Film {
	@Id
	private String id;
	private String name;
	private int annee;
	private double rating;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
	public Film(String id, String name, int annee, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.annee = annee;
		this.rating = rating;
	}
	
	
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	

}
