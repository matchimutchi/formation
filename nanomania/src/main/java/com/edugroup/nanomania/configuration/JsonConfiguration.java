package com.edugroup.nanomania.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.edugroup.nanomania.metier.Editeur;
import com.edugroup.nanomania.metier.Genre;
import com.edugroup.nanomania.metier.JeuVideo;
import com.edugroup.nanomania.metier.Plateforme;



@Configuration
public class JsonConfiguration implements RepositoryRestConfigurer {

	@Bean
	public SpelAwareProxyProjectionFactory projectionFactory() {
		return new SpelAwareProxyProjectionFactory();
	}
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {	
		config.exposeIdsFor(JeuVideo.class,Editeur.class,Genre.class,Plateforme.class);
		
	}
}
