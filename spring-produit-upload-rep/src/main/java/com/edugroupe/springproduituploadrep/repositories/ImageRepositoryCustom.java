package com.edugroupe.springproduituploadrep.repositories;

import java.io.File;
import java.io.InputStream;
import java.util.Optional;

import com.edugroupe.springproduituploadrep.metier.Image;

public interface ImageRepositoryCustom {

	boolean saveImageFile(Image image, InputStream file);
	Optional<File> getImageFile(String storageid);
	boolean deleteImageFile(Image image);

}
