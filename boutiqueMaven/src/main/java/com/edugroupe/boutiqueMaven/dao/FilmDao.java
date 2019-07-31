package com.edugroupe.boutiqueMaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edugroupe.boutiqueMaven.metier.Film;


public class FilmDao {
	
	public static final String SELECT_ALL_SQL = "SELECT `id`,`titre`,`longueur`,`annee`,`genre` FROM `films` WHERE 1";
	public static final String SELECT_ONE_SQL = "SELECT `id`,`titre`,`longueur`,`annee`,`genre` FROM `films` WHERE `id` = ?";
	public static final String INSERT_ONE_SQL = "INSERT INTO `films`(`titre`,`longueur`,`annee`,`genre`) VALUES(?,?,?,?)";
	public static final String UPDATE_ONE_SQL = "UPDATE `films` set `titre`=?,`longueur`=?,`annee`=?,`genre`=? WHERE `id` = ?";
	public static final String DELETE_ONE_SQL = "DELETE from `films` WHERE id=?";
	public static final String REQUETE_ALL_SQL = "SELECT * FROM `films` WHERE genre = ?";
	public static final String SEARCH_BY_TITRE_SQL = "SELECT `id`,`titre`,`longueur`,`annee`,`genre` FROM `films` WHERE `titre` LIKE ?";
	
	//declaration 
	private Connection base;
	private PreparedStatement findAllStatement;
	private PreparedStatement findOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement deleteOneStatement;
	private PreparedStatement requeteAllStatement;
	private PreparedStatement searchByTitreStatement;
	

	public FilmDao(Connection base) {
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(SELECT_ALL_SQL);
			findOneStatement = base.prepareStatement(SELECT_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
			requeteAllStatement = base.prepareStatement(REQUETE_ALL_SQL);
			searchByTitreStatement = base.prepareStatement(SEARCH_BY_TITRE_SQL);
		} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	//remplir
	private Film fetchFromResultSet(ResultSet rs) throws SQLException {
		return new Film(rs.getInt("id"),
				rs.getString("titre"),
				rs.getInt("longueur"),
				rs.getInt("annee"),
				rs.getString("genre"));
	}
	
	
	//Function pour chercher un film par rapport a son titre
	public List<Film> findByTitre(String searchterm){
		ArrayList<Film> films = new ArrayList<>();
		try {
			searchByTitreStatement.clearParameters();
			searchByTitreStatement.setString(1, "%" + searchterm + "%");
			ResultSet rs = searchByTitreStatement.executeQuery();
			while(rs.next()) {
				films.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return films;
		
	}
	
	
	//Function pour chercher tt les films
	public List<Film> findAll(){
		ArrayList<Film> films = new ArrayList<>();
		try {
			ResultSet rs = findAllStatement.executeQuery();
			while(rs.next()) {
				films.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return films;
		
	}
	
	// function pour chercher un film en particulier
	//evite d'�craser le parametre d'une autre requete en cours d'execution
	public synchronized Film findOne(int id) {
		Film f = null;
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
	
	
	public synchronized int save(Film f) {
		if(f.getId() == 0) {
			//insertion
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, f.getTitre());
				insertOneStatement.setInt(2, f.getLongueur());
				insertOneStatement.setInt(3, f.getAnnee());
				insertOneStatement.setString(4, f.getGenre());
				
				//n'importe quelle insert qui modifie la table
				return insertOneStatement.executeUpdate();
				
			} catch (SQLException e) {e.printStackTrace();}
		}
		else {
			//update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, f.getTitre());
				updateOneStatement.setInt(2, f.getLongueur());
				updateOneStatement.setInt(3, f.getAnnee());
				updateOneStatement.setString(4, f.getGenre());
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
	
	
	public List<Film> requeteAll(String genre){
		ArrayList<Film> films = new ArrayList<>();
		try {
			requeteAllStatement.clearParameters();
			requeteAllStatement.setString(1, genre);
			ResultSet rs = requeteAllStatement.executeQuery();
			while(rs.next()) {
				films.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return films;
		
	}
	
}
