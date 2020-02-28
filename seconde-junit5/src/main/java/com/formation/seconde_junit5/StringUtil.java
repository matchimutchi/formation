package com.formation.seconde_junit5;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringUtil {
	
	private String[] extensiondomaineAutorises;
	
	//autoriser ou pas : com,fr,uk,etc..
	public void setDomainesAutorises(String ... domaines) {
		this.extensiondomaineAutorises = domaines.clone();
	}


	public StringUtil() {
		extensiondomaineAutorises = new String[] {};
	}

	public boolean estPalindrome(String chaine) {
		if(chaine == null) {
			return false;
		}
		int start = 0;
		int end = chaine.length() - 1;
		while(start < end ) {
			if(chaine.charAt(start) != chaine.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public boolean estEmailValide(String email) {
		//logique de controle email valide
		boolean match  = Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", email);
		if(!match)return false;
		//je sépare l'email via le "."
		String[] champs = email.split("[.]");
		// et je recupére ce qui est après le dernier "."
		String finEmail = champs[champs.length - 1]; 
		//je compare à tous les extension autorisées
		return Arrays.stream(extensiondomaineAutorises).anyMatch(
				ext -> finEmail.equalsIgnoreCase(ext));
	}

}
