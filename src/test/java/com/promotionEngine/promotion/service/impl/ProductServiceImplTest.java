package com.promotionEngine.promotion.service.impl;


import org.junit.Assert;
import org.junit.Test;

import com.promotionEngine.pojo.Product;

public class ProductServiceImplTest {
	
	private  ProductServiceImpl productService = ProductServiceImpl.getInstance();
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    
	@Test
    public void testGetProductForCodeA() {
	
    	Product productA = productService.getProductForCode(A);
    	Assert.assertEquals(productA.getProductCode(), A);
    	Assert.assertEquals(productA.getUnitPrice().doubleValue(), 50.0, 0.001);   	
    }
	
	@Test
    public void testGetProductForCodeB() {
	
    	Product productB = productService.getProductForCode(B);
    	Assert.assertEquals(productB.getProductCode(), B);
    	Assert.assertEquals(productB.getUnitPrice().doubleValue(), 30.0,0.001);   	
    }
	
	@Test
    public void testGetProductForCodeC() {
	
    	Product productC = productService.getProductForCode(C);
    	Assert.assertEquals(productC.getProductCode(), C);
    	Assert.assertEquals(productC.getUnitPrice().doubleValue(), 20.0, 0.001);   	
    }
	
	@Test
    public void testGetProductForCodeD() {
	
    	Product productD = productService.getProductForCode(D);
    	Assert.assertEquals(productD.getProductCode(), D);
    	Assert.assertEquals(productD.getUnitPrice().doubleValue(), 15.0, 0.001);   	
    }
	

}
