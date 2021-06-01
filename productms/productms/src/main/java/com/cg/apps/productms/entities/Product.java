package com.cg.apps.productms.entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Product {
	@GeneratedValue
	@Id
	private int id;
	private String name;
	private double price;

	public Product() {

	}

	public Product(String name, double salary) {
		this.name = name;
		this.price = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
