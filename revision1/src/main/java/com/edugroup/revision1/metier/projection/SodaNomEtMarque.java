package com.edugroup.revision1.metier.projection;

import org.springframework.data.rest.core.config.Projection;

import com.edugroup.revision1.metier.Soda;

@Projection(name = "SodaNomEtMarque", types = Soda.class)
public interface SodaNomEtMarque {

	public String getNom();
	public String getMarque();
	
}
