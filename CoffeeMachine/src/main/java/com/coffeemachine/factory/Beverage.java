package com.coffeemachine.factory;

import java.util.HashMap;
import java.util.Map;

import com.coffeemachine.customExceptions.CoffeeMachineException;
import com.coffeemachine.inventory.InventoryManager;
import com.coffeemachine.util.Constants;

/**
 * Base Class for all beverages, with common attributes like name, inventory and
 * "recipe". Map "Recipe" consists of ingredients and its quantity in a drink.
 * It is initialized with common ingredients in all the beverages.
 * 
 * @see "setRecipe": abstract function to be overridden by the derived beverages
 *      for updating the "recipe" map with respective ingredients.
 * @see "addIngredients": prepares the beverage by mixing all the ingredients
 *      after getting from the inventory. (Assumption: order does not matter).
 */

public abstract class Beverage {

	private String name;
	protected InventoryManager inventory;

	Beverage(String name, InventoryManager inventory) {
		this.name = name;
		this.inventory = inventory;
		setRecipe();
	}

	//
	protected Map<String, Integer> recipe = new HashMap<String, Integer>() {
		private static final long serialVersionUID = 1L;

		{
			put(Constants.HOT_WATER, 100);
			put(Constants.SUGAR_SYRUP, 50);
		};
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addIngredients() throws CoffeeMachineException {
		inventory.getIngredients(recipe);
	}

	protected abstract void setRecipe();
}
