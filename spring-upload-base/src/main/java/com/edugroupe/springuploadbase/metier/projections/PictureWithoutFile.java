package com.edugroupe.springuploadbase.metier.projections;

import org.springframework.data.rest.core.config.Projection;

import com.edugroupe.springuploadbase.metier.Picture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PictureWithoutFile {
	
	private int id;
	private String titre;
	private String fileName;
	private String contentType;
	
}