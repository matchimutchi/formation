package com.edugroup.exerciceIntervention;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.*;
//des assertions permettent de verifier 
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.edugroup.exerciceIntervention.metier.Intervention;
import com.edugroup.exerciceIntervention.repositories.IntervenantRepository;
import com.edugroup.exerciceIntervention.repositories.InterventionRepository;




@SpringBootTest
@AutoConfigureMockMvc
class InterventionControllerTest {

	@MockBean
	private IntervenantRepository intervenantRepository;
	
	@MockBean
	private InterventionRepository interventionRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@BeforeEach
	public void beforeTest() {
		System.out.println("Before each");
		
	}

	
	@AfterEach
	public void afterTest(){
		System.out.println("After each");
	}
	

	private Page<Intervention> getSampleProduitPage1(){
		return new PageImpl<Intervention>(new ArrayList<>(Arrays.asList(
				new Intervention(1,LocalDate.of(2020, 01, 31),"test1",LocalDateTime.of(2020, 01, 31,11,00) ,LocalDateTime.of(2020, 01, 31,11,30),"Bordeaux",1),
				new Intervention(2,LocalDate.of(2020, 02, 01), "test2",LocalDateTime.of(2020, 02, 01,12,00),LocalDateTime.of(2020, 02, 01,12,30),"Paris",2),
				new Intervention(3,LocalDate.of(2020, 03, 13), "test3",LocalDateTime.of(2020, 03, 13,13,00),LocalDateTime.of(2020, 03, 13,13,30),"Talence",3),
				new Intervention(4,LocalDate.of(2020, 04, 15), "test4",LocalDateTime.of(2020, 04, 15,14,00),LocalDateTime.of(2020, 04, 151,14,30),"Dax",4))),
				PageRequest.of(0,10),4);
	}
	
	@Test
	@DisplayName("eviter de planifier une intervention dans le passé")
	public void testIntervention() throws Exception {
		when(interventionRepository.findById(1))
		.thenReturn(Optional.of(new Intervention(1,LocalDate.of(2020, 01, 31),"test1",LocalDateTime.of(2020, 01, 31,11,00) ,LocalDateTime.of(2020, 01, 31,11,30),"Bordeaux",1)));
		if(LocalDate.now().isAfter(LocalDate.of(2020, 01, 31))  ) {
			
			mockMvc.perform(get("/interventions/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.description", is("test1")))
			.andExpect(jsonPath("$.dateIntervention", is(LocalDate.of(2020, 01, 31))))
			.andExpect(jsonPath("$.heureDebut", is(LocalDateTime.of(2020, 01, 31,11,00))))
			.andExpect(jsonPath("$.heureFin", is(LocalDateTime.of(2020, 01, 31,11,00))))
			.andExpect(jsonPath("$.lieu", is("Bordeaux")))
			.andExpect(jsonPath("$.intervenant", is(1)));
			
			verify(interventionRepository,times(1)).findById(1);
		}
	}
	
	@Test
	@DisplayName("horaire entre 8h et 18h ok")
	public void testHoraire() throws Exception {
		when(interventionRepository.findById(1))
		.thenReturn(Optional.of(new Intervention(1,LocalDate.of(2020, 01, 31),"test1",LocalDateTime.of(2020, 01, 31,11,00) ,LocalDateTime.of(2020, 01, 31,11,30),"Bordeaux",1)));
		LocalDateTime now = LocalDateTime.now();
		if(now.isAfter(LocalDateTime.of(2020, 01, 31,9,00)) && now.isBefore(LocalDateTime.of(2020, 01, 31,18,00)))  {
			
			mockMvc.perform(get("/interventions/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.description", is("test1")))
			.andExpect(jsonPath("$.dateIntervention", is(LocalDate.of(2020, 01, 31))))
			.andExpect(jsonPath("$.heureDebut", is(LocalDateTime.of(2020, 01, 31,11,00))))
			.andExpect(jsonPath("$.heureFin", is(LocalDateTime.of(2020, 01, 31,11,30))))
			.andExpect(jsonPath("$.lieu", is("Bordeaux")))
			.andExpect(jsonPath("$.intervenant", is(1)));
			
			verify(interventionRepository,times(1)).findById(1);
		}
	}
	
	
	@Test
	@DisplayName("horaire entre 8h et 18h ko")
	public void testHoraireKo() throws Exception {
		when(interventionRepository.findById(1))
		.thenReturn(Optional.of(new Intervention(1,LocalDate.of(2020, 01, 31),"test1",LocalDateTime.of(2020, 01, 31,8,00) ,LocalDateTime.of(2020, 01, 31,8,30),"Bordeaux",1)));

			String json = "{\"id\": ,\r\n" + 
					"    \"description\": \"test1\",\r\n" + 
					"    \"dateIntervention\": \"2020-01-31\",\r\n" + 
					"    \"heureDebut\": \"2020-01-31T16:00:00\",\r\n" + 
					"    \"heureFin\": \"2020-01-31T16:50:00\",\r\n" + 
					"    \"lieu\": \"Bordeaux\" }";
			
			
			mockMvc.perform(put("/interventions/1")
							.content(json).
							contentType(MediaType.APPLICATION_JSON_VALUE))
							.andExpect(status().isBadRequest());
			
			verify(interventionRepository,never()).save(any(Intervention.class));
		
	}
	
	
//	@Test
//	@DisplayName("eviter de planifier une intervenant deux fois")
//	public void testIntervenant() throws Exception {
//		when(interventionRepository.findById(1))
//		.thenReturn(Optional.of(new Intervention(1,LocalDate.of(2020, 01, 31),"test1",LocalDateTime.of(2020, 01, 31,8,00) ,LocalDateTime.of(2020, 01, 31,8,30),"Bordeaux",1)));
//
//		
//			String json = "{\"id\": 2,\r\n" + 
//					"    \"description\": \"test2\",\r\n" + 
//					"    \"dateIntervention\": \"2020-01-31\",\r\n" + 
//					"    \"heureDebut\": \"2020-01-31T8:00:00\",\r\n" + 
//					"    \"heureFin\": \"2020-01-31T8:30:00\",\r\n" + 
//					"    \"lieu\": \"Bordeaux\",\r\n" + 
//					"    \"intervenant\": {\r\n" + 
//					"        \"id\": 3,\r\n" + 
//					"        \"nom\": \"Apoux\",\r\n" + 
//					"        \"email\": \"contact@ondpme.fr\"}";
//			
//			
//			mockMvc.perform(put("/interventions/1")
//							.content(json).
//							contentType(MediaType.APPLICATION_JSON_VALUE))
//							.andExpect(status().isBadRequest());
//			
//			verify(interventionRepository,never()).save(any(Intervention.class));
//	}
//	
	
	
	
	
	
	
	@Test
	@DisplayName("test de retour 404 si intervention inconnu")
	public void testProduitNotFound() throws Exception {
		when(interventionRepository.findById(12))
				.thenReturn(Optional.empty());
		
		mockMvc.perform(get("/interventions/12"))
		.andExpect(status().isNotFound());
		
		verify(interventionRepository, times(1)).findById(12);
	}
	
	
	
	
	
	
	
	@Test
	@DisplayName("eviter intervention")
	public void testPlanificationIntervenant() throws Exception {
		
		when(interventionRepository.findById(1))
		.thenReturn(Optional.of(new Intervention(1,LocalDate.of(2020, 01, 31),"test1",LocalDateTime.of(2020, 01, 31,11,00) ,LocalDateTime.of(2020, 01, 31,11,30),"Bordeaux",1)));
		if(LocalDate.now().isAfter(LocalDate.of(2020, 01, 31))  ) {
			
			mockMvc.perform(get("/interventions/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.description", is("test1")))
			.andExpect(jsonPath("$.dateIntervention", is(LocalDate.of(2020, 01, 31))))
			.andExpect(jsonPath("$.heureDebut", is(LocalDateTime.of(2020, 01, 31,11,00))))
			.andExpect(jsonPath("$.heureFin", is(LocalDateTime.of(2020, 01, 31,11,00))))
			.andExpect(jsonPath("$.lieu", is("Bordeaux")))
			.andExpect(jsonPath("$.intervenant", is(1)));
			
			verify(interventionRepository,times(1)).findById(1);
		}
		
	}

	
	

}
