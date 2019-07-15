package javaInterface;

public class CompteLCL implements Compte {
	private double solde;
	private String iban;
	
	
	//Déclaration des CLASS
	public CompteLCL(double solde, String iban) {
		this.solde = solde;
		this.iban = iban;
	}

	
	//toString
	@Override
	public String toString() {
		return "CompteLCL [solde=" + solde + ", iban=" + iban + "]";
	}

	@Override
	public void deposer(double montant) {
		this.solde += montant;

	}

	@Override
	public boolean retirer(double montant) {
		if(montant <= solde) {
			this.solde -= montant;
			return true;
		}
		return false;
	}

	@Override
	public double getSolde() {
		return solde;
	}

}
