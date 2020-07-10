package com.coffeemachine.inventory;

import java.util.HashMap;
import java.util.Map;

import com.coffeemachine.customExceptions.CoffeeMachineException;
import com.coffeemachine.util.Constants;

/**
 * This class manages our inventory.
 * 
 * @see "getIngredients": Caters requests for getting ingredients for any recipe.
 * @see "replenishIngredient": Replenishes/adds the ingredients to our inventory
 *      with the given amount.
 * @see "checkAllIngredients": Checks the avialability of our inventory
 *      ingredients according to one request. All the functions are synchronized
 *      since they access the ingredients.
 */
public class InventoryManager {

	private Map<String, Integer> ingredients = new HashMap<String, Integer>();

	// single thread safe instantiation of shared inventory
	private static class LazyHolder {
		static final InventoryManager INSTANCE = new InventoryManager();
	}

	private InventoryManager() {
		ingredients.put(Constants.HOT_MILK, 500);
		ingredients.put(Constants.HOT_WATER, 500);
		ingredients.put(Constants.GINGER_SYRUP, 100);
		ingredients.put(Constants.SUGAR_SYRUP, 100);
		ingredients.put(Constants.TEA_LEAVES_SYRUP, 100);
	}

	public static InventoryManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	synchronized public void getIngredients(Map<String, Integer> recipe) throws CoffeeMachineException {
		checkIngredientsRunningLow(recipe);
		//if all the ingredients are available then only proceed with the request.
		for (Map.Entry<String, Integer> requirement : recipe.entrySet()) {
			ingredients.put(requirement.getKey(), ingredients.get(requirement.getKey()) - requirement.getValue());
		}
		
	}

	synchronized public void checkIngredientsRunningLow(Map<String, Integer> recipe) throws CoffeeMachineException {
		for (Map.Entry<String, Integer> requirement : recipe.entrySet()) {
			if (ingredients.get(requirement.getKey()) == null) {
				throw new CoffeeMachineException(requirement.getKey() + " is not available.");
			}
			if (ingredients.get(requirement.getKey()) < requirement.getValue()) {
				throw new CoffeeMachineException(requirement.getKey() + " is not sufficient.");
			}
		}
	}
	
	synchronized public void replenishIngredient(String name, int amount) {
		ingredients.put(name, ingredients.getOrDefault(name, 0) + amount);
	}
}
