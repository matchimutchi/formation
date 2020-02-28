package com.edugroup.mescircuits.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edugroup.mescircuits.metier.Circuit;
import com.edugroup.mescircuits.metier.Hotel;
import com.edugroup.mescircuits.metier.Trajet;
import com.edugroup.mescircuits.metier.Ville;


@RestController
@RequestMapping("/circuit")
@CrossOrigin
public class CircuitController {

	
	private final RestTemplate restTemplate;
	
	@Value("${microservice.villeinfos.url}")
	private String villeInfoUrl;
	@Value("${microservice.trajetinfos.url}")
	private String trajetInfoUrl;
	@Value("${microservice.hotelinfos.url}")
	private String hotelInfoUrl;
	
	
	@Autowired
	public CircuitController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/{nomId:[a-zA-Z0-9]+}")
	public List<Circuit> findUserCircuit(@PathVariable("nomId") String nomId){
		Trajet[] trajets = restTemplate.getForObject("http://trajetinfos/trajets/"+ nomId, Trajet[].class);
//		Hotel[] hotels = restTemplate.getForObject("http://hotelinfos/hotels/"+ nomId, Hotel[].class);

		final String villeurl = this.villeInfoUrl;
		
		List<Circuit> circuits = Arrays.stream(trajets).map(trajet -> {
			Ville v = restTemplate.getForObject("http://villeinfos/villes/" + trajet.getNom() + trajet.getTrajetId()+ trajet.getVille1() +  trajet.getDateDebut() + trajet.getDateArrive(), Ville.class);
			Hotel[] hotels = restTemplate.getForObject("http://hotelinfos/hotels/"+ trajet.getVille2(), Hotel[].class);
		
			return new Circuit(nomId,trajets[0],hotels[0],v);
			}).collect(Collectors.toList());
		
		return circuits;
	}
	
	
	
	
	

	
	

}
