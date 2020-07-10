/**
 * @author Srishti
 *
 */
package com.coffeemachine.machine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.coffeemachine.factory.BeverageFactory;
import com.coffeemachine.inventory.InventoryManager;
import com.coffeemachine.util.Constants;

/**
 * Class with a pool of threads which can run in parallel. It delegates the
 * request to our factory or inventory.
 * 
 * @see "makeOrder": Every new request picks one free thread from the pool and
 *      assigns the request to it. The "factoryPool" has a fixed size (maximum
 *      number of "OUTLETS" in the machine).
 * @see "replenishInventory": Helps in replenishing the inventory's ingredients.
 */

public class RequestProcessor {

	private static RequestProcessor instance = null;
	private ExecutorService factoryPool;

	private RequestProcessor() {
		factoryPool = Executors.newFixedThreadPool(Constants.OUTLETS); // maximum number of orders being served at once
	}

	public static RequestProcessor getInstance() {
		if (instance == null) {
			instance = new RequestProcessor();
		}
		return instance;
	}

	/**
	 * Entry point to our coffee machine. Processor takes the orders through some
	 * events and pass it to the BeverageFactory to make the drink.
	 */

	public void takeOrder(String beverage) {
		Runnable beverageOrder = new BeverageFactory(beverage);
		factoryPool.execute(beverageOrder);
	}

	/**
	 * Caters to requests for replenishing inventory ingredients. Adds the
	 * ingredient if it is new.
	 */
	public void replenishInventory(String beverage, int amount) {
		try {
			InventoryManager.getInstance().replenishIngredient(beverage, amount);
			System.out.println("Inventory replenished with " + beverage + " (" + amount + " ml).");
		} catch (Exception e) {
			System.out.println("Exception occured while updating the inventory.");
		}
	}

}
