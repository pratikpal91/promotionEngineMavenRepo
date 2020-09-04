package com.promotionEngine.promotion.condition;

import java.util.List;

import com.promotionEngine.pojo.Cart;
import com.promotionEngine.pojo.CartEntry;
import com.promotionEngine.pojo.ProductFixedPriceRuleObject;
import com.promotionEngine.pojo.ProductRAO;
import com.promotionEngine.promotion.interfaces.Condition;

public class SingleSKUFixedPriceForNQtyCondition implements Condition{
	
	private ProductFixedPriceRuleObject productFixedPriceRuleObject;
	
	public SingleSKUFixedPriceForNQtyCondition(ProductFixedPriceRuleObject productFixedPriceRuleObject) {
		this.productFixedPriceRuleObject = productFixedPriceRuleObject ;
	}
	

	@Override
	public boolean validateCondition(Cart cart) {
		int entryFound = 0;
		int listSize = 0;
			List<ProductRAO> list = productFixedPriceRuleObject.getProductRao();	
			listSize = list.size();
			for(ProductRAO rao : list)
			{
				for(CartEntry entry : cart.getEntries())
				{
					if(rao.getCode().equalsIgnoreCase(entry.getProduct().getProductCode()) && rao.getQty() <= entry.getQuantity())
					{
						entryFound++;
					}
				}
			}
		return entryFound == listSize;
	}



	public ProductFixedPriceRuleObject getProductFixedPriceRuleObject() {
		return productFixedPriceRuleObject;
	}



	public void setProductFixedPriceRuleObject(ProductFixedPriceRuleObject productFixedPriceRuleObject) {
		this.productFixedPriceRuleObject = productFixedPriceRuleObject;
	}

	

}
