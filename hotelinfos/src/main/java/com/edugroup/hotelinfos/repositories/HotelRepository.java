package com.edugroup.hotelinfos.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.hotelinfos.metier.Hotel;




public interface HotelRepository extends PagingAndSortingRepository<Hotel, Integer> {
	Optional<Hotel> findByNomHotel(String nomHotel);
}
