package com.edugroupe.springuploadrepbase.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileStorageManager {
	
	@Value("${filestorage.base-repertoire}")
	private File storageRoot;
	
	private Random rd = new Random();
	
	
	
	//--------------CREATION D UN NOM DE FICHIER ALEATOIRE DANS UN REPERTOIRE---------------
	public String saveNewFile(String collection, InputStream data) {
		
		//si le repertoire n'est pas bon, sauf qui peut
		if(storageRoot == null || !storageRoot.exists() || !storageRoot.isDirectory()) {
			throw new RuntimeException("storage root invalid");
		}
		
		
		//----------------------------Creer un nom au fichier aleatoire pour la securité--------------------
		String name = collection + "#"+ rd.nextLong() + LocalDateTime.now().getNano();
		
		//------------------------DigestUtils = gére les encodage-----------------------
		String sha1Name= DigestUtils.sha1Hex(name);
		String sousRep = sha1Name.substring(0,2);
		
		//---------------------Je me positionne sur  le repertoire--------------------------
		//je me positionne sur le sous repertoire devant contrnir mon image
		File rep = Paths.get(storageRoot.getAbsolutePath(), sousRep).toFile();
		
		//--------------------on creer le sous rep s'il n'existe pas déjà-------------------------
		if(!rep.exists()) {
			rep.mkdir();
		}
		if(!rep.isDirectory()) {
			throw new RuntimeException("unable to create storage dir for " + sha1Name);
		}
		
		System.out.println("Sauvegarde de " + sha1Name);
		
		try {
			//---------------copie le fichier en utilisant cette synthaxe------------------
			Files.copy(data, Paths.get(rep.getAbsolutePath(), sha1Name),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("unable to save file ", e);
		}
		return sha1Name;
		
	}
	
	
	
	
	//-----------------------------INSERER UNE IMAGE--------------------------------
	public Optional<File> getImageFile(String storageId){
		//---------------------si le repertoire n'est pas bon, sauf qui peut-----------
		if(storageRoot == null || !storageRoot.exists() || !storageRoot.isDirectory()) {
			throw new RuntimeException("storage root invalid");
		}
		
		//--------------------RECUPERER SOUS REPERTOIRE-----------------------
		//repertoire de base / deux numero
		File rep = Paths.get(storageRoot.getAbsolutePath(),storageId.substring(0,2)).toFile();
		
		if(!rep.exists() || !rep.isDirectory()) {
			return Optional.empty(); //empty = pas de fichier
		}
		
		//-----------------chemin du fichier complet-----------------------
		File f = Paths.get(rep.getAbsolutePath(),storageId).toFile();
		if(f!= null && f.exists() && f.isFile()) {
			return Optional.of(f);
			
		}else {
			return Optional.empty();
		}
	}
	
	
	
	//------------------------SUPPRESION------------------------------
	public boolean deleteFile(String storageId) {
		
		if(storageRoot == null || !storageRoot.exists() || !storageRoot.isDirectory()) {
			return false;
		}
		
		
		//--------------------RECUPERER SOUS REPERTOIRE-----------------------
		//repertoire de base / deux numero
		
		File rep = Paths.get(storageRoot.getAbsolutePath(),storageId.substring(0,2)).toFile();
	
		if(!rep.exists() || !rep.isDirectory()) {
			return false; //empty = pas de fichier
		}
		
		
		//-----------------chemin du fichier complet-----------------------
		File f = Paths.get(rep.getAbsolutePath(),storageId).toFile();
		if(f!= null && f.exists() && f.isFile()) {
			return f.delete();
			
		}else {
			return false;
		}
		
		
		
	}
	
	
	
	
	
}
