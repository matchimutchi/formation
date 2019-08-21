package com.edugroupe.introductionBoot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.edugroupe.introductionBoot.metier.Ville;

@Service
public class VilleDAO {

	public static final String FIND_ALL_SQL = "SELECT `id`,`nom`,`population`,`surface`,`pays` FROM `villes`";
	public static final String FIND_ONE_SQL = "SELECT `id`,`nom`,`population`,`surface`,`pays` FROM `villes` WHERE `id`=?";
	public static final String UPDATE_ONE_SQL = "UPDATE `villes` SET `nom`=?,`population`=?,`surface`=?,`pays`=? WHERE `id`=?";
	public static final String INSERT_ONE_SQL = "INSERT INTO `villes`(`nom`,`population`,`surface`,`pays`) VALUES(?,?,?,?)";
	public static final String SEARCH_BY_VILLE_SQL ="SELECT `id`,`nom`,`population`,`surface`,`pays` FROM `villes` WHERE `nom` LIKE ?";
	public static final String DELETE_ONE_SQL = "DELETE FROM `villes` WHERE `id`=?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static class VilleMapper implements RowMapper<Ville>{
		@Override
		public Ville mapRow(ResultSet rs,int rowNum) throws SQLException{
			return new Ville(rs.getInt("id"),
								rs.getString("nom"),
								rs.getInt("population"),
								rs.getDouble("surface"),
								rs.getString("pays"));
		}
	}
	
	
	public List<Ville> findAll(){
		return jdbcTemplate.query(FIND_ALL_SQL, new VilleMapper());
	}
	

	public Ville findById(int id) {
		try {
		return jdbcTemplate.queryForObject(FIND_ONE_SQL, new Object[] {id}, new VilleMapper());
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}
	
	
	public int save(Ville v) {
		if(v.getId() == 0) {
			return jdbcTemplate.update(INSERT_ONE_SQL, v.getNom(),v.getPopulation(),v.getSurface(),v.getPays());
		}else {
			return jdbcTemplate.update(UPDATE_ONE_SQL, v.getNom(),v.getPopulation(),v.getSurface(),v.getPays(), v.getId());
		}
	}
	
	public List<Ville> search(String nom) {
		return jdbcTemplate.query(SEARCH_BY_VILLE_SQL,new Object[] {"%" + nom + "%"}, new VilleMapper());
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update(DELETE_ONE_SQL, new Object[] {id});

	}
}
