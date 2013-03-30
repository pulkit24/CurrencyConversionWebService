package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.axis2.AxisFault;

import client.adb.CurrencyConversionServiceStub;
import client.debug.Debug;
import client.invoice.Invoice;

public class InvoiceConverter {
	private String invoiceFile = null;

	/* Legal currency names */
	private String[] currencies = null;

	/* Web service! */
	CurrencyConversionServiceStub currencyConversionService = null;

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		/* Load configuration parameters */
		Properties defaults = new Properties();
		defaults.load(new FileInputStream("config.properties"));
		String invoiceFileName = defaults.getProperty("invoice.file.name");
		String invoiceFileExtension = defaults
				.getProperty("invoice.file.extension");
		boolean debugging = Boolean.parseBoolean(defaults
				.getProperty("debugging"));
		String serviceURL = defaults.getProperty("service.url");

		/* Set up debug mode */
		Debug.DEBUGGING = debugging;

		/* Load currency converter client */
		InvoiceConverter converter = new InvoiceConverter(serviceURL);

		/* Load invoice file and related properties */
		String invoiceFile = invoiceFileName + "." + invoiceFileExtension;
		Debug.log("InvoiceConverter.main.invoice.filename", invoiceFile);
		Invoice invoice = new Invoice(invoiceFile);
		invoice.populate(converter.getCurrencies());

		String sourceCurrency = invoice.getSourceCurrency();
		Debug.log("InvoiceConverter.main.invoice.currency", sourceCurrency);
		double[] sourceAmounts = invoice.getSourceAmounts();
		Debug.log("InvoiceConverter.main.invoice.amounts", sourceAmounts);

		for (String targetCurrency : converter.getCurrencies()) {
			if (!sourceCurrency.equals(targetCurrency)) {
				double[] convertedAmounts = converter.convertAmount(
						sourceCurrency, sourceAmounts, targetCurrency);

				Debug.log(
						"InvoiceConverter.main.invoice.converting to currency",
						targetCurrency);
				Debug.log("InvoiceConverter.main.service.returned amounts",
						convertedAmounts);

				Invoice copyInvoice = invoice.generateCopyInvoice(
						targetCurrency, convertedAmounts);
				copyInvoice.writeInvoice(invoiceFileName + "_" + targetCurrency
						+ "." + invoiceFileExtension);
			}
		}
	}

	public InvoiceConverter(String serviceURL) {
		/* Contact web server */
		try {
			currencyConversionService = new CurrencyConversionServiceStub(
					serviceURL);
			Debug.log("InvoiceConverter.constructor.connected to service",
					serviceURL);

			/* Get the list of legal currencies */
			currencies = currencyConversionService.getCurrencies();
			Debug.log("InvoiceConverter.constructor.legal currencies",
					currencies);

		} catch (AxisFault e1) {
			System.err
					.println("Client's knowledge of the service is faulty. Probably an Axis fault. Rebuild the client stub.");
		} catch (RemoteException e) {
			System.err
					.println("Could not connect to the web service. Perhaps the server threw an exception of its own?");
		}

	}

	public double[] convertAmount(String sourceCurrency,
			double[] sourceAmounts, String targetCurrency) {
		try {
			return currencyConversionService.convertAllToOneCurrency(
					sourceCurrency, sourceAmounts, targetCurrency);
		} catch (RemoteException e) {
			System.err
					.println("Could not connect to the web service. Perhaps the server threw an exception of its own?");
		}
		return null;
	}

	public String[] getCurrencies() {
		return currencies;
	}
}
