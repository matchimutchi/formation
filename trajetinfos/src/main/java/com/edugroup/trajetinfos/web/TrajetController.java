package com.edugroup.trajetinfos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edugroup.trajetinfos.metier.Trajet;
import com.edugroup.trajetinfos.repositories.TrajetRepository;



public class TrajetController {

	@Autowired
	private TrajetRepository trajetRepository;
	
	@GetMapping("/{trajetId:[a-zA-Z0-9]+}")
	public List<Trajet> findBytrajetId(@PathVariable("trajetId") String trajetId){
		return trajetRepository.findBytrajetId(trajetId);
	}
}
