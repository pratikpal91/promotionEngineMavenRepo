package com.promotionEngine.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.promotionEngine.pojo.Cart;
import com.promotionEngine.pojo.CartEntry;
import com.promotionEngine.pojo.Product;
import com.promotionEngine.promotion.impl.Promotion;
import com.promotionEngine.promotion.service.ProductService;

import junit.framework.Assert;

public class PromotionServiceImplTest {
	
     PromotionServiceImpl promotionService = new PromotionServiceImpl();
     private static final String PROMOTION_A = "3 of A' s for 130";
     private static final String PROMOTION_B = "2 of B's for 45";
     private static final String PROMOTION_CD = "C & D for 30 ";
     
     
     @Test
     public void getAllActivePromotionsTest() {
 		
    	 List<Promotion> list = promotionService.getAllActivePromotions();
    	 
    	 Assert.assertEquals(list.size(), 3);
    	 Assert.assertEquals(list.get(0).getName(), PROMOTION_A);
    	 Assert.assertEquals(list.get(1).getName(), PROMOTION_B);
    	 Assert.assertEquals(list.get(2).getName(), PROMOTION_CD); 		
 	}
     
    
     @Test
     public void applyPromotionTest(){
    	 
    	Cart cart = cartSetup();
    	cart = promotionService.applyPromotion(cart, promotionService.getAllActivePromotions());
    	Assert.assertEquals(280.0, cart.getTotalPrice(), 0.001);
     }


	private Cart cartSetup() {

		List<CartEntry> entries = new ArrayList<CartEntry>();
		ProductService productService = ProductServiceImpl.getInstance();
		
		CartEntry entryA = new CartEntry();
		Product productA = productService.getProductForCode("A");
		entryA.setProduct(productA);
		Long qtyA = 3L;
		entryA.setQuantity(qtyA);
		entryA.setTotalPrice(productA.getUnitPrice() * qtyA);	
		entries.add(entryA);
		
		CartEntry entryB = new CartEntry();
		Product productB = productService.getProductForCode("B");
		entryB.setProduct(productB);
		Long qtyB = 5L;
		entryB.setQuantity(qtyB);
		entryB.setTotalPrice(productB.getUnitPrice() * qtyB);	
		entries.add(entryB);
		
		CartEntry entryC = new CartEntry();
		Product productC = productService.getProductForCode("C");
		entryC.setProduct(productC);
		Long qtyC = 1L;
		entryC.setQuantity(qtyC);
		entryC.setTotalPrice(productC.getUnitPrice() * qtyC);	
		entries.add(entryC);
		
		CartEntry entryD = new CartEntry();
		Product productD = productService.getProductForCode("D");
		entryD.setProduct(productD);
		Long qtyD = 1L;
		entryD.setQuantity(qtyD);
		entryD.setTotalPrice(productD.getUnitPrice() * qtyD);	
		entries.add(entryD);
		
		Cart cart = new Cart();
		cart.setEntries(entries);
		cart.setTotalPrice(entries.stream().mapToDouble(entry-> entry.getTotalPrice().doubleValue()).sum());
		return cart;
	}
     

}
