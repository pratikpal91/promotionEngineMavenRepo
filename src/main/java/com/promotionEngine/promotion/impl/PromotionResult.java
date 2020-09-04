package com.promotionEngine.promotion.impl;

import com.promotionEngine.pojo.Product;

public class PromotionResult {
	
	private Promotion appliedPromotion;
	
	private Product appliedOn;
	
	private Double priceBeforePromotion;
	
	private Double priceAfterPromotion;

	public Promotion getAppliedPromotion() {
		return appliedPromotion;
	}

	public void setAppliedPromotion(Promotion appliedPromotion) {
		this.appliedPromotion = appliedPromotion;
	}

	public Product getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Product appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Double getPriceBeforePromotion() {
		return priceBeforePromotion;
	}

	public void setPriceBeforePromotion(Double priceBeforePromotion) {
		this.priceBeforePromotion = priceBeforePromotion;
	}

	public Double getPriceAfterPromotion() {
		return priceAfterPromotion;
	}

	public void setPriceAfterPromotion(Double priceAfterPromotion) {
		this.priceAfterPromotion = priceAfterPromotion;
	}
	
	

}
