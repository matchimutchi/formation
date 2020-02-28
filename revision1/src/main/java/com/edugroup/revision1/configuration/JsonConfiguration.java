package com.edugroup.revision1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


import com.edugroup.revision1.metier.Soda;


@Configuration
public class JsonConfiguration implements RepositoryRestConfigurer {

	//objet permert de gerer les projections par exemple dans les controlleurs
	@Bean
	public SpelAwareProxyProjectionFactory projectionFactory() {
		return new SpelAwareProxyProjectionFactory();
	}
	
	//on peut ici 'forcer" spring data rest à envoyer l'id des entité dans l'api automatique
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {	
		config.exposeIdsFor(Soda.class);
		
	}
}
