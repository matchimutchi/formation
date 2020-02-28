package com.edugroup.revision1.web;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.revision1.metier.Soda;
import com.edugroup.revision1.metier.projection.SodaDescription;
import com.edugroup.revision1.repositories.SodaRepository;

@RestController
@RequestMapping(value= "/sodaweb")
public class SodaController {
	
	//attribut 
	private final ProjectionFactory projectionFactory;
	
	@Autowired
	public SodaController(ProjectionFactory projectionFactory) {
		this.projectionFactory = projectionFactory;
	}
	
	@Autowired
	private SodaRepository sodaRepository;
	
	@GetMapping
	public Iterable<Soda> findAllSoda(){
		return sodaRepository.findAll();
	}
	
	@GetMapping(value = "/description")
	public Page<SodaDescription> findAllSodaDescription(@PageableDefault Pageable page){
		return sodaRepository.findAll(page).map(soda -> projectionFactory.createProjection(SodaDescription.class,soda));
	}
	
	
}
