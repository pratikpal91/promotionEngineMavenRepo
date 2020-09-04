package com.promotionEngine.pojo;

public class ProductRAO {	
	
	private String code;
	
	private Long qty;
	
	public ProductRAO(String code, Long qty) {
         
		this.code = code;
		this.qty = qty;
	 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	

}
