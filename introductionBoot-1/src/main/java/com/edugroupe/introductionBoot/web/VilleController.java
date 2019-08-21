package com.edugroupe.introductionBoot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edugroupe.introductionBoot.dao.VilleDAO;
import com.edugroupe.introductionBoot.metier.Ville;

@Controller
public class VilleController {

	
	@Autowired
	private VilleDAO villeDAO;
	
	
	@GetMapping("/bonjour")
	public String bonjour(Model model) 
	{
		Ville v = villeDAO.findById(4);
		model.addAttribute("titre", v.getNom());
		model.addAttribute("population","Population : " + v.getPopulation());
		model.addAttribute("surface","Surface : " + v.getSurface());
		model.addAttribute("pays","Pays : " + v.getPays());
		
		Ville v1 = villeDAO.findById(2);
		model.addAttribute("titre1",v1.getNom());
		model.addAttribute("population1","Population : " + v1.getPopulation());
		model.addAttribute("surface1","Surface : " + v1.getSurface());
		model.addAttribute("pays1","Pays : " + v1.getPays());
		
		Ville v2 = villeDAO.findById(3);
		model.addAttribute("titre2",v2.getNom());
		model.addAttribute("population2","Population : " + v2.getPopulation());
		model.addAttribute("surface2","Surface : " + v2.getSurface());
		model.addAttribute("pays2","Pays : " + v2.getPays());

		return "home";
	}
	
	
	@GetMapping("/liste")
	public ModelAndView listeTableau() {
		
		ModelAndView mv = new ModelAndView("liste");
		mv.addObject("villes", villeDAO.findAll());
		return mv;
	}
	
	
	@GetMapping("/edit/{ville_id}")
	public ModelAndView editVille(@PathVariable("ville_id") int vid) {

		ModelAndView mv = new ModelAndView("edit");
		Ville v = villeDAO.findById(vid);
		if(v == null)
			mv.setViewName("redirect:/liste");
		else
			mv.addObject("ville", v);
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView createVille() {

		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("ville", new Ville(0,"nom",0,0.0,"pays"));
		return mv;
	}
	
	
	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
			@RequestParam("nom") String nom,
			@RequestParam("population") int population,
			@RequestParam("surface") double surface,
			@RequestParam("pays") String pays)
	{
		
		Ville v = new Ville(id,nom,population,surface,pays);
		villeDAO.save(v);
		return "redirect:/liste"; 
	}
	
	@GetMapping("/search")
	public ModelAndView searchVille(@RequestParam("search") String vnom) {
		
		ModelAndView mv = new ModelAndView("liste");
		List<Ville> v = villeDAO.search(vnom);
		mv.addObject("villes", v);		
		return mv;
		
	}
	
	@PostMapping("/delete")
	public ModelAndView deleteVille(@RequestParam("delete") int vid) {
		
		ModelAndView mv = new ModelAndView("redirect:/liste");
		villeDAO.deleteById(vid);

		return mv;

	}
}
