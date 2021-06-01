package com.cg.hotelms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotelms.dto.CreateHotelRequest;
import com.cg.hotelms.dto.HotelDetails;
import com.cg.hotelms.dto.UpdateAddressRequest;
import com.cg.hotelms.entities.Hotel;
import com.cg.hotelms.service.IHotelService;
import com.cg.hotelms.util.HotelUtil;

@RequestMapping("/hotels")
@RestController
public class HotelRestController {

	@Autowired
	private HotelUtil hotelUtil;

	@Autowired
	private IHotelService service;;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public HotelDetails addHotel(@RequestBody CreateHotelRequest requestData) {
		System.out.println("Inside addHotel \n name=" + requestData.getHotelName()+ " address=" + requestData.getAddress());
		Hotel created = service.add(requestData.getHotelName(), requestData.getAddress());
		HotelDetails response = hotelUtil.toDetails(created);
		return response;
	}

	@GetMapping("/byid/{id}")
	public HotelDetails getHotel(@PathVariable("id") long id) {
		Hotel hotel = service.findById(id);
		HotelDetails response = hotelUtil.toDetails(hotel);
		return response;
	}

	@GetMapping
	public List<HotelDetails> allHotels() {
		List<Hotel> list = service.findAll();
		List<HotelDetails> response = hotelUtil.toDetailsList(list);
		return response;
	}

	@PutMapping("/update/address")
	public HotelDetails update(@RequestBody UpdateAddressRequest requestData) {
		Hotel hotel = service.changeAddress(requestData.getId(), requestData.getAddress());
		HotelDetails response = hotelUtil.toDetails(hotel);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long hotelId) {

		service.deleteById(hotelId);

		return "Hotel deleted";

	}
}
