package com.promotionEngine.promotion.interfaces;

import com.promotionEngine.pojo.Cart;

public interface Condition {
	
	public boolean validateCondition(Cart cart);
}
