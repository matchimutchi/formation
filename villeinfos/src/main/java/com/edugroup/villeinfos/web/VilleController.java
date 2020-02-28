package com.edugroup.villeinfos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.villeinfos.metier.Ville;
import com.edugroup.villeinfos.repositories.VilleRepository;

@RestController
@RequestMapping("/villes")
@CrossOrigin
public class VilleController {

	@Autowired
	private VilleRepository villeRepository;
	
	@GetMapping
	public Iterable<Ville> liste(){
		return villeRepository.findAll();
	}

	@GetMapping("/{nom:[0-9]+}")
   public ResponseEntity<Ville> findByIsbn(@PathVariable("nom") String nom){
	   return villeRepository.findByNom(nom)
			   .map(v -> new ResponseEntity<Ville>(v,HttpStatus.OK))
			   .orElse(new ResponseEntity<Ville>(HttpStatus.NOT_FOUND));
   }

}
