package com.edugroup.livreinfos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.livreinfos.metier.Livre;
import com.edugroup.livreinfos.repositories.LivreRepository;

@RestController
@RequestMapping("/livres")
@CrossOrigin
public class LivreController {
	
	@Autowired
	private LivreRepository livreRepository;
	
	@GetMapping
	public Iterable<Livre> liste(){
		return livreRepository.findAll();
	}

	@GetMapping("/{isbn:[0-9]+}")
   public ResponseEntity<Livre> findByIsbn(@PathVariable("isbn") String isbn){
	   return livreRepository.findByIsbn(isbn)
			   .map(l -> new ResponseEntity<Livre>(l,HttpStatus.OK))
			   .orElse(new ResponseEntity<Livre>(HttpStatus.NOT_FOUND));
   }

}
