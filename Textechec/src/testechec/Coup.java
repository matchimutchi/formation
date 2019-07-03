package testechec;

public class Coup {
	public int numero;
	public String couleur;
	public Case caseDepart;
	public Case caseArrivee;
	
	
	public Coup() {
		super();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public Case getCaseDepart() {
		return caseDepart;
	}
	public void setCaseDepart(Case caseDepart) {
		this.caseDepart = caseDepart;
	}
	public Case getCaseArrivee() {
		return caseArrivee;
	}
	public void setCaseArrivee(Case caseArrivee) {
		this.caseArrivee = caseArrivee;
	}
	
	
	
}
