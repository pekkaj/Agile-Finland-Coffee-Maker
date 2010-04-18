package org.agilefinland.coffeemaker;

public enum PollEvent {
	
	BUTTON_PRESSED,
	
	BOILER_EMPTY,
	
	BOILER_NOT_EMPTY,
	
	/** no pot in the warmer plate */
	WARMER_EMPTY,
	
	POT_EMPTY,
	
	POT_NOT_EMPTY;
}
