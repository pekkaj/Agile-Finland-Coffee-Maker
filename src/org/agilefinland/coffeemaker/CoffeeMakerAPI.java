package org.agilefinland.coffeemaker;

public interface CoffeeMakerAPI {

	public int getBrewButtonStatus();
	
	public static final int BREW_BUTTON_PUSHED = 0;
	public static final int BREW_BUTTON_NOT_PUSHED = 1;
		
	public void setIndicatorState(int indicatorState);
	public int getIndicatorState();
			
	public static final int INDICATOR_ON = 0;
	public static final int INDICATOR_OFF = 1;
	
}
