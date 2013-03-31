package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import client.debug.Debug;
import client.invoice.Invoice;

public class InvoiceConverterREST {
	/* Full file name of the invoice file */
	private String invoiceFile = null;

	/* Legal currency names */
	private String[] currencies = { "AUD", "USD", "EUR" };

	/* Web service URL for REST */
	private String serviceURL = null;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/* Load configuration parameters */
		Properties defaults = new Properties();
		defaults.load(new FileInputStream("config.properties"));
		String invoiceFileName = defaults.getProperty("invoice.file.name"); // file name of the invoice file
		String invoiceFileExtension = defaults.getProperty("invoice.file.extension"); // file extension of the invoice file
		boolean debugging = Boolean.parseBoolean(defaults.getProperty("debugging")); // should debugging output be displayed?
		String serviceURL = defaults.getProperty("service.url.rest"); // url of the REST web service

		/* Set up debug mode */
		Debug.DEBUGGING = debugging;

		/* Load currency converter client */
		InvoiceConverterREST converter = new InvoiceConverterREST(serviceURL);

		/* Load invoice file and related properties */
		String invoiceFile = invoiceFileName + "." + invoiceFileExtension;
		Debug.log("InvoiceConverterREST.main.invoice.filename", invoiceFile);
		Invoice invoice = new Invoice(invoiceFile);
		invoice.populate(converter.getCurrencies()); // extract the currency and amounts

		/* Get extracted info - source currency and amounts to be converted */
		String sourceCurrency = invoice.getSourceCurrency();
		Debug.log("InvoiceConverterREST.main.invoice.currency", sourceCurrency);
		double[] sourceAmounts = invoice.getSourceAmounts();
		Debug.log("InvoiceConverterREST.main.invoice.amounts", sourceAmounts);

		/* Convert the invoice file into each of the other currencies */
		for (String targetCurrency : converter.getCurrencies()) {
			if (!sourceCurrency.equals(targetCurrency)) { // skip the same currency of course!
				/* Convert all the amounts into the target currency */
				double[] convertedAmounts = converter.convertAmount(sourceCurrency, sourceAmounts, targetCurrency);

				Debug.log("InvoiceConverterREST.main.invoice.converting to currency", targetCurrency);
				Debug.log("InvoiceConverterREST.main.service.returned amounts", convertedAmounts);

				/* Write the new invoice file + encrypted version on disk */
				Invoice copyInvoice = invoice.generateCopyInvoice(targetCurrency, convertedAmounts);
				copyInvoice.writeInvoice(invoiceFileName + "_" + targetCurrency + "." + invoiceFileExtension);
				copyInvoice.writeEncryptedInvoice(invoiceFileName + "_" + targetCurrency + "_encrypted."
						+ invoiceFileExtension);
			}
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
		/* Note web server URL */
		this.serviceURL = serviceURL;
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
				URL webServiceURL = new URL(serviceURL + "/GetConversionRate?FromCurrency=" + sourceCurrency
						+ "&ToCurrency=" + targetCurrency);
				Document doc = new SAXBuilder().build(webServiceURL);

				/* Read XML response */
				XPath xpath = XPath.newInstance("/ns:GetConversionRateResponse/ns:return");
				convertedAmountsRaw.add(sourceAmount
						* Double.parseDouble(((Element) xpath.selectSingleNode(doc)).getText()));
			}

			/* Convert to a list of doubles */
			double[] convertedAmounts = new double[convertedAmountsRaw.size()];
			for (int i = 0; i < convertedAmounts.length; i++) {
				convertedAmounts[i] = convertedAmountsRaw.get(i);
			}

			return convertedAmounts;
		} catch (MalformedURLException e) {
			System.err.println("Service URL provided is invalid." + e);
		} catch (JDOMException e) {
			System.err.println("JDOM crashed or did not work." + e);
		} catch (IOException e) {
			System.err.println("Could not connect to the web service." + e);
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
