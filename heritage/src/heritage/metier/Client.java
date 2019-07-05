package heritage.metier;

import java.time.LocalDate;

public class Client extends Personne{

		private String numeroCompte;
		private LocalDate dateContrat;
		
		
		public String getNumeroCompte() {return numeroCompte;}
		public void setNumeroCompte(String numeroCompte) {this.numeroCompte = numeroCompte;}
		public LocalDate getDateContrat() {return dateContrat;}
		public void setDateContrat(LocalDate dateContrat) {this.dateContrat = dateContrat;}
		
		
		public Client() {}
		
		
		public Client(int id, String nom, String prenom, LocalDate dateNaissance, String numeroCompte,
				LocalDate dateContrat) {
			super(id, nom, prenom, dateNaissance);
			setNumeroCompte(numeroCompte);
			setDateContrat(dateContrat);
		}
		@Override
		public String toString() {
			return "Client [numeroCompte=" + numeroCompte + ", dateContrat=" + dateContrat + "]"
					+super.toString();
		}
		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return super.getId();
		}
		@Override
		public void setId(int id) {
			// TODO Auto-generated method stub
			super.setId(id);
		}
		@Override
		public String getNom() {
			// TODO Auto-generated method stub
			return super.getNom();
		}
		@Override
		public void setNom(String nom) {
			// TODO Auto-generated method stub
			super.setNom(nom);
		}
		@Override
		public String getPrenom() {
			// TODO Auto-generated method stub
			return super.getPrenom();
		}
		@Override
		public void setPrenom(String prenom) {
			// TODO Auto-generated method stub
			super.setPrenom(prenom);
		}
		@Override
		public LocalDate getDateNaissance() {
			// TODO Auto-generated method stub
			return super.getDateNaissance();
		}
		@Override
		public void setDateNaissance(LocalDate dateNaissance) {
			// TODO Auto-generated method stub
			super.setDateNaissance(dateNaissance);
		}
		@Override
		public String saveToCsv() {
			StringBuilder sb = new StringBuilder();
			
			// heritage de la classe personne
			sb.append(super.saveToCsv())
			.append(",").append(getNumeroCompte())
			.append(",").append(getDateContrat());
			
			return sb.toString();
		}
		@Override
		public String description() {
			
			return getNom() + "enregistrer le " + getDateContrat();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
