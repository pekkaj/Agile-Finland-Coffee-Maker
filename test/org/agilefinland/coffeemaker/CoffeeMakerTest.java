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
	public void testPollNoEvent() {
		SysoutCoffeeMakerAPI hardware = new SysoutCoffeeMakerAPI();
		hardware.indicatorState = CoffeeMakerAPI.INDICATOR_ON;
		
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
		Assert.assertFalse(called);
	}
	
	@Test
	public void testPollingThread() throws InterruptedException {
		
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

		Thread thread = new Thread(coffeeMaker);
		thread.start();
		coffeeMaker.stopPolling();
		
		Thread.sleep(1000);
		Assert.assertTrue(called);
	}
}
