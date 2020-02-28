package com.edugroup.junitandspring.metier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edugroup.junitandspring.repositories.ProduitRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProduitTest {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	private Produit p1;
	private Produit p2;
	
	
	@BeforeEach
	public void beforeTest() {
		p1 = new Produit(1,"steack de lama des andes",39.99,1.0);
		p2 = produitRepository.getProduit();
	}
	
	
	@AfterEach
	public void afterTest() {
		p1 = null;
		p2 = null;
	}
	
	
	@Test
	@DisplayName("test basique d'accés au contenu d'un produit")
	public void testLectureSimple() {
		final Produit p =this.p1;
		assertAll(() -> assertEquals(1, p.getId()),
				() -> assertEquals("steack de lama des andes", p.getNom()),
				() -> assertEquals(39.99, p.getPrix()),
				() -> assertEquals(1.0, p.getPoids())
				);
	}
	
	
	@Test
	@DisplayName("test du prix maximum d'un produit")
	public void testPrixMax() {
		assertEquals(1200.0, p2.getPrixMaximum());
	}
	
}
