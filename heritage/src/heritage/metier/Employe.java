package heritage.metier;

import java.time.LocalDate;

// interdire l'heritage d'employe
//public final class Employe extends Personne{
public class Employe extends Personne{
	
	
	private String poste;
	private double salaire;
	
	
	//getter setter
	public String getPoste() {return poste;}
	public void setPoste(String poste) {this.poste = poste;}
	public double getSalaire() {return salaire;}
	public void setSalaire(double salaire) {this.salaire = salaire;}
	
	
	//constructeur par defaut
	public Employe() {
		super();
	}
	
	//constructeur avec les arguments
	public Employe(int id, String nom, String prenom, LocalDate dateNaissance, String poste, double salaire) {
		super(id, nom, prenom, dateNaissance);
		setPoste(poste);
		setSalaire(salaire);
	}
	
	
	//toString
	@Override
	public String toString() {
		// super.methode permet de rappeler explicitement une methode heritee
		// meme si on l'a ovveridé à notre niveai
		// on ne peut pas courcircuiter notre parent super.super pas possible
		// on ne peut pas, de l'exterieur de la classe, courcircuiter celle-ci
		
		return "Employe [poste=" + poste + ", salaire=" + salaire + "]"
				+ super.toString();
	}

	
	@Override
	public String saveToCsv() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.saveToCsv())
		.append(",").append(getPoste())
		.append(",").append(getSalaire());
		return sb.toString();
	}
	
	
	@Override
	public String description() {
		return  getPoste() + "il a un salaire de " + getSalaire();
	}
	
	
}
