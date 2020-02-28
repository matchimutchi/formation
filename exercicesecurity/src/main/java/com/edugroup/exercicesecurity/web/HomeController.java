package com.edugroup.exercicesecurity.web;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {

	
	@GetMapping
	public Map<String, String> hello(Principal p){
		System.out.println("utilisateur loggé " + p.getName());
		return Collections.singletonMap("message", "Bonjour le " + p.getName() +" "+ LocalDateTime.now());
	}
	
	
	@GetMapping("/admin")
	public Map<String, String> helloAdmin(Authentication auth){
		System.out.println(auth.getName() + " " + auth.getAuthorities());
		return Collections.singletonMap("message", "Bonjour admin le " + LocalDateTime.now());
	}
	
	
	
}
