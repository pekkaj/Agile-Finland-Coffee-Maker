package org.agilefinland.coffeemaker;

public class SysoutCoffeeMakerAPI implements CoffeeMakerAPI {

	int indicatorState = CoffeeMakerAPI.INDICATOR_OFF;
	int brewButtonStatus = CoffeeMakerAPI.BREW_BUTTON_NOT_PUSHED;
	int boilerState = CoffeeMakerAPI.BOILER_OFF;
	int reliefValveState = CoffeeMakerAPI.VALVE_OPEN;
	
	@Override
	public void setIndicatorState(int state) {
		this.indicatorState = state;

		System.out.println("Coffee maker is " + Integer.toString(state));
	}

	@Override
	public int getIndicatorState() {
		return this.indicatorState;
	}

	@Override
	public int getBrewButtonStatus() {
		return this.brewButtonStatus;
	}

	@Override
	public void setBoilerState(int boilerStatus) {
		System.out.println("Boiler state is " + boilerStatus);
		this.boilerState = boilerStatus;
	}
	
	public void pressButton() {
		System.out.println("Brew button was pressed.");
		this.brewButtonStatus = CoffeeMakerAPI.BREW_BUTTON_PUSHED;
	}

	@Override
	public void setReliefValveState(int reliefValveState) {
		this.reliefValveState = reliefValveState;
		System.out.println("Relief valve state is " + reliefValveState);
	}

}
