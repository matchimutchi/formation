package com.edugroupe.springjpafilmexercice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.edugroupe.springjpafilmexercice.repositories.FilmModel;

@Controller
public class FilmController {

	@Autowired
	private FilmModel filmModel;

	
	
	
	@GetMapping("/")
	public ModelAndView liste() {
		ModelAndView mv = new ModelAndView("film/liste");
		mv.addObject("films",filmModel.findAll());
		System.out.println("sortie du controller");
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("film/edit");
		mv.addObject("film",filmModel.findById(id));
		return mv;
	}
	
}
