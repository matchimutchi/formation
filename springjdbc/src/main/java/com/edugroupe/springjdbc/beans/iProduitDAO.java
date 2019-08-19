package com.edugroupe.springjdbc.beans;

import com.edugroupe.springjdbc.metier.Produit;

public interface iProduitDAO {

	Produit findById(int id);

}