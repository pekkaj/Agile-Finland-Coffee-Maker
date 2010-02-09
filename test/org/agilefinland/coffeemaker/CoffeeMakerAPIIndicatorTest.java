package org.agilefinland.coffeemaker;

import org.junit.Test;

import junit.framework.Assert;


public class CoffeeMakerAPIIndicatorTest {
	
	@Test
	public void testIndicatorOn() {
		
		CoffeeMakerAPI maker = new SysoutCoffeeMakerAPI();
		
		maker.setIndicatorState(CoffeeMakerAPI.INDICATOR_ON);
		
		Assert.assertEquals(CoffeeMakerAPI.INDICATOR_ON, maker.getIndicatorState());
	
	}
	
	public void testIndicatorOff() {
		CoffeeMakerAPI maker = new SysoutCoffeeMakerAPI();
		
		maker.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF);
		
		Assert.assertEquals(CoffeeMakerAPI.INDICATOR_OFF, maker.getIndicatorState());
	
	}

}
