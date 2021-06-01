package com.cg.apps.productms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.apps.productms.entities.Product;
import com.cg.apps.productms.service.IProductService;

@Controller
public class ProductControllers {
	@Autowired
	private IProductService service;

	@GetMapping("/fetchinfo")
	public ModelAndView fetchProduct(@RequestParam("productid") int id) {
		Product product = service.findById(id);
		ModelAndView response = new ModelAndView("productinfo", "product", product);
		return response;
	}

	@GetMapping("/productdetails")
	public ModelAndView getProductInformation() {
		ModelAndView response = new ModelAndView("getinfo");
		return response;
	}

	@GetMapping("/register")
	public ModelAndView registerProduct() {
		ModelAndView response = new ModelAndView("register");
		return response;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("productname") String name,
			@RequestParam("productprice") double price) {
		Product product = service.add(name, price);
		ModelAndView response = new ModelAndView("productinfo", "product", product);
		return response;
	}

	@GetMapping("/getall")
	public ModelAndView getAllProducts() {
		List<Product> list = service.findAll();
		ModelAndView response = new ModelAndView("listproducts", "list", list);
		return response;
	}

}
