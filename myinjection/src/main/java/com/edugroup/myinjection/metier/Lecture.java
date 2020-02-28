package com.edugroup.myinjection.metier;



public class Lecture {

	private String titre;
	private String username;
	

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Lecture(String titre, String username) {
		super();
		this.titre = titre;
		this.username = username;
	}
	
	
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
