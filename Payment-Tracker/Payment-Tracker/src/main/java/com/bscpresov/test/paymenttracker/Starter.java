package com.bscpresov.test.paymenttracker;

import com.bscpresov.test.paymenttracker.input.impl.ConsoleInput;
import com.bscpresov.test.paymenttracker.output.impl.ConsoleOutput;

/**
 * Start point
 * 
 * @author Name
 */
public class Starter
{
	/**
	 * Main
	 * 
	 * @param args main arguments
	 */
	public static void main(String[] args)
	{
		PaymentTracker paymentTracker = new PaymentTracker();

		// Set controllers
		paymentTracker.setInputController(new ConsoleInput());
		paymentTracker.setOutputController(new ConsoleOutput());

		// Start
		paymentTracker.start(args);
	}
}