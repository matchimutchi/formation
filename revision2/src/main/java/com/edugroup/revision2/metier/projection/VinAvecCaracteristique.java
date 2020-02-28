package com.edugroup.revision2.metier.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.edugroup.revision2.metier.Caracteristique;
import com.edugroup.revision2.metier.Terroir;
import com.edugroup.revision2.metier.Vin;

@Projection(name = "VinAvecCaracteristique" , types = Vin.class)
public interface VinAvecCaracteristique {

		public String getNom();
		public String getAnnee();
		public Terroir getTerroir();
		public Set<Caracteristique> getCaracteristiques();
}
