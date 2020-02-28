package com.edugroup.meslectures.metier;

public class Lecture {

	private String userId;
	private Livre livre;
	private Rating rating;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Lecture(String userId, Livre livre, Rating rating) {
		super();
		this.userId = userId;
		this.livre = livre;
		this.rating = rating;
	}
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
