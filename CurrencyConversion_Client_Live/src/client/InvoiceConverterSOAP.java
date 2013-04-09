package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.axis2.AxisFault;

import client.adb.CurrencyServerStub;
import client.invoice.Invoice;
import client.utilities.Log;

public class InvoiceConverterSOAP {
	/* Legal currency names */
	private String[] currencies = { "AUD", "USD", "EUR" };
	// private CurrencyCode[] currenciesForService = { CurrencyCode.AUD, CurrencyCode.USD, CurrencyCode.EUR }; // tailored for the live web

	/* Web service! */
	CurrencyServerStub currencyConversionService = null;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/* Load configuration parameters */
		Properties defaults = new Properties();
		defaults.load(new FileInputStream("config.properties"));
		String invoiceFileName = defaults.getProperty("invoice.file.name"); // file name of the invoice file
		String invoiceFileExtension = defaults.getProperty("invoice.file.extension"); // file extension of the invoice file
		boolean debugging = Boolean.parseBoolean(defaults.getProperty("debugging")); // should debugging output be displayed?
		String serviceURL = defaults.getProperty("service.url.soap"); // url of the SOAP web service

		/* Set up debug mode */
		Log.DEBUGGING = debugging;

		/* Load currency converter client */
		InvoiceConverterSOAP converter = new InvoiceConverterSOAP(serviceURL);

		try {
			/* Load invoice file and related properties */
			String invoiceFile = invoiceFileName + "." + invoiceFileExtension;
			if (args.length > 0)
				invoiceFile = args[0]; // load file from argument if supplied
			Log.debug("InvoiceConverterSOAP.main.invoice.filename", invoiceFile);
			Invoice invoice = new Invoice(invoiceFile);
			invoice.populate(converter.getCurrencies()); // extract the currency and amounts

			/* Get extracted info - source currency and amounts to be converted */
			String sourceCurrency = invoice.getSourceCurrency();
			Log.debug("InvoiceConverterSOAP.main.invoice.currency", sourceCurrency);
			double[] sourceAmounts = invoice.getSourceAmounts();
			Log.debug("InvoiceConverterSOAP.main.invoice.amounts", sourceAmounts);

			/* Convert the invoice file into each of the other currencies */
			Log.notify("Converting currencies...");
			for (String targetCurrency : converter.getCurrencies()) {
				if (!sourceCurrency.equals(targetCurrency)) { // skip the same currency of course!
					/* Convert all the amounts into the target currency */
					double[] convertedAmounts = converter.convertAmount(sourceCurrency, sourceAmounts, targetCurrency);
					if (convertedAmounts == null)
						throw new RemoteException();

					Log.debug("InvoiceConverterSOAP.main.invoice.converting to currency", targetCurrency);
					Log.debug("InvoiceConverterSOAP.main.service.returned amounts", convertedAmounts);

					/* Write the new invoice file on disk */
					String newFileName = invoiceFileName + "_" + targetCurrency + "." + invoiceFileExtension;
					Log.notifyInProgress("Writing output to file " + newFileName);
					Invoice copyInvoice = invoice.generateCopyInvoice(targetCurrency, convertedAmounts);
					copyInvoice.writeInvoice(newFileName);
					Log.notifyProgressComplete();
				}
			}
		} catch (RemoteException e) {
			Log.error("Could not connect to the web service. Perhaps the server threw an exception of its own?", e);
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
			currencyConversionService = new CurrencyServerStub();
			Log.notify("Connecting to web service at " + serviceURL);
			Log.debug("InvoiceConverterSOAP.constructor.connected to service", serviceURL);

		} catch (AxisFault e1) {
			Log.error(
					"Could not connect to the server. Is the server running? Or, the client's knowledge of the service is faulty. Probably an Axis fault. Rebuild the client stub.",
					e1);
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
			double[] convertedAmounts = new double[sourceAmounts.length];
			for (int i = 0; i < sourceAmounts.length; i++) {
				convertedAmounts[i] = currencyConversionService.convertToNum("licenseKey14", sourceCurrency,
						targetCurrency, sourceAmounts[i], false, "", "");
			}

			return convertedAmounts;
		} catch (RemoteException e) {
			Log.error("Could not connect to the web service. Perhaps the server threw an exception of its own?", e);
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
}
