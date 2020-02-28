package com.edugroup.monpremierbootdocker.web;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class HelloController {
	
	@GetMapping("/{nom:[a-zA-Z0-9]+}")
	public Map<String, String> salutations(@PathVariable("nom") String nom){
		return Collections.singletonMap("message","Bonjour, " + nom);
	}

}
