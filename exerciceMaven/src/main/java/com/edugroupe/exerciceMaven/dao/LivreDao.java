package com.edugroupe.exerciceMaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edugroupe.exerciceMaven.metier.Livre;


public class LivreDao {

	
	public static final String SELECT_ALL_SQL = "SELECT `id`,`titre`,`isbn`,`nbPages`,`auteur` FROM `livre` WHERE 1";
	public static final String SELECT_ONE_SQL = "SELECT `id`,`titre`,`isbn`,`nbPages`,`auteur` FROM `livre` WHERE `id` = ?";
	public static final String INSERT_ONE_SQL = "INSERT INTO `livre`(`titre`,`isbn`,`nbPages`,`auteur`) VALUES(?,?,?,?)";
	public static final String UPDATE_ONE_SQL = "UPDATE `livre` set `titre`=?,`isbn`=?,`nbPages`=?,`auteur`=? WHERE `id` = ?";
	public static final String DELETE_ONE_SQL = "DELETE from `livre` WHERE id=?";
	public static final String REQUETE_ALL_SQL = "SELECT * FROM `livre` WHERE titre = ?";
	public static final String SEARCH_BY_TITRE_SQL = "SELECT `id`,`titre`,`isbn`,`nbPages`,`auteur` FROM `livre` WHERE `titre` LIKE ?";
	public static final String FILTER_ALL_SQL = "SELECT * FROM `livre` WHERE nbPages > ? ";
	
	//declaration 
	private Connection base;
	private PreparedStatement findAllStatement;
	private PreparedStatement findOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement deleteOneStatement;
	private PreparedStatement requeteAllStatement;
	private PreparedStatement searchByTitreStatement;
	private PreparedStatement filterAllStatement;
	

	public LivreDao(Connection base) {
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(SELECT_ALL_SQL);
			findOneStatement = base.prepareStatement(SELECT_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
			requeteAllStatement = base.prepareStatement(REQUETE_ALL_SQL);
			searchByTitreStatement = base.prepareStatement(SEARCH_BY_TITRE_SQL);
			filterAllStatement = base.prepareStatement(FILTER_ALL_SQL);
		} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	//remplir
	private Livre fetchFromResultSet(ResultSet rs) throws SQLException {
		return new Livre(rs.getInt("id"),
				rs.getString("titre"),
				rs.getString("isbn"),
				rs.getInt("nbPages"),
				rs.getString("auteur"));
	}
	
	public List<Livre> findFilter(String filter1){
		ArrayList<Livre> livres = new ArrayList<>();
		try {
			filterAllStatement.clearParameters();
			filterAllStatement.setString(1, filter1);
			ResultSet rs = filterAllStatement.executeQuery();
			while(rs.next()) {
				livres.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return livres;
		
	}
	

	public List<Livre> findByTitre(String searchterm){
		ArrayList<Livre> livres = new ArrayList<>();
		try {
			searchByTitreStatement.clearParameters();
			searchByTitreStatement.setString(1, "%" + searchterm + "%");
			ResultSet rs = searchByTitreStatement.executeQuery();
			while(rs.next()) {
				livres.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return livres;
		
	}
	

	public List<Livre> findAll(){
		ArrayList<Livre> livres = new ArrayList<>();
		try {
			ResultSet rs = findAllStatement.executeQuery();
			while(rs.next()) {
				livres.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return livres;
		
	}

	public synchronized Livre findOne(int id) {
		Livre l = null;
		try {
			findOneStatement.clearParameters();
			findOneStatement.setInt(1, id);
			ResultSet rs = findOneStatement.executeQuery();
			if(rs.next()) {
				l = fetchFromResultSet(rs);
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return l;
		
		
	}
	
	
	public synchronized int save(Livre l) {
		if(l.getId() == 0) {
			//insertion
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, l.getTitre());
				insertOneStatement.setString(2, l.getIsbn());
				insertOneStatement.setInt(3, l.getNbPages());
				insertOneStatement.setString(4, l.getAuteur());
				
				//n'importe quelle insert qui modifie la table
				return insertOneStatement.executeUpdate();
				
			} catch (SQLException e) {e.printStackTrace();}
		}
		else {
			//update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, l.getTitre());
				updateOneStatement.setString(2, l.getIsbn());
				updateOneStatement.setInt(3, l.getNbPages());
				updateOneStatement.setString(4, l.getAuteur());
				updateOneStatement.setInt(5, l.getId());
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
	
	
	public List<Livre> requeteAll(String genre){
		ArrayList<Livre> livres = new ArrayList<>();
		try {
			requeteAllStatement.clearParameters();
			String titre = null;
			requeteAllStatement.setString(1, titre);
			ResultSet rs = requeteAllStatement.executeQuery();
			while(rs.next()) {
				livres.add(fetchFromResultSet(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return livres;
		
	}
}
