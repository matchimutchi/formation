package objetDebut.metier;


// ma classe Vecteur hérite de ma classe Object
// c'est la cas pas  défaut si on ne precise pas d'heritage
// en Java la classe Object est a la racine de tous les heritages
public class Vecteur extends Object{
	
	// on a pas besoin de passer par un object Vecteur pour y accedee
	// statique, lié a la classe en general et pas à une instance particuliere
	public final static double UNITE_VALUE_DEFAULT = 1.0;// final - > constante. 
	private static int nbVecteurCree = 0;
	
	
	//une methode statique peut etre appelee depuis la classe (sans instance)
	// mais elle n'a pas access aux attributs non statiques
	public static int getNbVecteurCree() {
		return nbVecteurCree;
	}


	private double x;
	private double y;
	private double z;
	
	
	
	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}
	public double getZ() {return z;}
	public void setZ(double z) {this.z = z;}
	
	public Vecteur() {
		this(UNITE_VALUE_DEFAULT,UNITE_VALUE_DEFAULT,UNITE_VALUE_DEFAULT);
	}
	
	// constructeur par defaut( this signifie qu'il recupere le x du argument)
	// this.x = double x
	public Vecteur(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		nbVecteurCree++;
	}
	

	//constructeur par copie( il copie le constructeur par defaut)
	public Vecteur(Vecteur other) {
		this(other.x, other.y,other.z);
	}
	
	
	
	//method
	// addition
	public void add(Vecteur other) {
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
		
	}
	
	//soustraction
	public void sub(Vecteur other) {
		this.x -= other.x;
		this.y -= other.y;
		this.z -= other.z;
	}
	
	

	
	// multiplication scaler
	public void scale(double facteur) {
		this.x *= facteur;
		this.y *= facteur;
		this.z *= facteur;
	}
	
	//le override permet de verifier 
	//que la classe est bien dans le parent
	//Sert a afficher en chaine de caractere mon vecteur
	@Override
	public String toString() {
		return "V[" + x + "," + y + "," + z + "]";
	}
	
	// comparer deux objet
	@Override
	public boolean equals(Object obj) {
		// si l'autre n'est pas un vecteur, pas egal
		if(!(obj instanceof Vecteur)) {
			return false;
		}
		// converti mon paramatre Object en Vecteur
		Vecteur other = (Vecteur)obj;
		return this.x == other.x && this.y == other.y && this.z == other.z;
	}
	
}
