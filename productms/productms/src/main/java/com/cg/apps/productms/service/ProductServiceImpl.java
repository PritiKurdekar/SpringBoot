package com.cg.apps.productms.service;

import com.cg.apps.productms.dao.IProductRepository;

import com.cg.apps.productms.entities.Product;
import com.cg.apps.productms.exceptions.InvalidPriceException;
import com.cg.apps.productms.exceptions.InvalidProductIdException;
import com.cg.apps.productms.exceptions.InvalidProductNameException;
import com.cg.apps.productms.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository dao;

	@Override
	public Product add(String name, double price) {
		validateName(name);
		validatePrice(price);
		Product product = new Product(name, price);
		Product saved = dao.save(product);
		return saved;
	}

	@Override
	public Product findById(int productId) {
		validateId(productId);
		Optional<Product> product = dao.findById(productId);
		if (!product.isPresent()) {
			throw new ProductNotFoundException("Product not found for id:" + productId);
		}
		return product.get();

	}

	@Override
	public List<Product> findAll() {
		List<Product> list = dao.findAll();
		return list;
	}

	public List<Product> findProductByName(String name) {
		validateName(name);
		List<Product> list = dao.findProductByName(name);
		return list;
	}

	public List<Product> findProductByPrice(double price) {
		List<Product> list = dao.findProductByPrice(price);
		return list;
	}

	@Override
	public Product changePrice(int productId, double newPrice) {
		validateId(productId);
		validatePrice(newPrice);
		Product product = findById(productId);
		product.setPrice(newPrice);
		Product saved = dao.save(product);
		return saved;
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);

	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidProductIdException("Id can't be negative");
		}
	}

	void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidProductNameException("Name can't be null or empty");
		}

	}

	void validatePrice(double price) {
		if (price < 0)
			throw new InvalidPriceException("Price can't be negative");
	}

}
