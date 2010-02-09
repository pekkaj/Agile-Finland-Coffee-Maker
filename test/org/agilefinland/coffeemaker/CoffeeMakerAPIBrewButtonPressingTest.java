package org.agilefinland.coffeemaker;

import junit.framework.Assert;

import org.junit.Test;

public class CoffeeMakerAPIBrewButtonPressingTest {

	@Test
	public void testButtonPressing() {

		SysoutCoffeeMakerAPI maker = new SysoutCoffeeMakerAPI();

		Assert.assertEquals(CoffeeMakerAPI.BREW_BUTTON_NOT_PUSHED, maker
				.getBrewButtonStatus());

		maker.pressButton();

		// TODO:
		Assert.assertEquals(CoffeeMakerAPI.BREW_BUTTON_PUSHED, maker
				.getBrewButtonStatus());

	}

}
