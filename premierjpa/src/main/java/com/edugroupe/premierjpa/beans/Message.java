package com.edugroupe.premierjpa.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// l'annotation Entity devant la class indique qur c'est un ejb3 de type entité 
//qu'hibernete devra gérer
// Entity exemple: film, livre etc..
@Entity
public class Message {
	private int id;
	private String titre;
	private String corps;

	//l'annotation 'Id' devant soit : un getter, soit l'attribut indique à hibernate
	//quelle est la clef primaire de cet objet metier
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	//generatedValue pour demande a la base de generer les valeur 
	//strategy=GenerationType = enumeration
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	public String getCorps() {return corps;}
	public void setCorps(String corps) {this.corps = corps;}



	public Message() {this(0,"","");}

	public Message(int id, String titre, String corps) {
		this.id = id;
		this.titre = titre;
		this.corps = corps;
	}
	

}
