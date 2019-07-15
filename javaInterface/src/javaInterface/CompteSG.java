package javaInterface;

public class CompteSG implements Compte{

	
	private double solde;
	private String noCompte;
	
	
	
	
	
	public CompteSG(double solde, String noCompte) {
		this.solde = solde;
		this.noCompte = noCompte;
	}
	
	
	

	@Override
	public String toString() {
		return "CompteSG [solde=" + solde + ", noCompte=" + noCompte + "]";
	}




	//va chercher les var de la classe parent(Compte)
	@Override
	public void deposer(double montant) {
		this.solde += montant;
		
	}
	
	//si ton montant de retrait est inferieur au solde impossible de retirer
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
