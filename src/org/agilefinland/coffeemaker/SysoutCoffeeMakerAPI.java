package org.agilefinland.coffeemaker;

public class SysoutCoffeeMakerAPI implements CoffeeMakerAPI {

	int indicatorState = CoffeeMakerAPI.INDICATOR_OFF;
	int brewButtonStatus = CoffeeMakerAPI.BREW_BUTTON_NOT_PUSHED;

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

	public void pressButton() {
		this.brewButtonStatus = CoffeeMakerAPI.BREW_BUTTON_PUSHED;
	}

}
