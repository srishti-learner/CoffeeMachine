package com.coffeemachine.factory;

import com.coffeemachine.inventory.InventoryManager;
import com.coffeemachine.util.Constants;

public class CoffeeBeverage extends Beverage {
	
	CoffeeBeverage(){
		super(Constants.HOT_COFFEE, InventoryManager.getInstance());
	}
	
	@Override
	protected void setRecipe() {
		recipe.put(Constants.HOT_MILK, 400);
		recipe.put(Constants.GINGER_SYRUP, 30);
		recipe.put(Constants.TEA_LEAVES_SYRUP, 30);
	}

}
