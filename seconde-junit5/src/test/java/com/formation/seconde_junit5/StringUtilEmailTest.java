package com.formation.seconde_junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilEmailTest {

	private StringUtil su;
	
	@BeforeEach
	public void beforeTest() {
		System.out.println("Before each");
		su = new StringUtil();
		su.setDomainesAutorises(new String[]{"uk","fr","de","com","org","net"});
		
	}

	
	@AfterEach
	public void afterTest(){
		System.out.println("After each");
		su =  null;
	}
	
	
	@ParameterizedTest(name = "{index} --> email valide: {0}")
	@ValueSource(strings = {"bob@joe.com","jennifer.legr@gmail.com","robert@gouv.og.de"})
	public void testEmailOk(String email) {
		assertTrue(su.estEmailValide(email));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/resources/email.csv", numLinesToSkip = 1)
	public void testEmailDivers(String email,boolean valide) {
		if(valide) {
			assertTrue(su.estEmailValide(email));
		}else {
			assertFalse(su.estEmailValide(email));
		}
		
	}
	
	
	
}
