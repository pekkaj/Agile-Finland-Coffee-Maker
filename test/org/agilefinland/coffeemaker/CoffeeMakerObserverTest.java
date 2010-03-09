package org.agilefinland.coffeemaker;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.hamcrest.core.AnyOf;
import org.junit.Test;

public class CoffeeMakerObserverTest {

	@Test
	public void testSetReliefValveOn() {
		CoffeeMakerAPI hwMock = EasyMock.createMock(CoffeeMakerAPI.class);

		// EasyMock.expect(hwMock.set)

		CoffeeMakerObserver observer = new CoffeeMakerObserver(hwMock);

		// FIXME ...
	}

	@Test
	public void testSetBoilerOn() {
		CoffeeMakerAPI hwMock = EasyMock.createMock(CoffeeMakerAPI.class);

		hwMock.setIndicatorState( EasyMock.anyInt());
		hwMock.setBoilerState(EasyMock.eq(CoffeeMakerAPI.BOILER_ON));

		EasyMock.replay(hwMock);

		CoffeeMakerObserver observer = new CoffeeMakerObserver(hwMock);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);

		EasyMock.verify(hwMock);
	}
	
	@Test
	public void testSettingOnTheIndicatorWhenBoilerIsEmpty(){
		CoffeeMakerAPI coffeeMakerMock = EasyMock.createMock(CoffeeMakerAPI.class);
		
		coffeeMakerMock.setIndicatorState(CoffeeMakerAPI.INDICATOR_ON); 
		
		EasyMock.replay(coffeeMakerMock);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMakerMock);
		observer.handleEvent(PollEvent.BOILER_EMPTY);

		EasyMock.verify(coffeeMakerMock);
		
	}
	@Test
	public void testSettingOffTheIndicatorWhenBrewButtonIsPressed(){
		CoffeeMakerAPI coffeeMakerMock = EasyMock.createMock(CoffeeMakerAPI.class);
		
		coffeeMakerMock.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF); 
		
		EasyMock.replay(coffeeMakerMock);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMakerMock);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);

		EasyMock.verify(coffeeMakerMock);
		
	}
}
