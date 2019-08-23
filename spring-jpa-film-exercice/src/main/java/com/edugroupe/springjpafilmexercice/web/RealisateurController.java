package com.edugroupe.springjpafilmexercice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.edugroupe.springjpafilmexercice.metier.Realisateur;
import com.edugroupe.springjpafilmexercice.repositories.RealisateurModel;

@Controller
public class RealisateurController {

	@Autowired
	private RealisateurModel realisateurModel;
	
	@GetMapping("/accueil")
	public ModelAndView liste() {
		ModelAndView mv = new ModelAndView("realisateur/liste");
		mv.addObject("realisateurs",realisateurModel.findAll(true));
		return mv;
	}
	
	@GetMapping("/editRealisateur/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("realisateur/edit");
		mv.addObject("realisateur",realisateurModel.findById(id));
		return mv;
	}
	
	@GetMapping("/createRealisateur")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("realisateur/edit");
		mv.addObject("realisateur",new Realisateur(0,"nom","prenom","societe"));
		return mv;
	}
	
	@PostMapping("/saveRealisateur")
	public String save(@RequestParam("id") int id,
						@RequestParam("nom") String nom,
						@RequestParam("prenom") String prenom,
						@RequestParam("societe") String societe) {
		realisateurModel.save(new Realisateur(id,nom,prenom,societe));
		return "redirect:/accueil";
	}
	
	
	@PostMapping("/deleteRealisateur")
	public String delete(@RequestParam("delete") int id) {				
		realisateurModel.deleteById(id);
		return "redirect:/accueil";

	}
	
	
	@GetMapping("/realisateur/{id}/editRealisateurs")
	public ModelAndView editFilmActeurs(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("realisateur/film");
		mv.addObject("realisateur",realisateurModel.findById(id));
		mv.addObject("selected_realisateurs",realisateurModel.findRealisateurFilm(id));
		mv.addObject("unselected_realisateurs",realisateurModel.findRealisateurNotFilm(id));
		return mv;
	}
	
	@PostMapping("/realisateur/addRealisateur")
	public String addActeurToFilm(@RequestParam("realisateurId") int realisateurId,@RequestParam("filmId") int filmId) {
		realisateurModel.addFilmToRealisateur(realisateurId, filmId);
		return "redirect:/realisateur/" + realisateurId + "/editRealisateurs";
	}
	
	@PostMapping("/realisateur/removeRealisateur")
	public String removeActeurToFilm(@RequestParam("realisateurId") int realisateurId,@RequestParam("filmId") int filmId) {
		realisateurModel.removeFilmToRealisateur(realisateurId, filmId);
		return "redirect:/film/" + filmId + "/editActeurs";
	}
}
