package com.edugroupe.basicmapping.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//completion hibernate
@Entity
@Table(name = "moutons")//renommage de la table
public class Client {
	/*
	 * On peut annoter sur les attributs ou sur getter
	 * ATTENTION, on ne peut mélanger dans un même entite les annotations attributs ou getter
	 * c'est l'annotation @Id qui determine si dans cette entite, on regardera les attributs
	 * ou les getters
	 * 
	 * 
	 * ce n'est pas un choix completement annodin
	 * si vous annotez sur les attributs, hibernate ecrira/lira directement dedans
	 * sans passer par les getter/setter
	 * par contre si on annote sur les getters/setters, hibernate appelera vos getter/setter 
	 * pour lire/ecrire dans les objets
	 * */
	
	//objet metier
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)//() = donne des parametres
	private int id;
	@Column(name = "patronyme", length = 100)//modifie le nom de la colonne
	private String nom;
	private String prenom;
	private int age;
	private String email;
	
	
	//getter setter
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	
	//constructeur par defaut
	public Client() {}
	
	
	//constructeur
	public Client(int id, String nom, String prenom, int age, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
