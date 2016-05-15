package com.bscpresov.test.paymenttracker.input;

import com.bscpresov.test.paymenttracker.input.impl.ConsoleInput;

import junit.framework.TestCase;

/**
 * Test class for Input methods
 * 
 * @author Name
 */
public class TestInput extends TestCase
{
	/**
	 * Test initial input
	 */
	public void testInitialInput()
	{
		final ConsoleInput consoleInput = new ConsoleInput();
		consoleInput.initialLoad(getClass().getClassLoader().getResource("correct.txt").getPath());

		// System.err.println(consoleInput.getCurrentPayments().size());
		assertEquals(2, consoleInput.getCurrentPayments().size());
	}

	/**
	 * Test initial input
	 */
	public void testIncorrectInitialInput()
	{
		final ConsoleInput consoleInput = new ConsoleInput();
		consoleInput.initialLoad(getClass().getClassLoader().getResource("incorrect.txt").getPath());

		assertEquals(0, consoleInput.getCurrentPayments().size());
	}
}