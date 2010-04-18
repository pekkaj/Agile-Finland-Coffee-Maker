package org.agilefinland.coffeemaker;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * An acceptance test cases suite. Allows us to combine all 
 * the test cases required for our acceptance tests in
 * one place
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CoffeeMakerObserverTest.class
	//,AcceptanceTests.class
})
public class AcceptanceTests {

	CoffeeMakerAPI coffeeMaker = null;
	
	@Before
	void setup() {
		coffeeMaker = EasyMock.createMock(CoffeeMakerAPI.class);
	}
	
	@After
	void tearDown() {
		coffeeMaker = null;
	}
	
	// The Indicator light should be ON when the Brew Button 
	// is pressed
	@Test
	public void testIndicatorIsOnWhenBrewButtonPressed() {
		
		coffeeMaker.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF); 
		coffeeMaker.setBoilerState(CoffeeMakerAPI.BOILER_ON);
		coffeeMaker.setReliefValveState(EasyMock.anyInt());
		
		EasyMock.replay(coffeeMaker);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMaker);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);
		
		EasyMock.verify(coffeeMaker);
		
		// The Acceptance test
		Assert.assertEquals(CoffeeMakerAPI.INDICATOR_ON, coffeeMaker.getIndicatorState());
	}
	
	// Brew button is pressed, heating element of the boiler is turned on
	@Test
	public void testHeaterIsOnWhenBrewButtonIsPressed(){

		coffeeMaker.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF); 
		coffeeMaker.setBoilerState(CoffeeMakerAPI.BOILER_ON);
		coffeeMaker.setReliefValveState(EasyMock.anyInt());
		
		EasyMock.replay(coffeeMaker);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMaker);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);
		
		EasyMock.verify(coffeeMaker);
		
		// The Acceptance test
		Assert.assertEquals(CoffeeMakerAPI.BOILER_ON, coffeeMaker.getBoilerStatus());
	}
	
	// Brew button is pressed, pressure-relief valve is closed
	@Test
	public void testPressureValveIsOffWhenBrewButtonPressed(){

		coffeeMaker.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF); 
		coffeeMaker.setBoilerState(CoffeeMakerAPI.BOILER_ON);
		coffeeMaker.setReliefValveState(EasyMock.anyInt());
		
		EasyMock.replay(coffeeMaker);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMaker);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);
		
		EasyMock.verify(coffeeMaker);
		
		// The Acceptance test
		//Assert.assertEquals(CoffeeMakerAPI.VALVE_CLOSED, coffeeMaker.getBoilerState());
	}
	
	// Boiler is empty, heating element is switched off
	public void testHeaterIsOffWhenBrewButtonPressed(){

		coffeeMaker.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF); 
		coffeeMaker.setBoilerState(CoffeeMakerAPI.BOILER_ON);
		coffeeMaker.setReliefValveState(EasyMock.anyInt());
		
		EasyMock.replay(coffeeMaker);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMaker);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);
		
		EasyMock.verify(coffeeMaker);
		
		// The Acceptance test
		Assert.assertEquals(CoffeeMakerAPI.BOILER_ON, coffeeMaker.getBoilerStatus());
	}
	
	
	// Boiler is empty, indicator light is turned on. 
	// First TEST case is violated
	// Indicator light should be off otherwise
	public void testIndicatorIsOnWhenBoilerIsEmpty(){

		coffeeMaker.setIndicatorState(CoffeeMakerAPI.INDICATOR_OFF); 
		coffeeMaker.setBoilerState(CoffeeMakerAPI.BOILER_ON);
		coffeeMaker.setReliefValveState(EasyMock.anyInt());
		
		EasyMock.replay(coffeeMaker);
		
		CoffeeMakerObserver observer = new CoffeeMakerObserver(coffeeMaker);
		observer.handleEvent(PollEvent.BUTTON_PRESSED);
		
		EasyMock.verify(coffeeMaker);
		
		// The Acceptance test
		//Assert.assertEquals(CoffeeMakerAPI.BOILER_ON, coffeeMaker.getBoilerStatus());
	}
	
	// Other stories to continue here ...
	
}
