package exerciceMateriel.article;

public class Materiel {

	
	private String noSerie;
	private String localisation;
	private int age;
	private Articles article;
	
	public Articles getArticle() {return article;}
	public void setArticle(Articles article) {this.article = article;}
	public String getNoSerie() {return noSerie;}
	public void setNoSerie(String noSerie) {this.noSerie = noSerie;}
	public String getLocalisation() {return localisation;}
	public void setLocalisation(String localisation) {this.localisation = localisation;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public Materiel(String noSerie, String localisation, int age, Articles article) {
		
		setAge(age);
		setArticle(article);
		setNoSerie(noSerie);
		setLocalisation(localisation);
	}
		

	//constructeur
	@Override
	public String toString() {
		return "Mon noSerie est le " + noSerie +" ma lacalisation est " + localisation + " mon age " + age + " mon article est un " + article;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((noSerie == null) ? 0 : noSerie.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materiel other = (Materiel) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (noSerie == null) {
			if (other.noSerie != null)
				return false;
		} else if (!noSerie.equals(other.noSerie))
			return false;
		return true;
	}

	
	

}
