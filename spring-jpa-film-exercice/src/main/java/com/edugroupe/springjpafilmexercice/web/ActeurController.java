package com.edugroupe.springjpafilmexercice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edugroupe.springjpafilmexercice.metier.Acteur;

import com.edugroupe.springjpafilmexercice.repositories.ActeurModel;

@Controller
public class ActeurController {

	@Autowired
	private ActeurModel acteurModel;
	
	
	@GetMapping("/home")
	public ModelAndView liste() {
		ModelAndView mv = new ModelAndView("acteur/liste");
		mv.addObject("acteurs",acteurModel.findAll());
		return mv;
	}
	
	@GetMapping("/editActeur/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("acteur/edit");
		mv.addObject("acteur",acteurModel.findById(id));
		return mv;
	}
	
	@GetMapping("/createActeur")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("acteur/edit");
		mv.addObject("acteur",new Acteur(0,"nom","prenom","email"));
		return mv;
	}
	
	@PostMapping("/saveActeur")
	public String save(@RequestParam("id") int id,
						@RequestParam("nom") String nom,
						@RequestParam("prenom") String prenom,
						@RequestParam("email") String email) {
		acteurModel.save(new Acteur(id,nom,prenom,email));
		return "redirect:/home";
	}
	
	
	@PostMapping("/deleteActeur")
	public String delete(@RequestParam("delete") int id) {				
		acteurModel.deleteById(id);
		return "redirect:/home";

	}
}
