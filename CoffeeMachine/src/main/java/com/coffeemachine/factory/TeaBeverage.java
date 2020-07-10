package com.coffeemachine.factory;

import com.coffeemachine.inventory.InventoryManager;
import com.coffeemachine.util.Constants;

public class TeaBeverage extends Beverage{

protected InventoryManager inventory;
	
	TeaBeverage(){
		super(Constants.HOT_TEA, InventoryManager.getInstance());
	}
	
	@Override
	protected void setRecipe() {
		recipe.put(Constants.HOT_WATER, 200);  
		recipe.put(Constants.SUGAR_SYRUP, 10);
		recipe.put(Constants.HOT_MILK, 100);
		recipe.put(Constants.GINGER_SYRUP, 10);
		recipe.put(Constants.TEA_LEAVES_SYRUP, 30);
	}

}
