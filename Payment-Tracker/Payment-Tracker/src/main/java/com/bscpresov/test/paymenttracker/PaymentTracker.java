package com.bscpresov.test.paymenttracker;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.bscpresov.test.paymenttracker.input.Input;
import com.bscpresov.test.paymenttracker.output.Output;

/**
 * Payment tracker
 * 
 * @author Name
 */
public class PaymentTracker
{
	private static final int PERIOD_TIME = 10; // FIXME Change it to be 60sec to be 1m

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private Input inputController;
	private Output outputController;

	/**
	 * Main entry of payment tracker
	 * 
	 * Loads initial file if provided
	 * Initialize schedule runner
	 * Executes main runner
	 * After main runner is finished - final printing of payments is call
	 * 
	 * @param args an array of {@link String}
	 */
	public void start(String[] args)
	{
		if (args != null && args.length > 0)
		{
			if (args.length > 1)
			{
				System.err.println("Program started with more then one param - taken just the first one as initial input file.");
			}

			inputController.initialLoad(args[0]);
		}

		initializeRunner();

		inputController.getPayments();

		// Final printing of payments
		outputController.printPayments(inputController.getCurrentPayments());

		System.exit(0);
	}

	/**
	 * Initialize runner
	 */
	private void initializeRunner()
	{
		final Runnable paymentOutput = new Runnable()
		{
			@Override
			public void run()
			{
				outputController.printPayments(inputController.getCurrentPayments());
			}
		};
		scheduler.scheduleAtFixedRate(paymentOutput, 0, PERIOD_TIME, TimeUnit.SECONDS);
	}

	/**
	 * @return the inputController
	 */
	public Input getInputController()
	{
		return inputController;
	}

	/**
	 * @param inputController the inputController to set
	 */
	public void setInputController(Input inputController)
	{
		this.inputController = inputController;
	}

	/**
	 * @return the outputController
	 */
	public Output getOutputController()
	{
		return outputController;
	}

	/**
	 * @param outputController the outputController to set
	 */
	public void setOutputController(Output outputController)
	{
		this.outputController = outputController;
	}
}