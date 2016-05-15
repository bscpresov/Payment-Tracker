package com.bscpresov.test.paymenttracker.input.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import com.bscpresov.test.paymenttracker.input.Input;
import com.bscpresov.test.paymenttracker.model.Payment;
import com.bscpresov.test.paymenttracker.util.Constants;

/**
 * Implements output - write to console
 * 
 * @author Name
 */
public class ConsoleInput implements Input
{
	private Map<String, Payment> payments = new ConcurrentHashMap<String, Payment>();

	/**
	 * Reads inputs
	 */
	@Override
	public void getPayments()
	{
		Scanner reader = new Scanner(System.in);

		String input = "";
		for (;;)
		{
			// Optional output System.out.println("Enter next input.");

			input = reader.nextLine();

			if (QUIT_STRING.equalsIgnoreCase(input))
			{
				break;
			}

			parseLine(input, -1);
		}

		reader.close();
	}

	/**
	 * Parse corresponding line
	 * 
	 * @param line provided input
	 * @param lineNumber specify a line # of initial file; if -1 is set it means input came form user
	 */
	private void parseLine(String line, int lineNumber)
	{
		String[] split = line.split(Constants.CURRENCY_VALUE_SPLITTER);
		if (split.length != 2)
		{
			System.err.println(((lineNumber == -1) ? "Set line " : "The line number " + lineNumber) + " is not in proper format. Expecting just one space ' '.");
		}
		int setAmount;
		try
		{
			setAmount = Integer.parseInt(split[1]);
		}
		catch (Exception e)
		{
			System.err.println("Amount is not in correct format. Expecting number as Integer.");

			return;
		}

		String currency = split[0];
		if (currency.length() != 3)
		{
			System.err.println("Currency is not in correct format. Expecting 3 letters.");

			return;
		}

		currency = currency.toUpperCase();

		Payment payment = payments.get(currency);
		if (payment == null)
		{
			payments.put(currency, new Payment(currency, setAmount));
		}
		else
		{
			payments.put(currency, new Payment(currency, payment.getAmount() + setAmount));
		}

		// Optional output System.out.println("Taken by system: " + line);
	}

	/**
	 * Loads the file as a start point of payment tracker
	 * 
	 * @param fileName - name of the file given from user
	 */
	@Override
	public void initialLoad(String fileName)
	{
		BufferedReader bufferedReader = null;
		try
		{
			bufferedReader = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Specified file were not found.");
			return;
		}

		String line = null;
		int lineNumber = 1;
		try
		{
			while ((line = bufferedReader.readLine()) != null)
			{
				lineNumber++ ;

				parseLine(line.trim(), lineNumber);
			}
		}
		catch (IOException e)
		{
			System.err.println("Couldn't read a line " + lineNumber + ".");
		}

		try
		{
			bufferedReader.close();
		}
		catch (IOException e)
		{
			System.err.println("Buffer wasn't closed properly.");
		}
	}

	/**
	 * Return current payments
	 * 
	 * @return payments {@link Map} of current payments
	 */
	@Override
	public Map<String, Payment> getCurrentPayments()
	{
		return payments;
	}
}