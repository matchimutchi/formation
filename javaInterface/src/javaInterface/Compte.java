package javaInterface;

// une interface est comme un contract
// uen interface se déclare comme une classe
// sauf qu'on utilise le mot clef interface à la place de Class
public interface Compte {
	
	//void ne renvoie rien 
	void deposer(double montant);
	boolean retirer(double montant);
	double getSolde();
}
