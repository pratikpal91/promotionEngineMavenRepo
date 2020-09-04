package com.promotionEngine.promotion.impl;

import com.promotionEngine.enums.RuleType;
import com.promotionEngine.promotion.interfaces.Action;
import com.promotionEngine.promotion.interfaces.Condition;

public class Rule {
	
	private Condition condition;
	
	private Action action;	
	
	private RuleType ruleType;
	
	private String code;
	
	public Rule() {
		// TODO Auto-generated constructor stub
	}

	public Rule(String code, RuleType ruleType) {
		
		this.code = code;
		this.ruleType = ruleType;		
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public RuleType getRuleType() {
		return ruleType;
	}

	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

}
