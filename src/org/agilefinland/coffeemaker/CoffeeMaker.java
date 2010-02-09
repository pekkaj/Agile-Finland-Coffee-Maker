/**
 * 
 */
package org.agilefinland.coffeemaker;

/**
 * @author kivimaki
 *
 */
public class CoffeeMaker {
	
	private CoffeeMakerAPI hardware;
	
	private Observer observer;
	
	public static void main(String[] args) {
		
	}

	public void startPolling() {
		int counter = 0;
		
		while(counter < 5) {
			counter++;
			handleStatus();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	void handleStatus() {
		
		if (hardware.getBrewButtonStatus() == CoffeeMakerAPI.BREW_BUTTON_PUSHED) {
			observer.handleEvent(PollEvent.BUTTON_PRESSED);
			hardware.setIndicatorState(CoffeeMakerAPI.INDICATOR_ON);
		}	
	}
	
	public void registerObserver(Observer observer) {
		this.observer = observer;
	}
	
	public void setHardware(CoffeeMakerAPI hardware) {
		this.hardware = hardware;
	}
}
