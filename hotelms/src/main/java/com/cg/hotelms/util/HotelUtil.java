package com.cg.hotelms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.hotelms.dto.HotelDetails;
import com.cg.hotelms.entities.Hotel;


@Component
public class HotelUtil {
	public HotelDetails toDetails(Hotel hotel) {
		HotelDetails details = new HotelDetails();
		details.setId(hotel.getId());
		details.setHotelName(hotel.getHotelName());
		details.setAddress(hotel.getAddress());
		return details;
	}

	public List<HotelDetails> toDetailsList(Collection<Hotel> hotels) {

		List<HotelDetails> desired = new ArrayList<>();
		for (Hotel htl : hotels) {
			HotelDetails details = toDetails(htl);
			desired.add(details);
		}
		return desired;
	}

}
