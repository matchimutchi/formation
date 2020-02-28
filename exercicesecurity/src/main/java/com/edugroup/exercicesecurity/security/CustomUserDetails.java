package com.edugroup.exercicesecurity.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.edugroup.exercicesecurity.metier.Lecteur;

public class CustomUserDetails implements UserDetails {

	private Lecteur lecteur;

	public CustomUserDetails(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	

	@Override
	public String getPassword() {return lecteur.getPassword();}

	@Override
	public String getUsername() {return lecteur.getUsername();}

	@Override
	public boolean isAccountNonExpired() {return true;}

	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {return lecteur.isEnabled();}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.lecteur.getRoles().stream().map(r -> r.getRoleName())
								.map(rolename -> new SimpleGrantedAuthority(rolename))
								.collect(Collectors.toList());
	}
	

}
