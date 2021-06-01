package com.cg.hotelms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelms.entities.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Long> {

	List<Hotel> findHotelByHotelName(String hotelName);

}
