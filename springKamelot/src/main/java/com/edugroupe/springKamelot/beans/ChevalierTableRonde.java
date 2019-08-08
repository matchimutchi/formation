package com.edugroupe.springKamelot.beans;

import java.util.Set;

public class ChevalierTableRonde implements Chevalier{

	private String nom;
	private Quete quete;
	private double competence;
	private Cheval monture;
	


	
	@Override
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	@Override
	public Quete getQuete() { return quete; }
	public void setQuete(Quete quete) { this.quete = quete; }
	public double getCompetence() { return competence; }
	public void setCompetence(double competence) { this.competence = competence; }
	public Cheval getMonture() { return monture; }
	public void setMonture(Cheval monture) { this.monture = monture; }


	public ChevalierTableRonde(String nom) {
		System.out.println("construction chevalier table ronde " + nom);
		this.nom = nom;
	}
	

	@Override
	public void partirEnQuete() {
		System.out.println("Moi , sire " + getNom() + " part en quete  sur mon fidele destrier : " + 
				getMonture().getNom() + " en quete : " + getQuete().getDesciption());
		if(getQuete().realiser(getCompetence())) {
			System.out.println("Moi , sire " + getNom() + " reviens victorieux de ma quete");
		}else {
			System.out.println("Moi , sire "
					+ "" + getNom() + "a eu un contretemp");
		}

	}
	
	
	@Override
	public String toString() {
		return "ChevalierTableRonde [nom=" + nom + ", quete=" + quete + ", competence=" + competence + ", monture="
				+ monture + "]";
	}
	
	
	

	


	
	
	
	

	
	
	
	
	
	
	
}
