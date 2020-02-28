package com.edugroup.meslectures.metier;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;



public class Rating {

	private String userId;
	private String isbn;
	private double note;
	private LocalDate dateCreated;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Rating(String userId, String isbn, double note, LocalDate dateCreated) {
		super();
		this.userId = userId;
		this.isbn = isbn;
		this.note = note;
		this.dateCreated = dateCreated;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
