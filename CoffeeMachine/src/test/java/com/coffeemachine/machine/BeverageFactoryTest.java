package com.coffeemachine.machine;

import org.junit.jupiter.api.Test;

import com.coffeemachine.customExceptions.CoffeeMachineException;
import com.coffeemachine.factory.BaseBeverageFactory;
import com.coffeemachine.factory.Beverage;
import com.coffeemachine.factory.BeverageFactory;
import com.coffeemachine.util.Constants;

class BeverageFactoryTest {

	@Test
	public void ShouldReturnBeverageObject() throws CoffeeMachineException {
		BaseBeverageFactory factory = new BeverageFactory(Constants.HOT_TEA);
		assert(factory.makeBeverage() instanceof Beverage);
	}
	
	@Test
	public void ShouldThrowIllegalArgumentException() {
		BaseBeverageFactory factory = new BeverageFactory("Random");
		try {
			factory.makeBeverage();
		} catch (Exception e) {
			assert(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void ShouldThrowCustomException() {
		BaseBeverageFactory factory = new BeverageFactory(Constants.GREEN_TEA);
		try {
			factory.makeBeverage();
		} catch (Exception e) {
			assert(e instanceof CoffeeMachineException);
		}
		
	}
}
