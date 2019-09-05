package com.edugroupe.springsecurityjpa.metier;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"roles","password"})
@Entity
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100,nullable = false,unique = true)
	private String username;
	@JsonIgnore @Column(length = 80)
	private String password;
	private boolean enabled;
	@ManyToMany
	private Set<Role> roles;
	
	
	//constructeur
	public User(int id, String username, String password, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	
	
}
