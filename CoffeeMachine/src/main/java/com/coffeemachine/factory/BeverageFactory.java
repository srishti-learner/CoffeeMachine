package com.coffeemachine.factory;

import com.coffeemachine.customExceptions.CoffeeMachineException;
import com.coffeemachine.util.Constants;

/**
 * This class helps in creation of specific beverage objects and calling
 * functions on them to make and serve beverage. It runs as a thread since we
 * need N number of outlets running in parallel for making different beverages.
 * 
 * @see :makeBeverage": Creates object of specific beverage type and call the
 *      required functions on it.
 * @see: "serveDrink": Serves the drink.
 */

public class BeverageFactory extends BaseBeverageFactory implements Runnable {

	public BeverageFactory(String name) {
		super(name);
	}

	@Override
	public Beverage makeBeverage() throws CoffeeMachineException {
		Beverage beverage;
		switch (beverageName) {
		case Constants.HOT_TEA:
			beverage = new TeaBeverage();
			break;
		case Constants.HOT_COFFEE:
			beverage = new CoffeeBeverage();
			break;
		case Constants.BLACK_TEA:
			beverage = new BlackTeaBeverage();
			break;
		case Constants.GREEN_TEA:
			beverage = new GreenTeaBeverage();
			break;
		default:
			throw new IllegalArgumentException("No such option available.");
		}
		beverage.addIngredients();
		return beverage;
	}

	@Override
	public void run() {
		// System.out.println("Order received for " + getName() + ".");
		try {
			makeBeverage();
		} catch (CoffeeMachineException e) {
			System.out.println(getName() + " cannot be prepared because " + e.getMessage()); // should log the
																								// exception
			return;
		}
		serveDrink();
	}

	public void serveDrink() {
		System.out.println(getName() + " is prepared.");
		// can track and print outlet number too. Not integrated as per given format.

	}

}
