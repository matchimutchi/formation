package com.edugroupe.springuploadrepbase.repositories;

import java.io.File;
import java.io.InputStream;
import java.util.Optional;

import com.edugroupe.springuploadrepbase.metier.Picture;

public interface PictureRepositoryCustom {

	boolean savePictureFile(Picture picture,InputStream file);
	Optional<File> getPictureFile(String storageid);
	boolean deletePictureFile(Picture picture);
}
