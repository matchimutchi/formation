package com.edugroup.nanomania.util;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.edugroup.nanomania.metier.Editeur;
import com.edugroup.nanomania.metier.Genre;
import com.edugroup.nanomania.metier.JeuVideo;
import com.edugroup.nanomania.metier.Plateforme;
import com.edugroup.nanomania.repositories.EditeurRepository;
import com.edugroup.nanomania.repositories.GenreRepository;
import com.edugroup.nanomania.repositories.JeuxVideoRepository;
import com.edugroup.nanomania.repositories.PlateFormeRepository;

@Service
public class DatabaseInitialiser implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private JeuxVideoRepository jeuxVideoRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private EditeurRepository editeurepository;
	@Autowired
	private PlateFormeRepository plateformeRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("verification initialisation base");
		if(jeuxVideoRepository.count() == 0 && genreRepository.count() == 0 && plateformeRepository.count() == 0 && editeurepository.count() == 0 ) {
			System.out.println("verification entrer dans les données");
			//pas de donnée dans la base on initialise 
			Genre g1 = genreRepository.save(new Genre(0, "aventure",null));
			Genre g2 = genreRepository.save(new Genre(0, "rpg",null));
			Genre g3 = genreRepository.save(new Genre(0, "sport",null));
			
			Editeur e1 = editeurepository.save(new Editeur(0,"ubisoft","ubi@soft.com",null));
			Editeur e2 = editeurepository.save(new Editeur(0,"rockstar","ubi@soft.com",null));
			
			Plateforme p1 = plateformeRepository.save(new Plateforme(0,"xbox one","microsoft",null));
			Plateforme p2 = plateformeRepository.save(new Plateforme(0,"ps4","sony",null));
			Plateforme p3 = plateformeRepository.save(new Plateforme(0,"switch","nintendo",null));
			
			
			JeuVideo jv1 = new JeuVideo(0,"GTA4", LocalDate.of(2015, 10, 12), new HashSet<>(),new HashSet<>(), e2);
			jv1.getGenres().add(g1);
			jv1.getGenres().add(g2);
			jv1.getPlateFormes().add(p1);
			jv1.getPlateFormes().add(p2);
			
			jeuxVideoRepository.save(jv1);
			
			JeuVideo jv2 = new JeuVideo(0,"Monster Hunter", LocalDate.of(2018, 01, 24), new HashSet<>(),new HashSet<>(), e2);
			jv2.getGenres().add(g1);
			jv2.getGenres().add(g2);
			jv2.getPlateFormes().add(p1);
			jv2.getPlateFormes().add(p2);
					
			
			jeuxVideoRepository.save(jv2);
		}
	}

}
