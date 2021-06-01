package com.cg.apps.productms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.apps.productms.dto.ProductDetails;
import com.cg.apps.productms.entities.Product;

@Component
public class ProductUtil {
	public ProductDetails toDetails(Product product) {
		ProductDetails details = new ProductDetails();
		details.setId(product.getId());
		details.setName(product.getName());
		details.setPrice(product.getPrice());
		return details;
	}

	public List<ProductDetails> toDetailsList(Collection<Product> products) {

		List<ProductDetails> desired = new ArrayList<>();
		for (Product prd : products) {
			ProductDetails details = toDetails(prd);
			desired.add(details);
		}
		return desired;
	}

}
