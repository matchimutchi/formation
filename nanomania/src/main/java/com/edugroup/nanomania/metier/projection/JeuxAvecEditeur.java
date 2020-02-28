package com.edugroup.nanomania.metier.projection;

import java.time.LocalDate;

import org.springframework.data.rest.core.config.Projection;

import com.edugroup.nanomania.metier.Editeur;
import com.edugroup.nanomania.metier.JeuVideo;


@Projection(name = "JeuxAvecEditeur", types = JeuVideo.class)
public interface JeuxAvecEditeur {

	public int getId();
	public String getNom();
	public LocalDate getDateSortie();
	public Editeur getEditeur();
}
