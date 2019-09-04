package com.edugroupe.springproduituploadrep.web;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edugroupe.springproduituploadrep.metier.Image;
import com.edugroupe.springproduituploadrep.metier.Produit;
import com.edugroupe.springproduituploadrep.repositories.ImageRepository;
import com.edugroupe.springproduituploadrep.repositories.ProduitRepository;


@Controller
@RequestMapping("/images")
public class ImageController {

	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	//----------------------------------RECHERCHER TTES LES IMAGES-----------------------
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public Page<Image> findAll(@PageableDefault(page = 0,size = 10) Pageable page){
		return imageRepository.findAll(page);		
	}
	
	
	//----------------------------------RECHERCHER UNE IMAGE-----------------------
	@GetMapping(value="/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Image> findById(@PathVariable("id") int id) {
		return imageRepository.findById(id)
								.map(i -> new ResponseEntity<>(i , HttpStatus.OK))
								.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	
	
	
	
	
	//----------------------------------INJECTER UNE IMAGE-----------------------
	@PostMapping(value="/upload",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")	
	public ResponseEntity<Image> upload(@RequestParam("file") MultipartFile file,
			@RequestParam("nom") Optional<String> nom, 
			@RequestParam("produitId") Optional<Integer> produitId) {
		
		try {
			Image i = new Image(0, 
								nom.orElse(file.getOriginalFilename()),
								file.getOriginalFilename(), 
								file.getContentType(), 
								DigestUtils.sha1Hex(file.getInputStream()), 
								"");		
			
			if(produitId.isPresent()) {
				i.setProduit(produitRepository.findById(produitId.get()).orElse(null));
			}
			//----------------------sauvegarde et generation thumbnail-------------------
			imageRepository.saveImageFile(i, file.getInputStream());
			
			i = imageRepository.save(i);
			return new ResponseEntity<Image>(i,HttpStatus.CREATED);
		} catch (IOException e) {e.printStackTrace();}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
				
		
	}
	
	
	
	
	
	
	//----------------------------------GERER LES IMAGES-----------------------
	@GetMapping(value="/{id:[0-9]+}/data")
	@ResponseBody
	@CrossOrigin("http://localhost:4200")	
	public ResponseEntity<FileSystemResource> imageData(@PathVariable("id") int id){
		Optional<Image> op = imageRepository.findById(id);
		
		if(!op.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Optional<File> ofile = imageRepository.getImageFile(op.get().getStorageid());
		
		if(!ofile.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		//entet de la reponse
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(op.get().getContentType()));
		headers.setContentLength(ofile.get().length());
		headers.setContentDispositionFormData("attachment", op.get().getFileName());
		
		//on retourne les 3 declarations
		ResponseEntity<FileSystemResource> re = new ResponseEntity<FileSystemResource>(new FileSystemResource(ofile.get()),headers,HttpStatus.OK);
				
		
		return re;
				
		
	}
	
	
	
	
	
	
	//----------------------------------GERER LES IMAGES MINIATURES-----------------------
	@GetMapping(value="/{id:[0-9]+}/thumbdata")
	@ResponseBody
	@CrossOrigin("http://localhost:4200")	
	public ResponseEntity<FileSystemResource> imageThumbData(@PathVariable("id") int id){
		Optional<Image> op = imageRepository.findById(id);
		
		if(!op.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Optional<File> ofile = imageRepository.getImageFile(op.get().getThumbStorageId());
		
		if(!ofile.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		//entet de la reponse
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(ofile.get().length());
		headers.setContentDispositionFormData("attachment", op.get().getFileName());
		
		//on retourne les 3 declarations
		ResponseEntity<FileSystemResource> re = new ResponseEntity<FileSystemResource>(new FileSystemResource(ofile.get()),headers,HttpStatus.OK);
				
		
		return re;
						
	}
	
	
	
	@DeleteMapping(value="/{id:[0-9]+}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Map<String, Object>> deleteImage(@PathVariable("id") int id){
		
		return imageRepository.findById(id)
				.map(i -> {
				imageRepository.deleteImageFile(i);
				imageRepository.delete(i);
				return new ResponseEntity<Map<String, Object>>(
						Collections.singletonMap("nbdeleted", 1),
						HttpStatus.ACCEPTED);
			})
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	//----------------------------------UPDATE--------------------------------------
	@PutMapping(value="/{id:[0-9]+}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Image> updateImage(@PathVariable("id") int id,@RequestParam("nom") String nom){
		Optional<Image> opict = imageRepository.findById(id);
		if(!opict.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Image i = opict.get();
		i.setNom(nom);
		i = imageRepository.save(i);//sauvegarde
		return new ResponseEntity<Image>(i, HttpStatus.ACCEPTED);
	}
}
