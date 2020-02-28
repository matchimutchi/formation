package com.edugroup.revision1.metier.projection;

import org.springframework.data.rest.core.config.Projection;

import com.edugroup.revision1.metier.Soda;

@Projection(name = "SodaAvecPrix", types = Soda.class)
public interface SodaAvecPrix {

	public int getId();
	public String getNom();
	public String getMarque();
	public double getPrix();
}
