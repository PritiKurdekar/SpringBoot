package com.cg.hotelms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hotelms.entities.Hotel;
import com.cg.hotelms.service.IHotelService;

@Controller
public class HotelControllers {
	@Autowired
	private IHotelService service;

	@GetMapping("/fetchinfo")
	public ModelAndView fetchHotel(@RequestParam("hotelid") long id) {
		Hotel hotel = service.findById(id);
		ModelAndView response = new ModelAndView("hotelinfo", "hotel", hotel);
		return response;
	}

	@GetMapping("/hoteldetails")
	public ModelAndView getHotelInformation() {
		ModelAndView response = new ModelAndView("getinfo");
		return response;
	}

	@GetMapping("/register")
	public ModelAndView registerHotel() {
		ModelAndView response = new ModelAndView("register");
		return response;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("hotelname") String name,
			@RequestParam("hoteladdress") String address) {
		Hotel hotel = service.add(name, address);
		ModelAndView response = new ModelAndView("hotelinfo", "hotel", hotel);
		return response;
	}

	@GetMapping("/getall")
	public ModelAndView getAllHotels() {
		List<Hotel> list = service.findAll();
		ModelAndView response = new ModelAndView("listhotels", "list", list);
		return response;
	}

}
