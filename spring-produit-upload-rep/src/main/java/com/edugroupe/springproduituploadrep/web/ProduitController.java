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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edugroupe.springlivrerestexercice.metier.Livre;
import com.edugroupe.springproduituploadrep.metier.Produit;
import com.edugroupe.springproduituploadrep.repositories.ImageRepository;
import com.edugroupe.springproduituploadrep.repositories.ProduitRepository;
import com.edugroupe.springuploadrepbase.metier.Picture;



@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	
	//----------------------------------RECHERCHER TTES LES IMAGES-----------------------
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public Page<Produit> findAll(@PageableDefault(page = 0,size = 10) Pageable page){
		return produitRepository.findAll(page);		
	}
	
	
	//----------------------------------RECHERCHER UNE IMAGE-----------------------
	@GetMapping(value="/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Produit> findById(@PathVariable("id") int id) {
		return produitRepository.findById(id)
								.map(p -> new ResponseEntity<>(p , HttpStatus.OK))
								.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	


	
	//----------------------------------INJECTER UNE IMAGE-----------------------
	@PostMapping(value="/upload",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")	
	public ResponseEntity<Produit> upload(@RequestParam("file") MultipartFile file,
			@RequestParam("titre") Optional<String> titre) {
		
		try {
			Produit p = new Produit(0, "", 0.0, 0.0);		
			
			//----------------------sauvegarde et generation thumbnail-------------------
			produitRepository.saveImageFile(p, file.getInputStream());
			p = produitRepository.save(p);
			return new ResponseEntity<Produit>(p,HttpStatus.CREATED);
		} catch (IOException e) {e.printStackTrace();}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
				
		
	}
	
	
	
	
	
	
	//----------------------------------GERER LES IMAGES-----------------------
	@GetMapping(value="/{id:[0-9]+}/data")
	@ResponseBody
	@CrossOrigin("http://localhost:4200")	
	public ResponseEntity<FileSystemResource> pictureData(@PathVariable("id") int id){
		Optional<Produit> op = produitRepository.findById(id);
		
		if(!op.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Optional<File> ofile = produitRepository.getPictureFile(op.get().getStorageid());
		
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
	public ResponseEntity<FileSystemResource> pictureThumbData(@PathVariable("id") int id){
		Optional<Produit> op = produitRepository.findById(id);
		
		if(!op.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Optional<File> ofile = produitRepository.getPictureFile(op.get().getThumbStorageId());
		
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
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id){
		
		return produitRepository.findById(id)
				.map(p -> {
				produitRepository.delete(p);
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
	public ResponseEntity<Produit> updatePicture(@RequestBody Produit produit ,@PathVariable("id") int id){
		Optional<Produit> p = produitRepository.findById(produit.getId());
		if(!p.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Produit p1 = p.get();
		p1.setNom(produit.getNom());
		p1.setPoids(produit.getPoids());
		p1.setPrix(produit.getPrix());

		p1 = produitRepository.save(p1);//sauvegarde
		return new ResponseEntity<Produit>(p1, HttpStatus.ACCEPTED);
	}
	

	
}
