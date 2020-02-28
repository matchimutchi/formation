package com.edugroup.ratings.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Rating {
	@JsonIgnore
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String userId;
	@Column(length = 20,nullable = false)
	private String isbn;
	private double note;
	private LocalDate dateCreated;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Rating(int id, String userId, String isbn, double note, LocalDate dateCreated) {
		super();
		this.id = id;
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
