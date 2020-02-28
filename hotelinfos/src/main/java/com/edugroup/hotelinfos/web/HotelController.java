package com.edugroup.hotelinfos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.hotelinfos.metier.Hotel;
import com.edugroup.hotelinfos.repositories.HotelRepository;


@RestController
@RequestMapping("/hotels")
@CrossOrigin
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;
	
	@GetMapping
	public Iterable<Hotel> liste(){
		return hotelRepository.findAll();
	}

	@GetMapping("/{nomHotel:[0-9]+}")
   public ResponseEntity<Hotel> findByIsbn(@PathVariable("nomHotel") String nomHotel){
	   return hotelRepository.findByNomHotel(nomHotel)
			   .map(h -> new ResponseEntity<Hotel>(h,HttpStatus.OK))
			   .orElse(new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND));
   }
}
