package com.edugroup.firstsecurity.metier;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100,unique = true,nullable = false)
	private String roleName;
	@JsonIgnore @ManyToMany(mappedBy = "roles")
	private Set<Utilisateur> utilisateurs;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
	public Role(int id, String roleName, Set<Utilisateur> utilisateurs) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.utilisateurs = utilisateurs;
	}
	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
