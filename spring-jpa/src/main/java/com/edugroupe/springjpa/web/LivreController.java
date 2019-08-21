package com.edugroupe.springjpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.edugroupe.springjpa.metier.Livre;
import com.edugroupe.springjpa.repositories.LivreModel;
import com.edugroupe.springjpa.repositories.LivreModelImpl;

@Controller
public class LivreController {

	@Autowired
	private LivreModel livreModel;
	
	@GetMapping("/")
	public ModelAndView liste() {
		ModelAndView mv = new ModelAndView("liste");
		mv.addObject("livres",livreModel.findAll());
		return mv;
	}
	
	@GetMapping("/bonjour")
	public ModelAndView listeCard() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("livres",livreModel.findAll());
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("livre",livreModel.findById(id));
		return mv;
	}
	
	
	@GetMapping("/create")
	public ModelAndView createLivre() {

		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("livre", new Livre(0,"titre",0,"isbn","auteur"));
		return mv;
	}
	
	
	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
			@RequestParam("titre")String titre,
			@RequestParam("nbPages") int nbPages,
			@RequestParam("isbn") String isbn,
			@RequestParam("auteur") String auteur) {
		livreModel.save(new Livre(id,titre,nbPages,isbn,auteur));
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("delete") int id) {
				
		livreModel.deleteById(id);
		return "redirect:/";

	}

	
	
}
