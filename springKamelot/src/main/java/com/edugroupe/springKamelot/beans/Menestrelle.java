package com.edugroupe.springKamelot.beans;

public class Menestrelle {

	public void chanterAvant(Chevalier chevalier) {
		System.out.println("Tralalala, sir " + chevalier.getNom() + 
				" part courageusement en quete!");
	}
	
	
	public void chanterApres(Chevalier chevalier) {
		System.out.println("Tralalala, sir " + chevalier.getNom() + 
				" revient joyeusement de quete!");
	}
}
