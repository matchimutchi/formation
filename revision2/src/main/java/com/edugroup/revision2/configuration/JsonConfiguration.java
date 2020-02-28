package com.edugroup.revision2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.edugroup.revision2.metier.Vin;


@Configuration
public class JsonConfiguration implements RepositoryRestConfigurer {

	
	@Bean
	public SpelAwareProxyProjectionFactory projectionFactory() {
		return new SpelAwareProxyProjectionFactory();
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {	
		config.exposeIdsFor(Vin.class);
		
	}
}
