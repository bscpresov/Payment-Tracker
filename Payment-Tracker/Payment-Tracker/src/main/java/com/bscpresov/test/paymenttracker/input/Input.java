package com.bscpresov.test.paymenttracker.input;

import java.util.Map;

import com.bscpresov.test.paymenttracker.model.Payment;

/**
 * Output interface
 * 
 * @author Name
 */
public interface Input
{
	static final String QUIT_STRING = "quit";

	/**
	 * Gets payments
	 * 
	 * @return payments {@link Map} of created payments
	 */
	public void getPayments();

	/**
	 * Loads initial payments
	 * 
	 * @param pathToInitialPayments
	 */
	public void initialLoad(String pathToInitialPayments);

	/**
	 * Gets payments
	 * 
	 * @return payments {@link Map} of created payments
	 */
	public Map<String, Payment> getCurrentPayments();
}