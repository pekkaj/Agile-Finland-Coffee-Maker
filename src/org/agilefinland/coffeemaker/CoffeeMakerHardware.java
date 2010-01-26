package org.agilefinland.coffeemaker;

public interface CoffeeMakerHardware {

	public void setIndicatorState(int indicat—rState) ;
	public int getIndicatorState();
			
	public static final int INDICATOR_ON = 0;
	public static final int INDICATOR_OFF = 1;
	
}
