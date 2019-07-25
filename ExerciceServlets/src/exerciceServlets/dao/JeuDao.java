package exerciceServlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exerciceServlets.metier.Jeux;


public class JeuDao {

	public static final String SELECT_ALL_SQL = "SELECT `id`,`titre`,`description`,`plateforme`,`anneeSortie` FROM `jeux` WHERE 1";
	public static final String SELECT_ONE_SQL = "SELECT `id`,`titre`,`description`,`plateforme`,`anneeSortie` FROM `jeux` WHERE `id` = ?";
	public static final String INSERT_ONE_SQL = "INSERT INTO `jeux`(`titre`,`description`,`plateforme`,`anneeSortie`) VALUES(?,?,?,?)";
	public static final String UPDATE_ONE_SQL = "UPDATE `jeux` set `titre`=?,`description`=?,`plateforme`=?,`anneeSortie`=? WHERE `id` = ?";
	public static final String DELETE_ONE_SQL = "DELETE from `jeux` WHERE id=?";
	
	
	private Connection base;
	private PreparedStatement findAllStatement;
	private PreparedStatement findOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement deleteOneStatement;
	
	
	public JeuDao(Connection base) {
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(SELECT_ALL_SQL);
			findOneStatement = base.prepareStatement(SELECT_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {e.printStackTrace();}
		
	}
	

		private Jeux fetchFromResultSet(ResultSet rs) throws SQLException {
			return new Jeux(rs.getInt("id"),
					rs.getString("titre"),
					rs.getString("description"),
					rs.getString("plateforme"),
					rs.getInt("anneeSortie"));
		}
		

		public List<Jeux> findAll(){
			ArrayList<Jeux> jeux = new ArrayList<>();
			try {
				ResultSet rs = findAllStatement.executeQuery();
				while(rs.next()) {
					jeux.add(fetchFromResultSet(rs));
				}
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			return jeux;
			
		}
		
		public synchronized Jeux findOne(int id) {
			Jeux f = null;
			try {
				findOneStatement.clearParameters();
				findOneStatement.setInt(1, id);
				ResultSet rs = findOneStatement.executeQuery();
				if(rs.next()) {
					f = fetchFromResultSet(rs);
				}
				rs.close();
			} catch (SQLException e) {e.printStackTrace();}
			return f;
			
			
		}
		
		
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
		
		
		
		
		public synchronized int delete(int id) {
			try {
				deleteOneStatement.clearParameters();
				deleteOneStatement.setInt(1, id);
				return deleteOneStatement.executeUpdate();
				
			} catch (SQLException e) {e.printStackTrace();}
			
			return 0;
			
		}
	
	
	
	
}
