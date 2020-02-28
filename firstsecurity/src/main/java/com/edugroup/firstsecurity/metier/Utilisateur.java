package com.edugroup.firstsecurity.metier;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100, unique = true, nullable=false)
	private String login;
	@JsonIgnore @Column(length = 100,nullable = false)
	private String password;
	private boolean enabled;
	@ManyToMany/*(fetch = FetchType.EAGER)*/
	private Set<Role> roles;
	
	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Utilisateur(int id, String login, String password, boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}


	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	
	
	

}
