package com.edugroup.revision1.metier.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.edugroup.revision1.metier.Soda;


@Projection(name = "SodaDescription", types = Soda.class)
public interface SodaDescription {
	@Value("#{target.nom + ' et ' + target.marque}")
	public String getDescription();
	public double getPrix();
}
