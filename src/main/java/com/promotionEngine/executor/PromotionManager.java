package com.promotionEngine.executor;

import java.util.List;

import com.promotionEngine.pojo.Cart;
import com.promotionEngine.promotion.impl.Promotion;
import com.promotionEngine.promotion.service.PromotionService;
import com.promotionEngine.promotion.service.impl.PromotionServiceImpl;


/**
 * Promotion Manager class will handle all promotion related 
 * request and will abstract the promotion 
 * service complexity.
*/
public class PromotionManager {
	
	private static PromotionManager manager;
	
	PromotionService promotionService = new PromotionServiceImpl();
	
	private PromotionManager() {
		
	}
	
	/**
         * Making singleton instance of the PromotionManager class
        */
	public static PromotionManager getInstance(){
		
		if(manager == null){
		  manager = new PromotionManager();
		}
		return manager;
	}
	
        /**
         * this method will return all active promotion.
         * @params 
         * @return List<Promotion>
        */
	public List<Promotion> getAllActivePromotions()
	{
		return promotionService.getAllActivePromotions();
	}
	
	
        /**
         * This method will apply promotion to cart and will evaluate every rule of promotion.
         * @params Cart cart and List<Promotion> promotions
         * @return Cart
        */
	public Cart applyPromotion(Cart cart, List<Promotion> promotions)
	{
		if(promotions == null || promotions.isEmpty())
		{
			promotions = getAllActivePromotions();
		}
		return promotionService.applyPromotion(cart, promotions);
	}
	

}
