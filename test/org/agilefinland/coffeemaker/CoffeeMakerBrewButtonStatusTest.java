package org.agilefinland.coffeemaker;

import org.junit.Test;

import junit.framework.Assert;


public class CoffeeMakerBrewButtonStatusTest {
	
	@Test
	public void testIndicatorOff() {
		
		CoffeeMakerAPI maker = new SysoutCoffeeMakerAPI();
		
		Assert.assertEquals(CoffeeMakerAPI.BREW_BUTTON_NOT_PUSHED, maker.getBrewButtonStatus());
	}

}
