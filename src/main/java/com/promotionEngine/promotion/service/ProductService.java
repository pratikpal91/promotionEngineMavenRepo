package com.promotionEngine.promotion.service;

import com.promotionEngine.pojo.Product;

public interface ProductService {
	/**
	 * This method will fetch product instance for product code
	 * @param  productCode
	 * @return Product
	 */
	public Product getProductForCode(String productCode);
	
}
