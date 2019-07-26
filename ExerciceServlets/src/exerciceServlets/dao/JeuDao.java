package exerciceServlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exerciceServlets.metier.Jeux;


public class JeuDao {

	//faire les requetes
	public static final String SELECT_ALL_SQL = "SELECT `id`,`titre`,`description`,`plateforme`,`anneeSortie` FROM `jeux` WHERE 1";
	public static final String SELECT_ONE_SQL = "SELECT `id`,`titre`,`description`,`plateforme`,`anneeSortie` FROM `jeux` WHERE `id` = ?";
	public static final String INSERT_ONE_SQL = "INSERT INTO `jeux`(`titre`,`description`,`plateforme`,`anneeSortie`) VALUES(?,?,?,?)";
	public static final String UPDATE_ONE_SQL = "UPDATE `jeux` set `titre`=?,`description`=?,`plateforme`=?,`anneeSortie`=? WHERE `id` = ?";
	public static final String DELETE_ONE_SQL = "DELETE from `jeux` WHERE id=?";
	public static final String REQUETE_ALL_SQL = "SELECT * FROM `jeux` WHERE plateforme = ?";
	
	
	//Instancier mes objets
	private Connection base;
	private PreparedStatement findAllStatement;
	private PreparedStatement findOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement deleteOneStatement;
	private PreparedStatement requeteAllStatement;
	
	
	//connection a toute les requetes
	public JeuDao(Connection base) {
		//attribut de class
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(SELECT_ALL_SQL);
			findOneStatement = base.prepareStatement(SELECT_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
			requeteAllStatement = base.prepareStatement(REQUETE_ALL_SQL);
		} catch (SQLException e) {e.printStackTrace();}
		
	}
	
		// Declaration du resulset permet de renvoyer la requete
		//transforme une ligne de resulset provenant de l'execution d'une requete select
	//en un objet jeux, en lisent les colonnes appropriée
		private Jeux fetchFromResultSet(ResultSet rs) throws SQLException {
			return new Jeux(rs.getInt("id"),
					rs.getString("titre"),
					rs.getString("description"),
					rs.getString("plateforme"),
					rs.getInt("anneeSortie"));
		}
		

		//Construction de la requete select all
		public List<Jeux> findAll(){
			ArrayList<Jeux> jeux = new ArrayList<>();
			try {
				//executQuery execute la requete 
				ResultSet rs = findAllStatement.executeQuery();
				while(rs.next()) {
					jeux.add(fetchFromResultSet(rs));
				}
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			return jeux;
			
		}
		
		//construction de la requete select one
		public synchronized Jeux findOne(int id) {
			Jeux f = null;
			try {
				//clearParameters permet de vider les parametres enregistré dans les ?
				findOneStatement.clearParameters();
				//1 correspond au premier point d'interrogation
				findOneStatement.setInt(1, id);
				ResultSet rs = findOneStatement.executeQuery();
				if(rs.next()) {
					f = fetchFromResultSet(rs);
				}
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			return f;
			
			
		}
		
		
		//construction de la requete save ( insert et update)
		public synchronized int save(Jeux f) {
			if(f.getId() == 0) {
				try {
					insertOneStatement.clearParameters();
					insertOneStatement.setString(1, f.getTitre());
					insertOneStatement.setString(2, f.getDescription());
					insertOneStatement.setString(3, f.getPlateforme());
					insertOneStatement.setInt(4, f.getAnneeSortie());

					return insertOneStatement.executeUpdate();
					
				} catch (SQLException e) {e.printStackTrace();}
			}
			else {
				try {
					updateOneStatement.clearParameters();
					updateOneStatement.setString(1, f.getTitre());
					updateOneStatement.setString(2, f.getDescription());
					updateOneStatement.setString(3, f.getPlateforme());
					updateOneStatement.setInt(4, f.getAnneeSortie());
					updateOneStatement.setInt(5, f.getId());
					return updateOneStatement.executeUpdate();
				} catch (SQLException e) {e.printStackTrace();}
				
			}
			return 0;
				
		}
		
		
		
		//construction de la requete supprimer
		public synchronized int delete(int id) {
			try {
				deleteOneStatement.clearParameters();
				deleteOneStatement.setInt(1, id);
				return deleteOneStatement.executeUpdate();
				
			} catch (SQLException e) {e.printStackTrace();}
			
			return 0;
			
		}
		
		public List<Jeux> requeteAll(String plateforme){
			ArrayList<Jeux> jeux = new ArrayList<>();
			try {
				requeteAllStatement.clearParameters();
				requeteAllStatement.setString(1, plateforme);
				ResultSet rs = requeteAllStatement.executeQuery();
				while(rs.next()) {
					jeux.add(fetchFromResultSet(rs));
				}
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			return jeux;
			
		}
	
	
	
}
