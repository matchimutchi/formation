package com.edugroup.exerciceIntervention.web;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.exerciceIntervention.metier.Intervenant;
import com.edugroup.exerciceIntervention.metier.Intervention;
import com.edugroup.exerciceIntervention.repositories.IntervenantRepository;
import com.edugroup.exerciceIntervention.repositories.InterventionRepository;

@RestController
@RequestMapping("/interventions")
public class InterventionController {

	@Autowired
	private InterventionRepository interventionsRepository;
	
	@Autowired
	private IntervenantRepository intervenantRepository;
	
	@GetMapping
	public Page<Intervention> list(@PageableDefault(page =0,size = 10)Pageable page){
		return interventionsRepository.findAll(page);
	}
	
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Intervention> finbById(@PathVariable("id") int id){
		return interventionsRepository.findById(id)
				.map(i -> new ResponseEntity<>(i, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<Intervention> save(@RequestBody Intervention i){
		if(i.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Intervention>(interventionsRepository.save(i),HttpStatus.CREATED);
	}
	
	
//	@PutMapping(value = "/{id:[0-9]+}")
//	public ResponseEntity<Intervention> change(@RequestBody Intervention intervention,@PathVariable("id") int id){
//		
//		Optional<Intervention> in = interventionsRepository.findById(intervention.getId());		
//		if (!in.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		Intervention i1 = in.get();
//		i1.setDescription(intervention.getDescription());
//		i1.setDateIntervention(intervention.getDateIntervention());
//		i1.setHeureDebut(intervention.getHeureDebut());
//		i1.setHeureFin(intervention.getHeureFin());
//		i1.setLieu(intervention.getLieu());
//		i1.setIntervenant(intervenantRepository.findById(id).get());
//		
//		
//		i1 = interventionsRepository.save(i1);
//		return new ResponseEntity<Intervention>(i1, HttpStatus.OK);
//	}
	
	
	@PostMapping(value = "/{id:[0-9]+}")
	public ResponseEntity<Intervention> planificationIntervenant(@RequestBody Intervention intervention,@RequestParam("intervenantId") int intervenantId){
		Intervenant intervenan = intervenantRepository.findById(intervenantId).orElse(null);
		if( intervenan == null) {
			return new ResponseEntity<Intervention>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		Optional<Intervention> in = interventionsRepository.findById(intervention.getId());		
		if (!in.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Intervention i1 = in.get();
		i1.setDescription(intervention.getDescription());
		i1.setDateIntervention(intervention.getDateIntervention());
		i1.setHeureDebut(intervention.getHeureDebut());
		i1.setHeureFin(intervention.getHeureFin());
		i1.setLieu(intervention.getLieu());
		i1.setIntervenant(intervenantRepository.findById(intervenantId).get());
		
		
		i1 = interventionsRepository.save(i1);
		return new ResponseEntity<Intervention>(i1, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id:[0-9]+}")
	public ResponseEntity<Intervention> horaire(@RequestBody Intervention intervention1,@PathVariable("id") int id){
		Optional<Intervention> i = interventionsRepository.findById(intervention1.getId());
		if(intervention1.getHeureDebut().get(ChronoField.CLOCK_HOUR_OF_DAY) < 9 || intervention1.getHeureFin().get(ChronoField.CLOCK_HOUR_OF_DAY) > 18) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Intervention i2 = i.get();
		i2.setDescription(intervention1.getDescription());
		i2.setDateIntervention(intervention1.getDateIntervention());
		i2.setHeureDebut(intervention1.getHeureDebut());
		i2.setHeureFin(intervention1.getHeureFin());
		i2.setLieu(intervention1.getLieu());
		i2.setIntervenant(intervenantRepository.findById(id).get());
		
		
		i2 = interventionsRepository.save(i2);
		return new ResponseEntity<Intervention>(i2, HttpStatus.OK);
	}
	
	

	
	
	
}
