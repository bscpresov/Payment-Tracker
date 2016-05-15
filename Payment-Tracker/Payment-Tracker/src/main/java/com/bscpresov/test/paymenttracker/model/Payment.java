package com.bscpresov.test.paymenttracker.model;

/**
 * Payment holder
 * Object consist of just two fields:
 * Currency in 3 letters format
 * Value as integer
 * 
 * @author Name
 */
public class Payment
{
	private String currency;
	private Integer amount;

	/**
	 * Constructor using fields
	 * 
	 * @param currency as three letters abbreviation
	 * @param amount {@link Integer} of amount
	 */
	public Payment(String currency, Integer amount)
	{
		super();
		this.currency = currency;
		this.amount = amount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency()
	{
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount()
	{
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}
}