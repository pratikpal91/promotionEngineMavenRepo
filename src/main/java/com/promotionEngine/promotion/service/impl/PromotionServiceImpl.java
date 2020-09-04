package com.promotionEngine.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.promotionEngine.enums.RuleType;
import com.promotionEngine.pojo.Cart;
import com.promotionEngine.pojo.ProductFixedPriceRuleObject;
import com.promotionEngine.pojo.ProductRAO;
import com.promotionEngine.promotion.action.SingleSKUFixedPriceForQtyAction;
import com.promotionEngine.promotion.condition.SingleSKUFixedPriceForNQtyCondition;
import com.promotionEngine.promotion.impl.Promotion;
import com.promotionEngine.promotion.impl.Rule;
import com.promotionEngine.promotion.service.PromotionService;

/**
 * Implementation of Promotion Service interface PromotionServiceImpl 
*/
public class PromotionServiceImpl implements PromotionService{

        /**
         * initializing promotions based on the given setup.
        */
	@Override
	public List<Promotion> getAllActivePromotions() {
		
		return initPromotion();
	}

        /**
         * Applying promotions on cart and evaluating rule condition and actions.
        */
	@Override
	public Cart applyPromotion(Cart cart, List<Promotion> promotions) {
		
		promotions.forEach(promotion -> {
			
			promotion.getRules().forEach(rule -> {
				
				if(rule.getCondition().validateCondition(cart))
				{
					rule.getAction().applyAction(cart);
				}
			});
		});
		return cart;
	}
	
	
	private List<Promotion> initPromotion(){
		
		Rule ruleA = new Rule("SingleSKUFixedPriceForA", RuleType.SingleSKUFixedPriceForNQty);
		ProductFixedPriceRuleObject objectA = new ProductFixedPriceRuleObject();
		List<ProductRAO> aRao = new ArrayList<ProductRAO>();
		aRao.add(new ProductRAO("A", 3L));
		objectA.setProductRao(aRao);
		objectA.setRuleType(RuleType.SingleSKUFixedPriceForNQty);
		objectA.setPrice(130.0);		
		ruleA.setCondition(new SingleSKUFixedPriceForNQtyCondition(objectA));
		ruleA.setAction(new SingleSKUFixedPriceForQtyAction(objectA));
		
		List<Rule> rulesA = new ArrayList<>();
		rulesA.add(ruleA);
		
		Rule ruleB = new Rule("SingleSKUFixedPriceForB", RuleType.SingleSKUFixedPriceForNQty);
		ProductFixedPriceRuleObject objectB = new ProductFixedPriceRuleObject();
		List<ProductRAO> bRao = new ArrayList<ProductRAO>();
		bRao.add(new ProductRAO("B", 2L));
		objectB.setProductRao(bRao);
		objectB.setRuleType(RuleType.SingleSKUFixedPriceForNQty);
		objectB.setPrice(45.0);		
		ruleB.setCondition(new SingleSKUFixedPriceForNQtyCondition(objectB));
		ruleB.setAction(new SingleSKUFixedPriceForQtyAction(objectB));
		
		List<Rule> rulesB = new ArrayList<>();
		rulesB.add(ruleB);
		
		Rule ruleCD = new Rule("SingleSKUFixedPriceForB", RuleType.MultipleSKUFixedPrice);
		ProductFixedPriceRuleObject objectCD = new ProductFixedPriceRuleObject();
		List<ProductRAO> cdRao = new ArrayList<ProductRAO>();
		cdRao.add(new ProductRAO("C", 1L));
		cdRao.add(new ProductRAO("D", 1L));		
		objectCD.setProductRao(cdRao);
		objectCD.setRuleType(RuleType.MultipleSKUFixedPrice);
		objectCD.setPrice(30.0);		
		ruleCD.setCondition(new SingleSKUFixedPriceForNQtyCondition(objectCD));
		ruleCD.setAction(new SingleSKUFixedPriceForQtyAction(objectCD));
		
		List<Rule> rulesCD = new ArrayList<>();
		rulesCD.add(ruleCD);
		
		List<Promotion> promotions = new ArrayList<>();	
		
		promotions.add(new Promotion(rulesA, Boolean.TRUE,"3 of A' s for 130"));
		promotions.add(new Promotion(rulesB, Boolean.TRUE,"2 of B's for 45"));
		promotions.add(new Promotion(rulesCD, Boolean.TRUE,"C & D for 30 "));
		
		return promotions;
	}
	
	

}
