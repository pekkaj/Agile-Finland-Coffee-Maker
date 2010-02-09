/**
 * 
 */
package org.agilefinland.coffeemaker;

/**
 * @author kivimaki
 *
 */
public interface Observer {

	void handleEvent(PollEvent event);
	
}
