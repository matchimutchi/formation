package com.edugroup.nanomania.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.nanomania.metier.Editeur;
import com.edugroup.nanomania.metier.JeuVideo;
import com.edugroup.nanomania.metier.projection.JeuxAvecEditeur;
import com.edugroup.nanomania.metier.projection.JeuxInfosComplet;
import com.edugroup.nanomania.repositories.EditeurRepository;
import com.edugroup.nanomania.repositories.JeuxVideoRepository;


@RestController
@RequestMapping(value= "/jeuxvideos")
@CrossOrigin
public class JeuxVideoController {

	//attribut 
		private final ProjectionFactory projectionFactory;
		
		@Autowired
		public JeuxVideoController(ProjectionFactory projectionFactory) {
			this.projectionFactory = projectionFactory;
		}
		
		@Autowired
		private JeuxVideoRepository jeuxVideosRepository;
		
		@Autowired
		private EditeurRepository editeurRepository;
		@GetMapping()
		public Page<JeuxAvecEditeur> findAll(@PageableDefault(page = 0, size= 10) Pageable page, 
											@RequestParam("editeurId") Optional<Integer> editeurId){
			if(editeurId.isPresent()) {
				return jeuxVideosRepository.findByEditeurId(editeurId.get(), page).map(jeux -> projectionFactory.createProjection(JeuxAvecEditeur.class,jeux));
			}else {
				return jeuxVideosRepository.findAll(page).map(jeux -> projectionFactory.createProjection(JeuxAvecEditeur.class,jeux));
			}
			
		}
		
		@GetMapping(value = "/complet")
		public Page<JeuxInfosComplet> findAllJeuxInfosComplet(@PageableDefault(page = 0, size= 10) Pageable page){
			
			return jeuxVideosRepository.findAll(page).map(jv -> projectionFactory.createProjection(JeuxInfosComplet.class,jv));
		}
		
		@GetMapping(value = "/editeurs")
		public Iterable<Editeur> listeEditeur(){
			return editeurRepository.findAll();
		}
		
		
}
