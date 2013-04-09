package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.axis2.AxisFault;

import client.adb.CurrencyConversionServiceStub;
import client.invoice.Invoice;
import client.utilities.Log;

public class InvoiceConverterSOAP {
	/* Legal currency names */
	private String[] currencies = null;

	/* Web service! */
	CurrencyConversionServiceStub currencyConversionService = null;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/* Load configuration parameters */
		Properties defaults = new Properties();
		defaults.load(new FileInputStream("config.properties"));
		String invoiceFileName = defaults.getProperty("invoice.file.name"); // file name of the invoice file
		String invoiceFileExtension = defaults.getProperty("invoice.file.extension"); // file extension of the invoice file
		boolean debugging = Boolean.parseBoolean(defaults.getProperty("debugging")); // should debugging output be displayed?
		String serviceURL = defaults.getProperty("service.url.soap"); // url of the web service

		/* Set up debug mode */
		Log.DEBUGGING = debugging;

		/* Load currency converter client */
		InvoiceConverterSOAP converter = new InvoiceConverterSOAP(serviceURL);
		String[] legalCurrencies = converter.getCurrencies();

		try {
			if (legalCurrencies == null) {
				throw new NoSuchElementException();
			}

			/* Load invoice file and related properties */
			String invoiceFile = invoiceFileName + "." + invoiceFileExtension;
			if (args.length > 0)
				invoiceFile = args[0]; // load file from argument if supplied
			Log.debug("InvoiceConverterSOAP.main.invoice.filename", invoiceFile);
			Invoice invoice = new Invoice(invoiceFile);
			invoice.populate(legalCurrencies); // extract the currency and amounts

			/* Get extracted info - source currency and amounts to be converted */
			String sourceCurrency = invoice.getSourceCurrency();
			Log.debug("InvoiceConverterSOAP.main.invoice.currency", sourceCurrency);
			double[] sourceAmounts = invoice.getSourceAmounts();
			Log.debug("InvoiceConverterSOAP.main.invoice.amounts", sourceAmounts);

			/* Convert the invoice file into each of the other currencies */
			Log.notify("Converting currencies...");
			for (String targetCurrency : legalCurrencies) {
				if (!sourceCurrency.equals(targetCurrency)) { // skip the same currency of course!
					/* Convert all the amounts into the target currency */
					double[] convertedAmounts = converter.convertAmount(sourceCurrency, sourceAmounts, targetCurrency);

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
		} catch (NoSuchElementException e) {
			Log.error("Could not find a currency in the invoice file. Make sure it is in CAPITALS.", e);
		}
	}

	/**
	 * Constructs a new client using the provided web service URL.
	 * Attempts to contact the web service and get a list of legal currencies to use.
	 * 
	 * @param serviceURL
	 *            String - URL to the WSDL descriptor file for the web service
	 */
	public InvoiceConverterSOAP(String serviceURL) {
		/* Contact web server */
		try {
			currencyConversionService = new CurrencyConversionServiceStub(serviceURL);
			Log.notify("Connecting to web service at " + serviceURL);
			Log.debug("InvoiceConverterSOAP.constructor.connected to service", serviceURL);

			/* Get the list of legal currencies */
			currencies = currencyConversionService.getCurrencies();
			Log.debug("InvoiceConverterSOAP.constructor.legal currencies", currencies);

		} catch (AxisFault e1) {
			Log.error(
					"Could not connect to the server. Is the server running? Or, the client's knowledge of the service is faulty. Probably an Axis fault. Rebuild the client stub.",
					e1);
		} catch (RemoteException e) {
			Log.error(
					"Could not connect to the web service. Perhaps the service is down or threw an exception of its own?",
					e);
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
			/* Ask the service to convert the entire list of source amounts */
			return currencyConversionService.convertAllToOneCurrency(sourceCurrency, sourceAmounts, targetCurrency);
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
