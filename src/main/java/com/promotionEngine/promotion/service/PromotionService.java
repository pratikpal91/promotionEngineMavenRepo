package com.promotionEngine.promotion.service;

import java.util.List;

import com.promotionEngine.pojo.Cart;
import com.promotionEngine.promotion.impl.Promotion;

public interface PromotionService {
	
	/**
	 * This method will fetch all active promotion present in the application
	 * @param  
	 * @return List<Promotion>
	 */
	public List<Promotion> getAllActivePromotions();
	
	/**
	 * This method will apply and evaluate list of promotions for the input cart
	 * @param  Cart cart and List<Promotion> promotions
	 * @return Cart
	 */
	public Cart applyPromotion(Cart cart, List<Promotion> promotions);
	
}
