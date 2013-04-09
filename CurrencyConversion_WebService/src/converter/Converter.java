package converter;

import java.util.NoSuchElementException;

public class Converter {
	/* Model for storing exchange rate info */
	private String[] currencies = { "AUD", "USD", "EUR" }; // add as many as needed
	private double[][] exchangeRates = { 
			{ 	1, 			1.03863, 	0.79878 }
			, { 0.96264, 	1, 			0.76904 }
			, { 1.25165, 	1.30017, 	1 }
			, }; // 2x2 matrix of from Row to Column, must match in size with the number of currencies above

	/**
	 * Returns the list of legal currencies. Useful when the client doesn't want to track the currencies itself.
	 * 
	 * @return List of supported currencies
	 *         String[] - Array of 3-character ISO codes of the currencies
	 */
	public String[] getCurrencies() {
		return currencies;
	}

	/**
	 * Service to convert one amount into every currency supported by the service.
	 * Useful when you want to see the same value in multiple currencies at the same time (saves one server requests).
	 * 
	 * @param fromCurrency
	 *            String - The 3-character ISO code of the currency (must be supported by the service)
	 * @param fromAmount
	 *            double - The amount to be converted
	 * @return List of converted amounts
	 *         double[] - Array of converted amounts ordered in the exact same order as the currencies returned by
	 *         getCurrencies()
	 */
	public double[] convertToAllCurrencies(String fromCurrency, double fromAmount) {
		/* Convert to every other type of currency */
		double[] convertedAmounts = new double[currencies.length];

		/* Check if the currency exists */
		int fromCurrencyId = -1;
		try {
			fromCurrencyId = getCurrencyId(fromCurrency);
		} catch (NoSuchElementException e) {
			/* Wrong or unsupported currency requested */
			System.err.println(e.toString());
			return null;
		}

		/* Get list of exchange rates for every other currency */
		System.arraycopy(exchangeRates[fromCurrencyId], 0, convertedAmounts, 0, convertedAmounts.length);
		/* Multiply rates with fromAmount to get the converted amounts */
		for (int i = 0; i < convertedAmounts.length; i++)
			convertedAmounts[i] *= fromAmount;
		return convertedAmounts;
	}

	/**
	 * Converts a value from one currency to another. Simple function for a one-time conversion.
	 * 
	 * @param fromCurrency
	 *            String - 3-character ISO code for the source currency
	 * @param fromAmount
	 *            double - Amount to be converted
	 * @param toCurrency
	 *            double - Requested target currency as 3-letter ISO code
	 * @return Converted Amount
	 *         double - Amount after conversion to requested currency
	 */
	public double convertToOneCurrency(String fromCurrency, double fromAmount, String toCurrency) {
		/* Convert to specified type of currency */
		return fromAmount * exchangeRates[getCurrencyId(fromCurrency)][getCurrencyId(toCurrency)];
	}

	/**
	 * Convert a list of amounts in a currency into another currency, all at once.
	 * Great for this assignment, helps convert all amounts in one go. Saves precious server time.
	 * 
	 * @param fromCurrency
	 *            String - 3-letter ISO code of the source currency
	 * @param fromAmounts
	 *            double[] - Array of amounts to be converted
	 * @param toCurrency
	 *            String - Target currency in 3-letter ISO code
	 * @return List of converted amounts
	 *         double[] - Array of amounts after conversion to the target currency, in the exact same order as the
	 *         supplied source amounts.
	 */
	public double[] convertAllToOneCurrency(String fromCurrency, double[] fromAmounts, String toCurrency) {
		/* Convert all amounts to specified currency */
		double[] convertedAmounts = new double[fromAmounts.length];
		System.arraycopy(fromAmounts, 0, convertedAmounts, 0, convertedAmounts.length);

		/* Get single exchange rate between the two currencies */
		double exchangeRate = exchangeRates[getCurrencyId(fromCurrency)][getCurrencyId(toCurrency)];
		/* Multiply source amounts by the rate */
		for (int i = 0; i < convertedAmounts.length; i++)
			convertedAmounts[i] *= exchangeRate;
		return convertedAmounts;
	}

	/**
	 * Returns the id of the currency in the list of hard-coded currencies. This is useful for accessing the 2D exchange
	 * rate matrix because the indices of the arrays correspond one-to-one.
	 * 
	 * Example, for a currency list of {"AUD", "USD", "EUR"}, getCurrencyId("AUD") will return 0.
	 * 
	 * @param currency
	 *            String - Required currency in 3-character ISO codes
	 * @return ID of the currency
	 *         int - Array index of the currency (starting from 0) corresponding to the currency requested.
	 */
	private int getCurrencyId(String currency) {
		/* Traverse through list to find a match */
		for (int id = 0; id < currencies.length; id++)
			if (currency.equals(currencies[id]))
				return id;
		/* If no match found, the currency is not supported. Throw suitable error! */
		throw new NoSuchElementException("Requested currency not found.");
	}
}
