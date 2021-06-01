package com.cg.hotelms.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Hotel {
	@GeneratedValue
    @Id
	private long id;
	private String hotelName;
	private String address;
	public Hotel() {
		
	}
	
	public Hotel(String hotelName, String address) {
		
		this.hotelName = hotelName;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Hotel hotel = (Hotel) o;
	        return Objects.equals(id, hotel.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	
}
