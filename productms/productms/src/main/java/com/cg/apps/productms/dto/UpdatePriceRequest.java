package com.cg.apps.productms.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
public class UpdatePriceRequest {
	@Min(1)
	private int id;
	@Max(30000)
	@Min(10000)
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
