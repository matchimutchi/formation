package com.edugroup.revision2.metier.projection;

import org.springframework.data.rest.core.config.Projection;

import com.edugroup.revision2.metier.Terroir;
import com.edugroup.revision2.metier.Vin;

@Projection(name = "VinAvecTerroir" , types = Vin.class)
public interface VinAvecTerroir {

	public String getNom();
	public String getAnnee();
	public Terroir getTerroir();
}
