package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.axis2.AxisFault;

import client.adb.CurrencyServiceStub;
import client.adb.CurrencyServiceStub.CurrencyCode;
import client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage;
import client.debug.Debug;
import client.invoice.Invoice;

public class InvoiceConverterSOAP {
	/* Full file name of the invoice file */
	private String invoiceFile = null;

	/* Legal currency names */
	private String[] currencies = { "AUD", "USD", "EUR" };
	private CurrencyCode[] currenciesForService = { CurrencyCode.AUD, CurrencyCode.USD, CurrencyCode.EUR }; // tailored for the live web
																											// service. Must match the
																											// previous list one-to-one!

	/* Web service! */
	CurrencyServiceStub currencyConversionService = null;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/* Load configuration parameters */
		Properties defaults = new Properties();
		defaults.load(new FileInputStream("config.properties"));
		String invoiceFileName = defaults.getProperty("invoice.file.name"); // file name of the invoice file
		String invoiceFileExtension = defaults.getProperty("invoice.file.extension"); // file extension of the invoice file
		boolean debugging = Boolean.parseBoolean(defaults.getProperty("debugging")); // should debugging output be displayed?
		String serviceURL = defaults.getProperty("service.url.soap"); // url of the SOAP web service

		/* Set up debug mode */
		Debug.DEBUGGING = debugging;

		/* Load currency converter client */
		InvoiceConverterSOAP converter = new InvoiceConverterSOAP(serviceURL);

		/* Load invoice file and related properties */
		String invoiceFile = invoiceFileName + "." + invoiceFileExtension;
		Debug.log("InvoiceConverterSOAP.main.invoice.filename", invoiceFile);
		Invoice invoice = new Invoice(invoiceFile);
		invoice.populate(converter.getCurrencies()); // extract the currency and amounts

		/* Get extracted info - source currency and amounts to be converted */
		String sourceCurrency = invoice.getSourceCurrency();
		Debug.log("InvoiceConverterSOAP.main.invoice.currency", sourceCurrency);
		double[] sourceAmounts = invoice.getSourceAmounts();
		Debug.log("InvoiceConverterSOAP.main.invoice.amounts", sourceAmounts);

		/* Convert the invoice file into each of the other currencies */
		for (String targetCurrency : converter.getCurrencies()) {
			if (!sourceCurrency.equals(targetCurrency)) { // skip the same currency of course!
				/* Convert all the amounts into the target currency */
				double[] convertedAmounts = converter.convertAmount(sourceCurrency, sourceAmounts, targetCurrency);

				Debug.log("InvoiceConverterSOAP.main.invoice.converting to currency", targetCurrency);
				Debug.log("InvoiceConverterSOAP.main.service.returned amounts", convertedAmounts);

				/* Write the new invoice file on disk */
				Invoice copyInvoice = invoice.generateCopyInvoice(targetCurrency, convertedAmounts);
				copyInvoice.writeInvoice(invoiceFileName + "_" + targetCurrency + "." + invoiceFileExtension);
			}
		}
	}

	/**
	 * Constructs a new client using the provided web service URL.
	 * 
	 * @param serviceURL
	 *            String - URL to the WSDL descriptor file for the web service
	 */
	public InvoiceConverterSOAP(String serviceURL) {
		/* Contact web server */
		try {
			currencyConversionService = new CurrencyServiceStub();
			Debug.log("InvoiceConverterSOAP.constructor.connected to service", serviceURL);

		} catch (AxisFault e1) {
			System.err
					.println("Client's knowledge of the service is faulty. Probably an Axis fault. Rebuild the client stub."
							+ e1);
		} catch (RemoteException e) {
			System.err
					.println("Could not connect to the web service. Perhaps the server threw an exception of its own?"
							+ e);
		}

	}

	/**
	 * Consumes the web service to convert all the amounts in the invoice file into the target currency.
	 * Due to differences in web service implementations, this function isolates the exact process of contacting and perusing the web
	 * service.
	 * 
	 * @param sourceCurrency
	 *            String - The 3-character ISO code identifying the currency of the supplied amounts
	 * @param sourceAmounts
	 *            double[] - Array of amounts to be converted
	 * @param targetCurrency
	 *            String - The 3-character ISO code identifying the required target currency
	 * @return List of converted amounts
	 *         double[] - Array of amounts received from the web service after conversion to the target currency
	 */
	public double[] convertAmount(String sourceCurrency, double[] sourceAmounts, String targetCurrency) {
		try {
			/* Request exchange rate from the Live web service */
			double exchangeRate = currencyConversionService.getConversionRate(getCurrencyForService(sourceCurrency),
					getCurrencyForService(targetCurrency)).getRate();
			Debug.log("InvoiceConverterSOAP.convertAmount.get exchange rate", exchangeRate + "");

			/* Multiply the source amounts by the exchange rate */
			double[] convertedAmounts = new double[sourceAmounts.length];
			for (int i = 0; i < sourceAmounts.length; i++) {
				convertedAmounts[i] = sourceAmounts[i] * exchangeRate;
			}

			return convertedAmounts;
		} catch (RemoteException e) {
			System.err
					.println("Could not connect to the web service. Perhaps the server threw an exception of its own?"
							+ e);
		} catch (ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage e) {
			System.err.println("The service threw a fault message?" + e);
		}
		return null;
	}

	/**
	 * Returns the list of currencies available in convenient 3-character ISO codes.
	 * 
	 * @return List of currencies
	 *         String[] - Array of currencies in 3-letter ISO codes
	 */
	public String[] getCurrencies() {
		return currencies;
	}

	/**
	 * Get the CurrencyCode object for the desired currency.
	 * This is required by the live web service for some reason.
	 * 
	 * @param currency
	 *            String - 3-character code
	 * @return CurrencyCode object
	 *         CurrencyCode - Object version of the currency code required by the chosen live web service to work
	 */
	private CurrencyCode getCurrencyForService(String currency) {
		for (int id = 0; id < currencies.length; id++)
			if (currency.equals(currencies[id]))
				return currenciesForService[id];
		throw new NoSuchElementException(
				"Your list of currency objects in 'currenciesForService' does not match the string list 'currencies'.");
	}
}
