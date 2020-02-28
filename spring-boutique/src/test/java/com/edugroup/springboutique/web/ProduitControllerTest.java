package com.edugroup.springboutique.web;


//les fonctions mockito ^pour faire un faux objet
import static org.mockito.Mockito.*;
//les fonctions de mockmvc pour simuler et tester des requette reponse
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.*;
//des assertions permettent de verifier 
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.edugroup.springboutique.metier.Produit;
import com.edugroup.springboutique.repositories.ProduitRepository;

@SpringBootTest
@AutoConfigureMockMvc
//@EnableSpringDataWebSupport //support de la pagination
public class ProduitControllerTest {

	
	
	
	/*
	 * 
	 * On va utiliser mockMvc
	 * Cela permet de simuler un environnement web
	 * pour tester le controller
	 * 
	 * 
	 * WebMvcTest va nous permettre de tester un controller
	 * spring mvc dans un faux environnement web simulé
	 * -> trés utile pour les test unitaires
	 * 
	 * 
	 * on pourra envoyer des requette http "virtuelle" à notre
	 * controller et inspecter la réponse qu'il retourne
	 * comme du json par exemple
	 * tt cela sans réellement démarrer de serveur web
	 * 
	 * 
	 * +------------MockMvc-------------------------+
	 * |		<-- http <--						|  <-- envoie requette virtuelle
	 * |     ProduitController                      |
	 * |       --> json, etc  -->                   |  --> verification réponse renvoyé
	 * +--------------------------------------------+
	 * 
	 * 
	 * */
	
	//j'injecte un faux repository
	@MockBean
	private ProduitRepository produitRepository;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	private Page<Produit> getSampleProduitPage1(){
		return new PageImpl<Produit>(new ArrayList<>(Arrays.asList(
				new Produit(1, "test1", 11.99, 0.75),
				new Produit(2, "test2", 15.99, 0.35),
				new Produit(3, "test3", 8.99, 0.5),
				new Produit(4, "test4", 12.99, 1.0))),
				PageRequest.of(0,10),4);
	}
	
	@Test
	@DisplayName("test requete get vers la liste")
	public void testListe() throws Exception {
		when(produitRepository.findAll(any(Pageable.class)))
								.thenReturn(getSampleProduitPage1());
		
		//perform permet de déclencher 
		mockMvc.perform(get("/produits/"))
				//gérer les erreurs
				.andExpect(status().isOk())
				//test si c'est du json
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				//test si ca renvoie a une taille de 4
				.andExpect(jsonPath("$.content", hasSize(4)))
				.andExpect(jsonPath("$.size", is(10)));
		
		//je verifie que le controller m'a renvoyé une fois le produitrepository
		verify(produitRepository, times(1)).findAll(any(Pageable.class));
	}
	
	
	@Test
	@DisplayName("test de la requete get pour un produit d'id 1")
	public void testFinProduitById() throws Exception {
		when(produitRepository.findById(1))
		.thenReturn(Optional.of(new Produit(1,"sachimi thon",12.50,0.150)));
		
		mockMvc.perform(get("/produits/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.nom", is("sachimi thon")))
			.andExpect(jsonPath("$.prix", is(12.50)))
			.andExpect(jsonPath("$.poids", is(0.150)));
		
		verify(produitRepository,times(1)).findById(1);
	}
	
	
	@Test
	@DisplayName("test de post pour créer un produit")
	public void testCreateProduit() throws Exception {
		when(produitRepository.save(any(Produit.class)))
		.thenReturn(new Produit(4, "mochi glace noisette",2.45,0.15));
		
		String produitJson = "{\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"nom\": \"mochi glace noisette\",\r\n" + 
				"    \"prix\": 2.45,\r\n" + 
				"    \"poids\": 0.15   }";
		
		
		mockMvc.perform(post("/produits").content(produitJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.id", is(4)))
		.andExpect(jsonPath("$.nom", is("mochi glace noisette")))
		.andExpect(jsonPath("$.prix", is(2.45)))
		.andExpect(jsonPath("$.poids", is(0.15)));;
		
		verify(produitRepository,times(1)).save(any(Produit.class));
	}
	
	
	@Test
	@DisplayName("test de retour 404 si produit inconnu")
	public void testProduitNotFound() throws Exception {
		when(produitRepository.findById(12))
				.thenReturn(Optional.empty());
		
		mockMvc.perform(get("/produits/12"))
		.andExpect(status().isNotFound());
		
		verify(produitRepository, times(1)).findById(12);
	}
	
	
	@Test
	@DisplayName("test de post pour créer un produit invalide (id > 0)")
	public void testCreateProduitKo() throws Exception {
		
		String produitJson = "{\r\n" + 
				"    \"id\": 4,\r\n" + 
				"    \"nom\": \"mochi glace noisette\",\r\n" + 
				"    \"prix\": 2.45,\r\n" + 
				"    \"poids\": 0.15   }";
		
		
		mockMvc.perform(post("/produits").content(produitJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest());
		
		verify(produitRepository,never()).save(any(Produit.class));
	}
	
	
	
}
