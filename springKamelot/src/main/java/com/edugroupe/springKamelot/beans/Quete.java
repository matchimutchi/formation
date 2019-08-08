package com.edugroupe.springKamelot.beans;

public interface Quete {

	String getDesciption();
	void setDescription(String description);
	//competence, plus il est competent,plus il a de chance de réaliser la quete
	boolean realiser(double competence);
	
	
}
