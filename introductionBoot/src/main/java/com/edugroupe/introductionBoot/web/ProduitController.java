package com.edugroupe.introductionBoot.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProduitController {

	@GetMapping("/hello")
	@ResponseBody
	public String bienvenue() {
		return"<h1>Bonjour "+ LocalDateTime.now() + "</h1>";
	}
	
	@GetMapping("/greetings")
	@ResponseBody
	public String bienvenueAvance(@RequestParam("nom") String nom) {
		return"<h2 style='color:blue'>Bonjour "+ nom + "</h2>";
	}
	
}
