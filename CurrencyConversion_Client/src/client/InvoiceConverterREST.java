package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import client.invoice.Invoice;
import client.utilities.Log;

public class InvoiceConverterREST {
	/* Legal currency names */
	private String[] currencies = null;

	/* Web service URL for REST */
	private String serviceURL = null;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/* Load configuration parameters */
		Properties defaults = new Properties();
		defaults.load(new FileInputStream("config.properties"));
		String invoiceFileName = defaults.getProperty("invoice.file.name"); // file name of the invoice file
		String invoiceFileExtension = defaults.getProperty("invoice.file.extension"); // file extension of the invoice file
		String invoiceEncryptedFileSuffix = defaults.getProperty("invoice.file.encrypted.suffix"); // suffix to add to encrypted files'
																									// names
		boolean storeKeys = Boolean.parseBoolean(defaults.getProperty("invoice.file.encrypted.storeKey")); // should we save the encryption
																											// keys in text files for later
																											// decryption?
		boolean debugging = Boolean.parseBoolean(defaults.getProperty("debugging")); // should debugging output be displayed?
		String serviceURL = defaults.getProperty("service.url.rest"); // url of the REST web service

		/* Set up debug mode */
		Log.DEBUGGING = debugging;

		/* Load currency converter client */
		InvoiceConverterREST converter = new InvoiceConverterREST(serviceURL);
		String[] legalCurrencies = converter.getCurrencies();

		try {
			if (legalCurrencies == null) {
				throw new NoSuchElementException();
			}

			/* Load invoice file and related properties */
			String invoiceFile = invoiceFileName + "." + invoiceFileExtension;
			if (args.length > 0)
				invoiceFile = args[0]; // load file from argument if supplied
			Log.debug("InvoiceConverterREST.main.invoice.filename", invoiceFile);
			Invoice invoice = new Invoice(invoiceFile);
			invoice.populate(legalCurrencies); // extract the currency and amounts

			/* Get extracted info - source currency and amounts to be converted */
			String sourceCurrency = invoice.getSourceCurrency();
			Log.debug("InvoiceConverterREST.main.invoice.currency", sourceCurrency);
			double[] sourceAmounts = invoice.getSourceAmounts();
			Log.debug("InvoiceConverterREST.main.invoice.amounts", sourceAmounts);

			/* Convert the invoice file into each of the other currencies */
			Log.notify("Converting currencies...");
			for (String targetCurrency : legalCurrencies) {
				if (!sourceCurrency.equals(targetCurrency)) { // skip the same currency of course!
					/* Convert all the amounts into the target currency */
					double[] convertedAmounts = converter.convertAmount(sourceCurrency, sourceAmounts, targetCurrency);

					Log.debug("InvoiceConverterREST.main.invoice.converting to currency", targetCurrency);
					Log.debug("InvoiceConverterREST.main.service.returned amounts", convertedAmounts);

					/* Write the new invoice file + encrypted version on disk */
					String newFileName = invoiceFileName + "_" + targetCurrency + "." + invoiceFileExtension;
					Log.notifyInProgress("Writing output to file " + newFileName);
					Invoice copyInvoice = invoice.generateCopyInvoice(targetCurrency, convertedAmounts);
					copyInvoice.writeInvoice(newFileName);
					Log.notifyProgressComplete();

					String newEncryptedFileName = invoiceFileName + "_" + targetCurrency + "_"
							+ invoiceEncryptedFileSuffix + "." + invoiceFileExtension;
					String keyStoreForEncryptedFileName = invoiceFileName + "_" + targetCurrency + "_"
							+ invoiceEncryptedFileSuffix + "_key." + invoiceFileExtension;
					Log.notifyInProgress("Writing output to file " + newEncryptedFileName);
					copyInvoice.writeEncryptedInvoice(newEncryptedFileName, storeKeys, keyStoreForEncryptedFileName);
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
	public InvoiceConverterREST(String serviceURL) {
		try {
			/* Note web server URL */
			this.serviceURL = serviceURL;
			Log.notify("Connecting to web service at " + serviceURL);

			/* Request a list of legal currencies */
			URL webServiceURL = new URL(serviceURL + "/getCurrencies");
			Document doc = new SAXBuilder().build(webServiceURL);

			/* Read XML response */
			XPath xpath = XPath.newInstance("/ns:getCurrenciesResponse/ns:return");
			List<?> responseItems = xpath.selectNodes(doc);
			ArrayList<String> currenciesRaw = new ArrayList<String>();
			for (Object item : responseItems) {
				currenciesRaw.add(((Element) item).getText());
			}
			currencies = currenciesRaw.toArray(new String[1]);

			Log.debug("InvoiceConverterREST.constructor.legal currencies", currencies);

		} catch (MalformedURLException e) {
			Log.error("Service URL provided is invalid.", e);
		} catch (JDOMException e) {
			Log.error("JDOM crashed or did not work.", e);
		} catch (IOException e) {
			Log.error("Could not connect to the web service.", e);
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
			/* Request a currency conversion for each amount */
			ArrayList<Double> convertedAmountsRaw = new ArrayList<Double>();
			for (double sourceAmount : sourceAmounts) {
				URL webServiceURL = new URL(serviceURL + "/convertToOneCurrency?args0=" + sourceCurrency + "&args1="
						+ sourceAmount + "&args2=" + targetCurrency);
				Document doc = new SAXBuilder().build(webServiceURL);

				/* Read XML response */
				XPath xpath = XPath.newInstance("/ns:convertToOneCurrencyResponse/ns:return");
				convertedAmountsRaw.add(Double.parseDouble(((Element) xpath.selectSingleNode(doc)).getText()));
			}

			/* Convert to a list of doubles */
			double[] convertedAmounts = new double[convertedAmountsRaw.size()];
			for (int i = 0; i < convertedAmounts.length; i++) {
				convertedAmounts[i] = convertedAmountsRaw.get(i);
			}

			return convertedAmounts;
		} catch (MalformedURLException e) {
			Log.error("Service URL provided is invalid.", e);
		} catch (JDOMException e) {
			Log.error("JDOM crashed or did not work.", e);
		} catch (IOException e) {
			Log.error("Could not connect to the web service.", e);
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
