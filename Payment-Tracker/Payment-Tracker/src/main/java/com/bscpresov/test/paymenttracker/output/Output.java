package com.bscpresov.test.paymenttracker.output;

import java.util.Map;

import com.bscpresov.test.paymenttracker.model.Payment;

/**
 * Output interface
 * 
 * @author Name
 */
public interface Output
{
	/**
	 * Prints out current state of payments
	 * 
	 * @param payments a {@link Map} of current payments
	 */
	public void printPayments(Map<String, Payment> payments);
}