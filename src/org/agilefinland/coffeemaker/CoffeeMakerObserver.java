package org.agilefinland.coffeemaker;

public class CoffeeMakerObserver implements Observer {

	private final CoffeeMakerAPI hardware;
	
	public CoffeeMakerObserver(CoffeeMakerAPI hdw) {
		
		hardware = hdw;
	}
	
	@Override
	public void handleEvent(PollEvent event) {
		if(PollEvent.BUTTON_PRESSED.equals(event)) {
			hardware.setIndicatorState(CoffeeMakerAPI.INDICATOR_ON);
		}
	}

}
