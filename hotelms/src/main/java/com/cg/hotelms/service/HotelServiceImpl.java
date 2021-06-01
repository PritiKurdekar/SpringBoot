package com.cg.hotelms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.hotelms.dao.IHotelRepository;
import com.cg.hotelms.entities.Hotel;
import com.cg.hotelms.exceptions.HotelNotFoundException;
import com.cg.hotelms.exceptions.InvalidHotelAddressException;
import com.cg.hotelms.exceptions.InvalidHotelIdException;
import com.cg.hotelms.exceptions.InvalidHotelNameException;

@Transactional
@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository dao;

	@Override
	public Hotel add(String hotelName, String address) {
		validateName(hotelName);
		validateAddress(address);
		System.out.println("Inside add of hotel service");
		Hotel hotel = new Hotel(hotelName, address);
		Hotel saved = dao.save(hotel);
		return saved;
	}

	@Override
	public Hotel changeAddress(long Id, String newAddress) {
		validateId(Id);
		validateAddress(newAddress);
		Hotel hotel = findById(Id);
		hotel.setAddress(newAddress);
		Hotel saved = dao.save(hotel);
		return saved;
	}

	@Override
	public Hotel findById(long Id) {
		validateId(Id);
		Optional<Hotel> hotel = dao.findById(Id);
		if (!hotel.isPresent()) {
			throw new HotelNotFoundException("Hotel not found for id:" + Id);
		}
		return hotel.get();
	}

	@Override
	public List<Hotel> findAll() {
		List<Hotel> list = dao.findAll();
		return list;
	}

	@Override
	public List<Hotel> findHotelByHotelName(String hotelName) {
		validateName(hotelName);
		List<Hotel> list = dao.findHotelByHotelName(hotelName);
		return list;
	}
	@Override
	public void deleteById(long hotelId) {
		dao.deleteById(hotelId);
		
	}
	void validateId(long id) {
		if (id < 0) {
			throw new InvalidHotelIdException("id can't be negative");
		}
	}

	void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidHotelNameException("name can't be null or empty");
		}

	}

	void validateAddress(String address) {
		if (address == null || address.isEmpty()) {
			throw new InvalidHotelAddressException("address can't be null or empty");
		}

	}

	
}
