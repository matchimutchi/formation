package com.edugroupe.springKamelot.beans;

public class ChevalierBasique implements Chevalier {

	
	private String nom;
	private Quete quete;
	private double competence;

	//getter setter
	@Override
	public String getNom() {return nom;}
	@Override
	public Quete getQuete() { return quete;}
	public double getCompetence() { return competence; }
	public void setCompetence(double competence) { this.competence = competence; }
	public void setNom(String nom) { this.nom = nom; }
	public void setQuete(Quete quete) { this.quete = quete; }

	//constructeur
	public ChevalierBasique(String nom) {
		System.out.println("construction chevalier basique " + nom);
		this.nom = nom;
	}
	
	
	@Override
	public void partirEnQuete() {
		System.out.println("Moi , " + getNom() + " part en quete : " + getQuete().getDesciption());
		if(getQuete().realiser(getCompetence())) {
			System.out.println("Moi , " + getNom() + " reviens victorieux de ma quete");
		}else {
			System.out.println("Moi , " + getNom() + " j'y arriverais une prochaine fois");
		}

	}
	
	//tostring
	@Override
	public String toString() {
		return "ChevalierBasique [nom=" + nom + ", quete=" + quete + ", competence=" + competence + "]";
	}
	
	
	

}
