/**
 * 
 */
package org.agilefinland.coffeemaker;

import org.junit.Assert;
import org.junit.Test;


/**
 * Tests for {@link CoffeeMaker}.
 * 
 * @author kivimaki
 */
public class CoffeeMakerTest {

	private boolean called = false;
	
	@Test
	public void testMain() {
		CoffeeMaker.main(null);
		
	}
	
	@Test
	public void testPoll() {
		SysoutCoffeeMakerAPI hardware = new SysoutCoffeeMakerAPI();
		hardware.brewButtonStatus = CoffeeMakerAPI.BREW_BUTTON_PUSHED;
		
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		coffeeMaker.setHardware(hardware);

		called = false;
		Observer obs1 = 
		new Observer() {
			
			@Override
			public void handleEvent(PollEvent event) {
				Assert.assertEquals(PollEvent.BUTTON_PRESSED, event);
				called = true;
			}
		};

		coffeeMaker.registerObserver(obs1);
		coffeeMaker.handleStatus();
		Assert.assertTrue(called);
	}
	
	@Test
	public void testIndicatorOnWhenButtonIsPressed(){
		CoffeeMaker maker = new CoffeeMaker();
		SysoutCoffeeMakerAPI makerAPI = new SysoutCoffeeMakerAPI();
		maker.setHardware(makerAPI);
		Observer obs1 = 
			new Observer() {
				
				@Override
				public void handleEvent(PollEvent event) {
					Assert.assertEquals(PollEvent.BUTTON_PRESSED, event);
					called = true;
				}
			};

		maker.registerObserver(obs1);
		makerAPI.pressButton();
		maker.handleStatus();
		Assert.assertEquals(CoffeeMakerAPI.INDICATOR_ON, makerAPI.getIndicatorState());
	}
}
