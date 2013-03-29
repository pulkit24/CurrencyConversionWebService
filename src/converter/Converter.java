package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

import model.Rates;

public class Converter {
	/* Model for storing exchange rate info */
	private Rates rates = null;

	public static void main(String[] args) {
		Converter converter = new Converter();

		String sourceCurrency = converter.identifyCurrency(converter
				.getUserInput("Source currency"));
		double sourceValue = Double.parseDouble(converter
				.getUserInput("Source value"));

		converter.displayValues(converter.convertCurrency(sourceCurrency,
				sourceValue));
	}

	public Converter() {
		/* Connect with the model */
		this.rates = new Rates();
	}

	public String getUserInput(String displayMessage) {
		System.out.print(displayMessage + " : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String userInput = br.readLine();
			return userInput;
		} catch (IOException e) {
			System.err.println("Could not read user input.");
			return null;
		}
	}

	public String identifyCurrency(String message) {
		/* Search the string for a mention of a currency */
		for (String currency : rates.getCurrencies()) {
			if (message.contains(currency))
				return currency;
			// TODO check for more than one mentions
		}
		return null;
	}

	public HashMap<String, Double> convertCurrency(String fromCurrency,
			double fromValue) {
		/* Convert to every other type of currency */
		HashMap<String, Double> convertedValues = new HashMap<String, Double>();
		for (String toCurrency : rates.getCurrencies()) {
			if (!toCurrency.equals(fromCurrency)) {
				double toValue = rates.getRate(fromCurrency, toCurrency)
						* fromValue;
				convertedValues.put(toCurrency, new Double(toValue));
			}
		}
		return convertedValues;
	}

	public void displayValues(HashMap<String, Double> values) {
		System.out.println("Converted values: ");
		Set<String> currencies = values.keySet();
		for (String currency : currencies) {
			System.out.println(currency + ": "
					+ values.get(currency).doubleValue());
		}
	}
}
