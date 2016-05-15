package com.bscpresov.test.paymenttracker.input.impl;

import java.util.Map;

import com.bscpresov.test.paymenttracker.input.Input;
import com.bscpresov.test.paymenttracker.model.Payment;

/**
 * Implements output - write to file
 * Not implemented
 * 
 * @author Name
 */
public class FileInput implements Input
{
	/**
	 * {@inheritDoc}
	 * Not implemented
	 */
	@Override
	public void getPayments()
	{
	}

	/**
	 * {@inheritDoc}
	 * Not implemented
	 */
	@Override
	public void initialLoad(String pathToInitialPayments)
	{
	}

	/**
	 * {@inheritDoc}
	 * Not implemented
	 */
	@Override
	public Map<String, Payment> getCurrentPayments()
	{
		return null;
	}
}