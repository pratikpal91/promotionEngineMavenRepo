package com.promotionEngine.promotion.action;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.promotionEngine.pojo.Cart;
import com.promotionEngine.pojo.CartEntry;
import com.promotionEngine.pojo.Product;
import com.promotionEngine.pojo.ProductFixedPriceRuleObject;
import com.promotionEngine.pojo.ProductRAO;
import com.promotionEngine.promotion.interfaces.Action;
import com.promotionEngine.promotion.service.ProductService;
import com.promotionEngine.promotion.service.impl.ProductServiceImpl;

public class SingleSKUFixedPriceForQtyAction implements Action{
	
private ProductFixedPriceRuleObject productFixedPriceRuleObject;
	
	public SingleSKUFixedPriceForQtyAction(ProductFixedPriceRuleObject productFixedPriceRuleObject) {
		this.productFixedPriceRuleObject = productFixedPriceRuleObject ;
	}

	@Override
	public Cart applyAction(Cart cart) {
		
		
			List<ProductRAO> list = productFixedPriceRuleObject.getProductRao();
			ProductService productService = ProductServiceImpl.getInstance();
			Long times = calculatePromotionAppliedTimes(list,cart);
			for(ProductRAO entry : list){
				Product product = productService.getProductForCode(entry.getCode());
				if(product != null)
				{
					cart.setTotalPrice(cart.getTotalPrice() - (product.getUnitPrice()* entry.getQty() * times));	
				}
			}
			
			cart.setTotalPrice(cart.getTotalPrice()+ (productFixedPriceRuleObject.getPrice() * times));
			
		return cart;
	}
	
	
	private Long calculatePromotionAppliedTimes(List<ProductRAO> list,Cart cart)
	{
		Set<Long> set = new TreeSet<>();
	    for(ProductRAO rao : list)
	    {
	    	Long qty = getQuantityForProductEntry(cart, rao.getCode());
	    	set.add(qty/rao.getQty());
	    }
	    return set.iterator().next();
	    
		
	}
	private Long getQuantityForProductEntry(Cart cart , String productCode)
	{
         	Optional<CartEntry>  optional = cart.getEntries().stream().filter(entry -> productCode.equalsIgnoreCase(entry.getProduct().getProductCode())).findFirst();
         	if(optional.isPresent())
         	{
         		return optional.get().getQuantity();
         	}
         	return 0L;
	}
	
	public ProductFixedPriceRuleObject getProductFixedPriceRuleObject() {
		return productFixedPriceRuleObject;
	}



	public void setProductFixedPriceRuleObject(ProductFixedPriceRuleObject productFixedPriceRuleObject) {
		this.productFixedPriceRuleObject = productFixedPriceRuleObject;
	}

}
