package com.cg.hotelms.dto;

public class HotelDetails {
	private long id;
	private String hotelName;
	private String address;
	public HotelDetails() {

	}
	public HotelDetails(long id, String hotelName, String address) {
		super();
		this.id = id;
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

	
}
