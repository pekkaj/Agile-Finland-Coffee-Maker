package org.agilefinland.coffeemaker;

import org.junit.Test;

import junit.framework.Assert;


public class CoffeeMakerHardwareIndicatorTest {
	
	@Test
	public void testIndicatorOn() {
		
		CoffeeMakerHardware maker = new MockCoffeeMaker();
		
		maker.setIndicatorState(CoffeeMakerHardware.INDICATOR_ON);
		
		Assert.assertEquals(CoffeeMakerHardware.INDICATOR_ON, maker.getIndicatorState());
	
	}
	
	public void testIndicatorOff() {
		CoffeeMakerHardware maker = new MockCoffeeMaker();
		
		maker.setIndicatorState(CoffeeMakerHardware.INDICATOR_OFF);
		
		Assert.assertEquals(CoffeeMakerHardware.INDICATOR_OFF, maker.getIndicatorState());
	
	}

}
