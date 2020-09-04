package com.promotionEngine.promotion.impl;

import java.util.List;

public class Promotion {
	
	private List<Rule> rules;
	
	private boolean active;
	
	private String name;
	
	public Promotion() {
	}
	
	public Promotion(List<Rule> rules, boolean active, String name) {
		
		this.rules = rules;
		this.active = active;
		this.name = name;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
