package com.cg.apps.productms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.productms.dto.CreateProductRequest;
import com.cg.apps.productms.dto.ProductDetails;
import com.cg.apps.productms.dto.UpdatePriceRequest;
import com.cg.apps.productms.entities.Product;
import com.cg.apps.productms.service.IProductService;
import com.cg.apps.productms.util.ProductUtil;

@Validated
@RequestMapping("/products")
@RestController
public class ProductRestController {

	@Autowired
	private ProductUtil productUtil;

	@Autowired
	private IProductService service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public ProductDetails addProduct(@RequestBody @Valid CreateProductRequest requestData) {
		System.out.println("Inside addProduct \n name=" + requestData.getName() + " price=" + requestData.getPrice());
		Product created = service.add(requestData.getName(), requestData.getPrice());
		ProductDetails response = productUtil.toDetails(created);
		return response;
	}

	@GetMapping("/byid/{id}")
	public ProductDetails getProduct(@Min(1) @PathVariable("id") int id) {
		Product product = service.findById(id);
		ProductDetails response = productUtil.toDetails(product);
		return response;
	}

	@GetMapping
	public List<ProductDetails> allProducts() {
		List<Product> list = service.findAll();
		List<ProductDetails> response = productUtil.toDetailsList(list);
		return response;
	}

	@PutMapping("/update/price")
	public ProductDetails update(@RequestBody @Valid UpdatePriceRequest requestData) {
		Product product = service.changePrice(requestData.getId(), requestData.getPrice());
		ProductDetails response = productUtil.toDetails(product);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int productId) {

		service.deleteById(productId);

		return "Product deleted";

	}
}
