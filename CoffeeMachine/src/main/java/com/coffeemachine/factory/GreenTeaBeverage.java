package com.coffeemachine.factory;

import com.coffeemachine.inventory.InventoryManager;
import com.coffeemachine.util.Constants;

public class GreenTeaBeverage extends Beverage {

	GreenTeaBeverage() {
		super(Constants.GREEN_TEA, InventoryManager.getInstance());
	}

	@Override
	protected void setRecipe() {   
		recipe.put(Constants.GINGER_SYRUP, 30);
		recipe.put(Constants.GREEN_MIXTURE, 30);
	}

}
