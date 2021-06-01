package com.cg.hotelms.service;

import java.util.List;
import com.cg.hotelms.entities.Hotel;

public interface IHotelService {
	Hotel add(String hotelName, String address);

	Hotel changeAddress(long Id, String newAddress);

	Hotel findById(long Id);

	List<Hotel> findAll();

	List<Hotel> findHotelByHotelName(String hotelName);

	void deleteById(long hotelId);
}
