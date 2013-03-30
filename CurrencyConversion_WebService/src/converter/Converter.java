package converter;

import java.util.NoSuchElementException;

public class Converter {
	/* Model for storing exchange rate info */
	private String[] currencies = { "AUD", "USD", "EUR" };
	private double[][] exchangeRates = { { 1, 10, 20 }, { 10, 1, 20 },
			{ 10, 20, 1 }, };

	public String[] getCurrencies() {
		return currencies;
	}

	public double[] convertToAllCurrencies(String fromCurrency,
			double fromAmount) {
		/* Convert to every other type of currency */
		double[] convertedAmounts = new double[currencies.length];
		System.arraycopy(exchangeRates[getCurrencyId(fromCurrency)], 0,
				convertedAmounts, 0, convertedAmounts.length);
		for (int i = 0; i < convertedAmounts.length; i++)
			convertedAmounts[i] *= fromAmount;
		return convertedAmounts;
	}

	public double convertToOneCurrency(String fromCurrency, double fromAmount,
			String toCurrency) {
		/* Convert to specified type of currency */
		return fromAmount
				* exchangeRates[getCurrencyId(fromCurrency)][getCurrencyId(toCurrency)];
	}

	public double[] convertAllToOneCurrency(String fromCurrency,
			double[] fromAmounts, String toCurrency) {
		/* Convert all amounts to specified currency */
		double[] convertedAmounts = new double[fromAmounts.length];
		System.arraycopy(fromAmounts, 0, convertedAmounts, 0,
				convertedAmounts.length);
		double exchangeRate = exchangeRates[getCurrencyId(fromCurrency)][getCurrencyId(toCurrency)];
		for (int i = 0; i < convertedAmounts.length; i++)
			convertedAmounts[i] *= exchangeRate;
		return convertedAmounts;
	}

	private int getCurrencyId(String currency) {
		for (int id = 0; id < currencies.length; id++)
			if (currency.equals(currencies[id]))
				return id;
		throw new NoSuchElementException("Requested currency not found.");
	}
}
