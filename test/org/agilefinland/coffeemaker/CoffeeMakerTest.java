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

		TestObserver obs1 = new TestObserver();
		coffeeMaker.registerObserver(obs1);
		coffeeMaker.handleStatus();
		Assert.assertTrue(obs1.isCalled());
	}
	
	@Test
	public void testIndicatorOnWhenButtonIsPressed(){
		CoffeeMaker maker = new CoffeeMaker();
		SysoutCoffeeMakerAPI makerAPI = new SysoutCoffeeMakerAPI();
		maker.setHardware(makerAPI);
		Observer obs1 = new CoffeeMakerObserver(makerAPI);  

		maker.registerObserver(obs1);
		makerAPI.pressButton();
		maker.handleStatus();
		
		Assert.assertEquals(CoffeeMakerAPI.INDICATOR_ON, makerAPI.getIndicatorState());
	}


	@Test
	public void testPollNoEvent() {
		SysoutCoffeeMakerAPI hardware = new SysoutCoffeeMakerAPI();
		hardware.indicatorState = CoffeeMakerAPI.INDICATOR_ON;
		
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		coffeeMaker.setHardware(hardware);

		TestObserver obs1 = new TestObserver();

		coffeeMaker.registerObserver(obs1);
		coffeeMaker.handleStatus();
		Assert.assertFalse(obs1.isCalled());
	}
	

	@Test
	public void testPollingThread() throws InterruptedException {
		
		SysoutCoffeeMakerAPI hardware = new SysoutCoffeeMakerAPI();
		hardware.brewButtonStatus = CoffeeMakerAPI.BREW_BUTTON_PUSHED;
		
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		coffeeMaker.setHardware(hardware);

		TestObserver obs1 = new TestObserver();
		coffeeMaker.registerObserver(obs1);

		Thread thread = new Thread(coffeeMaker);
		thread.start();
		Thread.sleep(100);
		coffeeMaker.stopPolling();
		Assert.assertTrue(obs1.isCalled());
	}
	
	private static class TestObserver implements Observer {
		private boolean called = false;
		
		@Override
		public void handleEvent(PollEvent event) {
			Assert.assertEquals(PollEvent.BUTTON_PRESSED, event);
			called = true;
		}
		
		public boolean isCalled() {
			return called;
		}
	}
}
