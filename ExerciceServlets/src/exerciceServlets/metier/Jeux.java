package exerciceServlets.metier;

public class Jeux {
	
	//construction de mon objet
	private int id;
	private String titre;
	private String description;
	private String plateforme;
	private int anneeSortie;
	
	

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getPlateforme() { return plateforme; }
	public void setPlateforme(String plateforme) { this.plateforme = plateforme; }
	public int getAnneeSortie() { return anneeSortie; }
	public void setAnneeSortie(int anneeSortie) { this.anneeSortie = anneeSortie; }
	
	
	
	public Jeux() {}
	
	
	public Jeux(int id, String titre, String description, String plateforme, int anneeSortie) {
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.plateforme = plateforme;
		this.anneeSortie = anneeSortie;
	}
	
	
	
	@Override
	public String toString() {
		return "Jeux [id=" + id + ", titre=" + titre + ", description=" + description + ", plateforme=" + plateforme
				+ ", anneeSortie=" + anneeSortie + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
