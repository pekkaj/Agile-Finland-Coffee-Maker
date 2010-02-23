package org.agilefinland.coffeemaker;

import junit.framework.Assert;

import org.junit.Test;

public class CoffeeMakerObserverTest {

	@Test
	public void testSettingOnTheIndicatorWhenBrewButtonIsPressed(){
		
		CoffeeMakerAPI coffeeMakerAPI = new SysoutCoffeeMakerAPI();
		Observer makerObserver = new CoffeeMakerObserver(coffeeMakerAPI);
		makerObserver.handleEvent(PollEvent.BUTTON_PRESSED);
		Assert.assertEquals(coffeeMakerAPI.getIndicatorState(), CoffeeMakerAPI.INDICATOR_ON);
		
	}
	
}
