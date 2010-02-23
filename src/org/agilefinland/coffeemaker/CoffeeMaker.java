/**
 * 
 */
package org.agilefinland.coffeemaker;

/**
 * @author kivimaki
 *
 */
public class CoffeeMaker implements Runnable {
	
	private volatile boolean running = true;
	
	private CoffeeMakerAPI hardware;
	
	private Observer observer;
	
	public static void main(String[] args) {
		
	}
	
	@Override
	public void run() {

		while(running) {
			handleStatus();
		}
	}

	void handleStatus() {
		
		if (hardware.getBrewButtonStatus() == CoffeeMakerAPI.BREW_BUTTON_PUSHED) {
			observer.handleEvent(PollEvent.BUTTON_PRESSED);
		}	
	}
	
	public void registerObserver(Observer observer) {
		this.observer = observer;
	}
	
	public void setHardware(CoffeeMakerAPI hardware) {
		this.hardware = hardware;
	}
	
	public void stopPolling() {
		running = false;
	} 
}
