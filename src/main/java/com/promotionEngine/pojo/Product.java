package com.promotionEngine.pojo;

public class Product {
	
	private String productCode;
	
	private Double unitPrice;
	
	public Product() {
	}
	
	public Product(String productCode, Double unitPrice) {
       
		this.productCode = productCode;
		this.unitPrice = unitPrice;
	
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
