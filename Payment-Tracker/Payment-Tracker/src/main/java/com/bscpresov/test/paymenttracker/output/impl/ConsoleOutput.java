package com.bscpresov.test.paymenttracker.output.impl;

import java.util.Map;
import java.util.Map.Entry;

import com.bscpresov.test.paymenttracker.model.Payment;
import com.bscpresov.test.paymenttracker.output.Output;
import com.bscpresov.test.paymenttracker.util.Constants;

/**
 * Implements output - write to console
 * 
 * @author Name
 */
public class ConsoleOutput implements Output
{
	/**
	 * {@inheritDoc}
	 * 
	 * Prints output to console
	 */
	@Override
	public void printPayments(Map<String, Payment> payments)
	{
		if (payments.isEmpty())
		{
			// Do not print any payments
			System.out.println();
			System.out.println("----------------- No payments -----------------------");
			System.out.println();
			return;
		}

		System.out.println();
		System.out.println();
		System.out.println("----------------- Current state of payments START -----------------------");
		for (Entry<String, Payment> payment : payments.entrySet())
		{
			Integer amount = payment.getValue().getAmount();
			if (amount != 0)
			{
				System.out.println("\t" + payment.getKey() + Constants.CURRENCY_VALUE_SPLITTER + amount);
			}
		}
		System.out.println("----------------- Current state of payments END -------------------------");
		System.out.println();
		System.out.println();
	}
}