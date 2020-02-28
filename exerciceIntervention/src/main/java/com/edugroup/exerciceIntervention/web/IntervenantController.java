package com.edugroup.exerciceIntervention.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.exerciceIntervention.metier.Intervenant;
import com.edugroup.exerciceIntervention.metier.Intervention;
import com.edugroup.exerciceIntervention.repositories.IntervenantRepository;

@RestController
@RequestMapping("/intervenants")
public class IntervenantController {

	@Autowired
	private IntervenantRepository intervenantRepository;
	
	@GetMapping
	public Page<Intervenant> list(@PageableDefault(page =0,size = 10)Pageable page){
		return intervenantRepository.findAll(page);
	}
	
	public ResponseEntity<Intervenant> finbById(@PathVariable("id") int id){
		return intervenantRepository.findById(id)
				.map(i -> new ResponseEntity<>(i, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<Intervenant> save(@RequestBody Intervenant i){
		if(i.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Intervenant>(intervenantRepository.save(i),HttpStatus.CREATED);
	}
	
	
	
}
