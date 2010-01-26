package org.agilefinland.coffeemaker;

public class MockCoffeeMaker implements CoffeeMakerHardware {

	int indicatorState = 0;
	
	@Override
	public void setIndicatorState(int state) {

		this.indicatorState = state;
		
		System.out.println("Coffee maker is " + Integer.toString(state));
	}

	@Override
	public int getIndicatorState() {

		return this.indicatorState;
	}
	
}
