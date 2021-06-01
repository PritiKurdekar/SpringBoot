package com.cg.apps.productms.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

public class CreateProductRequest {
//	@NonNull
//	@NotBlank
	@Length(min =3, max=10)
	private String name;
	
	@Max(30000)
	@Min(10000)
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
