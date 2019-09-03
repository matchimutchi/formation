package com.edugroupe.springproduituploadrep.repositories;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edugroupe.springproduituploadrep.metier.Image;
import com.edugroupe.springproduituploadrep.util.FileStorageManager;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.resizers.configurations.ScalingMode;



public class ProduitRepositoryImpl implements ProduitRepositoryCustom {

	@Autowired
	private FileStorageManager fileStorageManager;
	
	
	public static final int THUMB_WIDTH = 224;
	public static final int THUMB_HEIGHT = 224;
	

	//-------------SAVE image et thumbnail---------------------
	@Override
	public boolean saveImageFile(Image image, InputStream file) {
	
		String storageId = fileStorageManager.saveNewFile("images", file);
		image.setStorageid(storageId);
		

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			Thumbnails.of(fileStorageManager.getImageFile(storageId).get())
					.size(THUMB_WIDTH, THUMB_HEIGHT)
					.scalingMode(ScalingMode.BICUBIC)
					.outputFormat("jpg")
					.toOutputStream(bos);
			//sauvergarder ma miniture
			String thumbStorageId = fileStorageManager.saveNewFile("imagesthumb", new ByteArrayInputStream(bos.toByteArray()));
			image.setThumbStorageId(thumbStorageId);
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("erreur a la generation de miniture",e);
		}
		return true;
	}

	
	
	//------------- image  ---------------------
	@Override
	public Optional<File> getImageFile(String storageid) {
		return fileStorageManager.getImageFile(storageid);
	}

	
	
	
	//----------------effacement image et thumbnail------------------------
	@Override
	public boolean deleteImageFile(Image image) {
			
		boolean successA = fileStorageManager.deleteFile(image.getStorageid());
		boolean successB = fileStorageManager.deleteFile(image.getThumbStorageId());
		return successA && successB;
		
	}



	
}
