package com.edugroupe.springjpaexercice.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edugroupe.springjpaexercice.metier.Post;
import com.edugroupe.springjpaexercice.repositories.PostModel;

@Controller
public class PostController {

	@Autowired
	private PostModel postModel;
	
	@GetMapping("/")
	public ModelAndView liste() {
		ModelAndView mv = new ModelAndView("liste");
		mv.addObject("posts",postModel.findAll());
		return mv;
	}
	
	@GetMapping("/home")
	public ModelAndView listeCard() {
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("posts",postModel.findAll());
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("post",postModel.findById(id));
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("post",new Post(0,"titre","corps",null,"auteur"));
		return mv;
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
						@RequestParam("titre") String titre,
						@RequestParam("corps") String corps,
						@RequestParam("auteur") String auteur) {
		postModel.save(new Post(id,titre,corps,null,auteur));
		return "redirect:/home";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("delete") int id) {
				
		postModel.deleteById(id);
		return "redirect:/home";

	}
	
	@GetMapping("/search")
	public ModelAndView search(@RequestParam("search") String auteur) {
		
		ModelAndView mv = new ModelAndView("home");
		List<Post> p = postModel.search(auteur);
		mv.addObject("posts", p);		
		return mv;
		
	}
	
	@GetMapping("/searchDate")
	public ModelAndView searchDate(@RequestParam("searchDate") LocalDate date) {
		
		ModelAndView mv = new ModelAndView("home");
		List<Post> p = postModel.searchDate(date);
		mv.addObject("posts", p);		
		return mv;
		
	}
	
	@GetMapping("/home")
	public String bonjour(Model model) 
	{
		Post p = postModel.findById(1);
		model.addAttribute("titre", p.getTitre());
		model.addAttribute("corps","corps : " + p.getCorps());
		
		Post p1 = postModel.findById(2);
		model.addAttribute("titre", p1.getTitre());
		model.addAttribute("corps","corps : " + p1.getCorps());

		Post p2 = postModel.findById(3);
		model.addAttribute("titre", p2.getTitre());
		model.addAttribute("corps","corps : " + p2.getCorps());

		return "home";
	}
}
