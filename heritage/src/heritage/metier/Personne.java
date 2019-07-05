package heritage.metier;

import java.time.LocalDate;


//je definis la class personne comme abstraite
// non instancier
public abstract class Personne {
	
	// id sera accessible directement
	// par mes descendant et les classes dans le meme package
	protected int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	
	
	
	
	// constructeur par defaut
	public Personne() {}
	
	
	//GETTER SETTER
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public LocalDate getDateNaissance() {return dateNaissance;}
	public void setDateNaissance(LocalDate dateNaissance) {this.dateNaissance = dateNaissance;}
	
	
	//constructeur avec la declaration des arguments
	public Personne(int id, String nom, String prenom, LocalDate dateNaissance) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setDateNaissance(dateNaissance);
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	public String saveToCsv() {
		// permet de concaténer des chaînes de caractères de manière optimisée
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append(",")
		.append(getNom()).append(",")
		.append(getPrenom()).append(",")
		.append(getDateNaissance());
		
		
		return sb.toString();
	}
	
	// methode abstraite sans implementation
	public abstract String description();
	
	
}
