package org.agilefinland.coffeemaker;

public interface CoffeeMakerAPI {

	public void setIndicatorState(int indicatorState) ;
	public int getIndicatorState();
			
	public static final int INDICATOR_ON = 0;
	public static final int INDICATOR_OFF = 1;
	
}
