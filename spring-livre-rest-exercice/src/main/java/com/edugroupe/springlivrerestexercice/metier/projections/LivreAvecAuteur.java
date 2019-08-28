package com.edugroupe.springlivrerestexercice.metier.projections;

import java.time.LocalDate;

import org.springframework.data.rest.core.config.Projection;

import com.edugroupe.springlivrerestexercice.metier.Livre;

@Projection(types = { Livre.class })
public interface LivreAvecAuteur {

	int getId();
	String getTitre();
	int getNbPages();
	String  getIsbn();
	LocalDate getDateSortie();
}
