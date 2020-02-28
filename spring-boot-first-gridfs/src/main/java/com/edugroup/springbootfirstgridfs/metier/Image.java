package com.edugroup.springbootfirstgridfs.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Image {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnore
	private String storageId;
	private String description;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Image(int id, String storageId, String description) {
		super();
		this.id = id;
		this.storageId = storageId;
		this.description = description;
	}
	
	
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

	
}
