package com.edugroupe.springuploadrepbase.repositories;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edugroupe.springuploadrepbase.metier.Picture;
import com.edugroupe.springuploadrepbase.util.FileStorageManager;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.resizers.configurations.ScalingMode;

public class PictureRepositoryImpl implements PictureRepositoryCustom {

	@Autowired
	private FileStorageManager fileStorageManager;
	
	//STOKAGE DES FUNCTION DANS L INTERFACE PictureRepositoryCustom
	//----------------------------------CONSTANTE-------------------------
	//taille des miniature
	public static final int THUMB_WIDTH = 224;
	public static final int THUMB_HEIGHT = 224;
	
	
	
	
	//-------------SAVE image et thumbnail---------------------
	@Override
	public boolean savePictureFile(Picture picture, InputStream file) {
		//------------------------sauvegarder de l'image original-----------------------
		String storageId = fileStorageManager.saveNewFile("pictures", file);
		picture.setStorageid(storageId);
		
		
		
		//------------------------generation de la miniature et sa sauvegarde-----------------------
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			Thumbnails.of(fileStorageManager.getImageFile(storageId).get())
					.size(THUMB_WIDTH, THUMB_HEIGHT)
					.scalingMode(ScalingMode.BICUBIC)
					.outputFormat("jpg")
					.toOutputStream(bos);
			//sauvergarder ma miniture
			String thumbStorageId = fileStorageManager.saveNewFile("picturesthumb", new ByteArrayInputStream(bos.toByteArray()));
			picture.setThumbStorageId(thumbStorageId);
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("erreur a la generation de miniture",e);
		}
		return true;
	}

	
	
	//------------- image  ---------------------
	@Override
	public Optional<File> getPictureFile(String storageid) {
		return fileStorageManager.getImageFile(storageid);
	}

	
	
	
	//----------------effacement image et thumbnail------------------------
	@Override
	public boolean deletePictureFile(Picture picture) {
		
		
		
		boolean successA = fileStorageManager.deleteFile(picture.getStorageid());
		boolean successB = fileStorageManager.deleteFile(picture.getThumbStorageId());
		return successA && successB;
		
	}
}
