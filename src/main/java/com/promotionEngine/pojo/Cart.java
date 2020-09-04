package com.promotionEngine.pojo;

import java.util.List;

import com.promotionEngine.promotion.impl.PromotionResult;

public class Cart {
	
	private List<CartEntry> entries;
	
	private Double totalPrice;
	
	private List<PromotionResult> promotionResults;

	public List<CartEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<CartEntry> entries) {
		this.entries = entries;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<PromotionResult> getPromotionResults() {
		return promotionResults;
	}

	public void setPromotionResults(List<PromotionResult> promotionResults) {
		this.promotionResults = promotionResults;
	}
	

}
