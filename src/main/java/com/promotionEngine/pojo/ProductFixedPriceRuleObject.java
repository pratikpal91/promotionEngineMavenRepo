package com.promotionEngine.pojo;

import java.util.List;

public class ProductFixedPriceRuleObject extends PromotionRuleObject{

	List<ProductRAO> productRao;
	
	private Double price;

	public List<ProductRAO> getProductRao() {
		return productRao;
	}

	public void setProductRao(List<ProductRAO> productRao) {
		this.productRao = productRao;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
