package com.formation.seconde_junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilTest {

	private StringUtil su;

	@BeforeEach
	void beforeTest() {
		System.out.println("Before each");
		su = new StringUtil();
	}

	
	@AfterEach
	void afterTest(){
		System.out.println("After each");
		su =  null;
	}
	
	
	@Test
	@DisplayName(value = "test de palindrome kayak basique")
	public void testpalindromebasique() {
		String donnee = "kayak";
		assertTrue(su.estPalindrome(donnee), "Kayak devrait être un palindrome");
	}
	
	
	@ParameterizedTest(name = "numero {index} - avec valeur {0}")
	@ValueSource(strings = {"kayak","anna","radar"})
	@EmptySource
	public void testPalindromeOk(String chaine) {
		assertTrue(su.estPalindrome(chaine));
	}
	
	@ParameterizedTest(name = "numero {index} - avec valeur {0}")
	@ValueSource(strings = {"bonjour","papa","java","test"})
	@NullSource
	public void testPalindromeKO(String chaine) {
		assertFalse(su.estPalindrome(chaine));
	}

}
