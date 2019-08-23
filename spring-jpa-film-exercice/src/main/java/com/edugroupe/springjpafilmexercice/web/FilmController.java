package com.edugroupe.springjpafilmexercice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edugroupe.springjpafilmexercice.metier.Film;
import com.edugroupe.springjpafilmexercice.repositories.ActeurModel;
import com.edugroupe.springjpafilmexercice.repositories.FilmModel;
import com.edugroupe.springjpafilmexercice.repositories.RealisateurModel;


@Controller
public class FilmController {

	@Autowired
	private FilmModel filmModel;

	@Autowired
	private ActeurModel acteurModel;
	
	
	@Autowired
	private RealisateurModel realisateurModel;
	
	@GetMapping("/")
	public ModelAndView liste() {
		ModelAndView mv = new ModelAndView("film/liste");
		mv.addObject("films",filmModel.findAll(true));
		System.out.println("sortie du controller");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("film/edit");
		mv.addObject("film",filmModel.findById(id));
		mv.addObject("realisateurs",realisateurModel.findAll(false));
		mv.addObject("acteurs",acteurModel.findAll());
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("film/edit");
		mv.addObject("film",new Film(0,"nom",0,0));
		mv.addObject("realisateurs",realisateurModel.findAll(false));
		return mv;
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
						@RequestParam("nom") String nom,
						@RequestParam("duree") int duree,
						@RequestParam("annee") int annee,
						@RequestParam("realisateurId") int realisateurId) {
		filmModel.save(new Film(id,nom,duree,annee),realisateurId);
		return "redirect:/";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("delete") int id) {				
		filmModel.deleteById(id);
		return "redirect:/";

	}
	
	
	@GetMapping("/film/{id}/editActeurs")
	public ModelAndView editFilmActeurs(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("film/acteur");
		mv.addObject("film",filmModel.findById(id));
		mv.addObject("selected_acteurs",filmModel.findFilmActeur(id));
		mv.addObject("unselected_acteurs",filmModel.findFilmNotActeur(id));
		return mv;
	}
	
	@PostMapping("/film/addActeur")
	public String addActeurToFilm(@RequestParam("filmId") int filmId,@RequestParam("acteurId") int acteurId) {
		filmModel.addActeurToFilm(filmId, acteurId);
		return "redirect:/film/" + filmId + "/editActeurs";
	}
	
	@PostMapping("/film/removeActeur")
	public String removeActeurToFilm(@RequestParam("filmId") int filmId,@RequestParam("acteurId") int acteurId) {
		filmModel.removeActeurToFilm(filmId, acteurId);
		return "redirect:/film/" + filmId + "/editActeurs";
	}
	
}
