package com.edugroup.junitandspring.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.edugroup.junitandspring.metier.Produit;
import com.edugroup.junitandspring.repositories.ProduitRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProduitControllerTest {

	@Autowired
	private ProduitController produitController;
	
	@MockBean
	private ProduitRepository produitRepository;
	/*
	 * 
	 * Mockito vous permet de simuler des dependances dans vos tests unitaires
	 * par exemple ici, je peux injecter un faux repository qui répondra exactement comme je le désir
	 * dans le controller à tester
	 * Comme je contrôle exactement ce que renvoie le répository
	 * je ne test effectivement que le controller
	 * 
	 * */
	
	
	
	
	
	@Test
	@DisplayName("test de direct appel méthode produit Controller")
	public void testgetProduit() {
		//si le controller rappelle getProduit dans produitRepository
		//alors renvoyer le produit indiqué
		when(produitRepository.getProduit()).thenReturn(new Produit(1,"steack d'autruche",25.99,2.0));		
		
		
		final Produit p = produitController.home();
		assertAll(() -> assertEquals(1, p.getId()),
				() -> assertEquals("steack d'autruche", p.getNom()),
				() -> assertEquals(25.99, p.getPrix()),
				() -> assertEquals(2.0, p.getPoids())
				);
		verify(produitRepository, times(1)).getProduit();
		
	}
}
