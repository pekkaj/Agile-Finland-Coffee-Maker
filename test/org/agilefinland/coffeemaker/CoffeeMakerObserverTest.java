package org.agilefinland.coffeemaker;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.hamcrest.core.AnyOf;
import org.junit.Test;

public class CoffeeMakerObserverTest {

	@Test
	public void testSetReliefValveOn() {
		CoffeeMakerAPI hwMock = EasyMock.createMock(CoffeeMakerAPI.class);

		hwMock.setIndicatorState(EasyMock.anyInt());
		hwMock.setBoilerState(EasyMock.anyInt());
		hwMock.setReliefValveState(EasyMock.eq(CoffeeMakerAPI.VALVE_CLOSED));
		
		EasyMock.replay(hwMock);

		CoffeeMakerObserver observer = new CoffeeMakerObserver(hwMock);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);

		EasyMock.verify(hwMock);
	}

	@Test
	public void testSetBoilerOn() {
		CoffeeMakerAPI hwMock = EasyMock.createMock(CoffeeMakerAPI.class);

		hwMock.setIndicatorState( EasyMock.anyInt());
		hwMock.setBoilerState(EasyMock.eq(CoffeeMakerAPI.BOILER_ON));
		hwMock.setReliefValveState(EasyMock.anyInt());
		
		EasyMock.replay(hwMock);

		CoffeeMakerObserver observer = new CoffeeMakerObserver(hwMock);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);

		EasyMock.verify(hwMock);
	}
	
	@Test
	public void testSettingOnTheIndicatorWhenBrewButtonIsPressed(){
		CoffeeMakerAPI coffeeMakerAPI = new SysoutCoffeeMakerAPI();
		Observer makerObserver = new CoffeeMakerObserver(coffeeMakerAPI);
		makerObserver.handleEvent(PollEvent.BUTTON_PRESSED);
		Assert.assertEquals(coffeeMakerAPI.getIndicatorState(), CoffeeMakerAPI.INDICATOR_ON);
	}
}
