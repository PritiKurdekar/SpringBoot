package com.cg.apps.productms.service;

import java.util.List;

import com.cg.apps.productms.entities.Product;

public interface IProductService {

	Product add(String name, double price);

	Product changePrice(int productId, double newPrice);

	Product findById(int productId);

	List<Product> findAll();

	List<Product> findProductByName(String name);

	List<Product> findProductByPrice(double price);

	void deleteById(int productId);

}
