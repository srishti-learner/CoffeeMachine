package com.coffeemachine.machine;

import org.junit.jupiter.api.Test;

import com.coffeemachine.util.Constants;

/**
 * Cannot "assert" this class since printing the output to console. 
 * Compare the console output against desirable output.
 */
class RequestProcessorTests {

	@Test
	void ExampleInputGiven() {
		System.out.println("---Two drinks should be served. One unavailable, other not sufficient.---");
		RequestProcessor processor = RequestProcessor.getInstance();
		processor.takeOrder(Constants.HOT_TEA);
		processor.takeOrder(Constants.HOT_COFFEE);
		processor.takeOrder(Constants.BLACK_TEA);
		processor.takeOrder(Constants.GREEN_TEA);
	}
	@Test
	public void ShouldAddNewIngredientToInventory() {
		System.out.println("---Should add green mixture(new ingredient) to the inventory.---");
		RequestProcessor processor = RequestProcessor.getInstance();
		processor.replenishInventory(Constants.GREEN_MIXTURE, 200);
		processor.takeOrder(Constants.HOT_COFFEE);
		processor.takeOrder(Constants.GREEN_TEA);
	}
	
	@Test
	public void ShouldReplenishOldIngredientInInventory() {
		System.out.println("---Should replenish milk and sugar and serve all three beverages.---");
		RequestProcessor processor = RequestProcessor.getInstance();
		processor.replenishInventory(Constants.HOT_MILK, 500);
		processor.replenishInventory(Constants.SUGAR_SYRUP, 100);
		processor.takeOrder(Constants.HOT_COFFEE);
		processor.takeOrder(Constants.BLACK_TEA);
		processor.takeOrder(Constants.HOT_COFFEE);
	}
	
	@Test
	public void BeverageCannotBeMade() {
		System.out.println("---Should print green mixture is not available.---");
		RequestProcessor processor = RequestProcessor.getInstance();
		processor.takeOrder(Constants.GREEN_TEA);
	}
	
	@Test
	public void ShouldPrepareAllBeverages() {
		System.out.println("---Should serve all(2) the beverages.---");
		RequestProcessor processor = RequestProcessor.getInstance();
		processor.takeOrder(Constants.BLACK_TEA);
		processor.takeOrder(Constants.HOT_COFFEE);
	}
}
