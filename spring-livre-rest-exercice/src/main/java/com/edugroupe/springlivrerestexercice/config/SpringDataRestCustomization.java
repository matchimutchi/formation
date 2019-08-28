package com.edugroupe.springlivrerestexercice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.edugroupe.springlivrerestexercice.metier.Auteur;
import com.edugroupe.springlivrerestexercice.metier.Livre;


@Configuration
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		super.configureRepositoryRestConfiguration(config);
		config.exposeIdsFor(Livre.class, Auteur.class);
		
	}

}
