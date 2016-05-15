package com.bscpresov.test.paymenttracker;

import org.junit.Test;

/**
 * Test class for {@link PaymentTracker} class
 * 
 * @author Name
 */
public class TestPaymentTracker
{
	/**
	 * Test to make sure controllers are set
	 */
	@Test
	public void testControllerNotSet()
	{
		try
		{
			new PaymentTracker().start(new String[] { "", "" });
		}
		catch (NullPointerException e)
		{
			// Expected
			return;
		}

		throw new IllegalArgumentException("Controllers aren't set.");
	}
}