package com.cg.apps.productms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.productms.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findProductByName(String name);

	List<Product> findProductByPrice(double price);

}
