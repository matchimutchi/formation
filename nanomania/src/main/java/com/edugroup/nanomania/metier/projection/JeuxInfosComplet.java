package com.edugroup.nanomania.metier.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.edugroup.nanomania.metier.Genre;
import com.edugroup.nanomania.metier.JeuVideo;
import com.edugroup.nanomania.metier.Plateforme;

@Projection(name = "JeuxInfosComplet", types = JeuVideo.class)
public interface JeuxInfosComplet extends JeuxAvecEditeur{

	public Set<Genre> getGenres();
	public Set<Plateforme> getPlateFormes();
}
