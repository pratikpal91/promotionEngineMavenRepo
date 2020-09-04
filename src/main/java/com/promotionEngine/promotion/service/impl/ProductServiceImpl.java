package com.promotionEngine.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.promotionEngine.pojo.Product;
import com.promotionEngine.promotion.service.ProductService;

/**
 * Implementation of Product Service interface ProductServiceImpl
*/

public class ProductServiceImpl implements ProductService{
	
	private static ProductServiceImpl productServiceImpl;
	
	private ProductServiceImpl() {
	}	
	
	@Override
	public Product getProductForCode(String productCode) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("A", 50.0));
		products.add(new Product("B", 30.0));
		products.add(new Product("C", 20.0));
		products.add(new Product("D", 15.0));
		
		
		Optional<Product> optional = products.stream().filter(product -> product.getProductCode().equalsIgnoreCase(productCode)).findFirst();
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
        /**
         * Creating singleton instance of ProductServiceImpl class.
        */
	public static ProductServiceImpl getInstance(){
		
		if(productServiceImpl == null)
		{
			productServiceImpl = new ProductServiceImpl();
		}
		return productServiceImpl;
	}

}
