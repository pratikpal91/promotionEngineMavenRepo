package com.promotionEngine.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.promotionEngine.executor.PromotionManager;
import com.promotionEngine.pojo.Cart;
import com.promotionEngine.pojo.CartEntry;
import com.promotionEngine.pojo.Product;
import com.promotionEngine.promotion.impl.Promotion;
import com.promotionEngine.promotion.service.ProductService;
import com.promotionEngine.promotion.service.impl.ProductServiceImpl;



public class PromotionEngineExecutionDemo {
	
    public static void main(String[] args) {
		
    PromotionManager promotionManager = PromotionManager.getInstance();
    ProductService productService = ProductServiceImpl.getInstance();
	

        /** Displying all active promtion of the application to customer to choose product accordingly*/
	List<Promotion> promotions = promotionManager.getAllActivePromotions();
	
	System.out.println("Available active promotions :- " );
	
	promotions.forEach(promotion -> {		
		System.out.println(promotion.getName());
	});
	
	Scanner sc = new Scanner(System.in);
        
        /** Accepting number of items in cart (accept only number)*/

	System.out.println("Please enter the number of items you want to add in Cart (in numbers): ");
	String number = sc.nextLine();
	int cartSize;
	try {
		cartSize = Integer.parseInt(number);
	} catch (Exception e) {
		System.out.println("Not a valid number .... Please enter a valid number of items you want to add in Cart : ");
		number = sc.nextLine();
		cartSize = Integer.parseInt(number);	
	}

        /** Based on number of entries provided above, 
         * accepting all entries one by one with 
         * product code and quantity space separated.
         * e.g. A 3
         * B 4
        */
	
	System.out.println("Please enter product code and quantity with space separated for all entries : ");
	List<CartEntry> entries = new ArrayList<CartEntry>();
	for(int i =1 ;i<=cartSize;i++)
	{
		System.out.println("Please enter code and quantity for Entry "+i+" : ");
		String input = sc.nextLine();
		String[] arr = input.split(" ");		
		CartEntry entry = new CartEntry();
		Product product = productService.getProductForCode(arr[0]);
		entry.setProduct(product);
		Long qty = Long.parseLong(arr[1]);
		entry.setQuantity(qty);
		entry.setTotalPrice(product.getUnitPrice() * qty);	
		entries.add(entry);
	}	
	
	Cart cart = new Cart();
	cart.setEntries(entries);
	cart.setTotalPrice(entries.stream().mapToDouble(entry-> entry.getTotalPrice().doubleValue()).sum());
	
	System.out.println("Total Cart price before promotion : "+cart.getTotalPrice().doubleValue());
	
        /** Calling promotion manager to evaluate promotion if applicable on cart */
	promotionManager.applyPromotion(cart, promotions);
	
	System.out.println("Total cart Price after promotion : "+ cart.getTotalPrice().doubleValue());
	
}	

}