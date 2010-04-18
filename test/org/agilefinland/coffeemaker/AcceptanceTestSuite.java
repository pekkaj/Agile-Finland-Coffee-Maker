package org.agilefinland.coffeemaker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * An acceptance test cases suite. Allows us to combine all 
 * the test cases required for our acceptance tests in
 * one place
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CoffeeMakerObserverTest.class
	,AcceptanceTests.class
})
public class AcceptanceTestSuite {
	// See AcceptanceTests class for all the test cases
}
