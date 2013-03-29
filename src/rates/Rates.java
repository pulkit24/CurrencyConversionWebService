package rates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Rates {
	/* Currencies */
	private String[] currencies = null; // String names of all currencies
										// (indices can be used as IDs)

	/* Exchange rates */
	private double[][] rates = null; // 2D matrix for storing exchange rates
	public static double UNDEFINED = 0; // no rate defined for a conversion

	public Rates() {
		/* Load info from properties file */
		try {
			Properties defaults = new Properties();
			defaults.load(new FileInputStream("rates.properties"));

			/* Load currency names */
			this.currencies = defaults.getProperty("currencies").split(", ");

			/* Load exchange rates */
			int currencyCount = currencies.length;
			this.rates = new double[currencyCount][currencyCount];
			for (int fromID = 0; fromID < currencyCount; fromID++) {
				for (int toID = 0; toID < currencyCount; toID++) {
					/* Are they the same? */
					if (fromID == toID)
						rates[fromID][toID] = 1;
					else {
						/* Get the default exchange rate */
						String rawRateProperty = defaults
								.getProperty(currencies[fromID]
										+ defaults.getProperty("separator")
										+ currencies[toID]);
						if (rawRateProperty != null
								&& !"".equals(rawRateProperty))
							rates[fromID][toID] = Double
									.parseDouble(rawRateProperty);
						else
							throw new NoSuchElementException();
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err
					.println("Rates.constructor could not find the default properties file.");
		} catch (IOException e) {
			System.err
					.println("Rates.constructor could not read the default properties file.");
		}
	}

	public boolean setRate(String fromCurrency, String toCurrency, double rate) {
		this.rates[getCurrencyId(fromCurrency)][getCurrencyId(toCurrency)] = rate;
		return true;
	}

	public double getRate(String fromCurrency, String toCurrency) {
		return this.rates[getCurrencyId(fromCurrency)][getCurrencyId(toCurrency)];
	}

	public String[] getCurrencies(){
		return this.currencies;
	}
	
	private int getCurrencyId(String currency) throws NoSuchElementException {
		for (int id = 0; id < this.currencies.length; id++) {
			if (currency.equals(currencies[id]))
				return id;
		}
		throw new NoSuchElementException();
	}
}
