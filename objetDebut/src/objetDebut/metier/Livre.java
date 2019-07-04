package objetDebut.metier;

public class Livre {
	//etat ou attribut de ma classe livre
	public int id;
	public String titre;
	public String auteur;
	private int nbPages;
	private double prix;
	
	
	// declarer une methode  getter de l'attribut nbPages
	public int getNbPages() {
		return nbPages;
	}

	// declarer une methode setter nbPages
	// ? = opérateur ternaire qui remplace if
	public void setNbPages(int nbPages) {
		this.nbPages = (nbPages > 0)? nbPages : 0;
	}
	
	public double getPrix() {
		return prix; 
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	//constructeur d'objets	
	
	//constructeur par defaut de la classe livre
	//fournit automatiquement si on ne le definit pas
	public Livre() {
		this(0,"inconnu","inconnu",0,0.0);
		/*id = 0;
		titre = "inconnu";
		auteur = "inconnu";
		nbPages = 0;
		prix = 0.0;*/
	}
	
	//autre constructeur
	public Livre(int id, String titre, String auteur,int nbPages,double prix) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		//meme si le constructeur peux passer outre
		// il est recommandé de passer par les setter s'il y a des controle
		setNbPages(nbPages);
		setPrix(prix);
	}
	
	// operaton ou methodes de ma classe Livre
	
	public String description() {
		return "Le titre de mon livre est " + titre +", l'auteur s'appel "+ this.auteur;	
	}
}
