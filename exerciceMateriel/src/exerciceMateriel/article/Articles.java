package exerciceMateriel.article;

public class Articles {
	
	
	private String nom;
	private String description;
	private String famille;
	
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public String getFamille() {return famille;}
	public void setFamille(String famille) {this.famille = famille;}

	public Articles(String nom, String description, String famille) {
		setNom(nom);
		setDescription(description);
		setFamille(famille);
	}
	
	
	@Override
	public String toString() {
		return  nom  +" il est "+ description + " et il fait partie de la famille des  " + famille  ;
	}
	
	

	


}
