package com.promotionEngine.promotion.condition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.promotionEngine.enums.RuleType;
import com.promotionEngine.pojo.Cart;
import com.promotionEngine.pojo.CartEntry;
import com.promotionEngine.pojo.Product;
import com.promotionEngine.pojo.ProductFixedPriceRuleObject;
import com.promotionEngine.pojo.ProductRAO;
import com.promotionEngine.promotion.service.ProductService;
import com.promotionEngine.promotion.service.impl.ProductServiceImpl;

import junit.framework.Assert;

public class SingleSKUFixedPriceForNQtyConditionTest {
	
	SingleSKUFixedPriceForNQtyCondition condition;
	Cart cart = cartSetup();
	
	@Test
	public void validateConditionTestA(){
		
		condition = setupCondition("A");
		
		Boolean isValid = condition.validateCondition(cart);
		
		Assert.assertEquals(Boolean.TRUE, isValid);		
	}
	
	
	@Test
	public void validateConditionTestB(){
		
		condition = setupCondition("B");
		
		Boolean isValid = condition.validateCondition(cart);
		
		Assert.assertEquals(Boolean.TRUE, isValid);		
	}
	
	
	@Test
	public void validateConditionTestCD(){
		
		condition = setupCondition("CD");
		
		Boolean isValid = condition.validateCondition(cart);
		
		Assert.assertEquals(Boolean.TRUE, isValid);		
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
	
	
	

	private SingleSKUFixedPriceForNQtyCondition setupCondition(String productCode) {

		ProductFixedPriceRuleObject obj = null;
		switch (productCode) {
		case "A":
			obj = new ProductFixedPriceRuleObject();
			List<ProductRAO> aRao = new ArrayList<ProductRAO>();
			aRao.add(new ProductRAO("A", 3L));
			obj.setProductRao(aRao);
			obj.setRuleType(RuleType.SingleSKUFixedPriceForNQty);
			obj.setPrice(130.0);
			break;
		case "B" : 
			obj = new ProductFixedPriceRuleObject();
			List<ProductRAO> bRao = new ArrayList<ProductRAO>();
			bRao.add(new ProductRAO("B", 2L));
			obj.setProductRao(bRao);
			obj.setRuleType(RuleType.SingleSKUFixedPriceForNQty);
			obj.setPrice(45.0);		
            break;
		case "CD" :
			obj = new ProductFixedPriceRuleObject();
			List<ProductRAO> cdRao = new ArrayList<ProductRAO>();
			cdRao.add(new ProductRAO("C", 1L));
			cdRao.add(new ProductRAO("D", 1L));		
			obj.setProductRao(cdRao);
			obj.setRuleType(RuleType.MultipleSKUFixedPrice);
			obj.setPrice(30.0);
			break;
		default:
			break;
		}
		
		return new SingleSKUFixedPriceForNQtyCondition(obj);		
	}
	
	
	
	
	

}
