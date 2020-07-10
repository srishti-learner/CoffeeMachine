package com.coffeemachine.factory;

import com.coffeemachine.customExceptions.CoffeeMachineException;

/**
 * This is the base class which lays out the job of our actual/concrete factory.
 * 
 */

public abstract class BaseBeverageFactory {

	protected String beverageName;

	public abstract Beverage makeBeverage() throws CoffeeMachineException;

	public BaseBeverageFactory(String beverageName) {
		this.beverageName = beverageName.toLowerCase(); // avoid case sensitivity to be on the safer side
	}

	protected String getName() {
		return beverageName;
	}

}
