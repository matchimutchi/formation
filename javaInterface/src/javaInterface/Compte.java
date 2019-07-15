package javaInterface;

// une interface est comme un contract
// uen interface se d�clare comme une classe
// sauf qu'on utilise le mot clef interface � la place de Class
public interface Compte {
	
	//void ne renvoie rien 
	void deposer(double montant);
	boolean retirer(double montant);
	double getSolde();
}
