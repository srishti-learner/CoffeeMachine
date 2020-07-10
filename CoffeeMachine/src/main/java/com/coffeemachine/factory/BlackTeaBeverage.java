package com.coffeemachine.factory;

import com.coffeemachine.inventory.InventoryManager;
import com.coffeemachine.util.Constants;

public class BlackTeaBeverage extends Beverage{

	BlackTeaBeverage() {
		super(Constants.BLACK_TEA, InventoryManager.getInstance());
	}
	
	@Override
	protected void setRecipe() {
		recipe.put(Constants.HOT_WATER, 300);   
		recipe.put(Constants.GINGER_SYRUP, 30);
		recipe.put(Constants.TEA_LEAVES_SYRUP, 30);
	}
}
