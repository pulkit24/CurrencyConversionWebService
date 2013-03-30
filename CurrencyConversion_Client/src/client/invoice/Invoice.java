package client.invoice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import client.debug.Debug;

public class Invoice {
	/* Contents of the invoice file */
	private String directive = null;
	private ArrayList<String> records = new ArrayList<String>();

	/* Extracted content */
	private String sourceCurrency = null;
	private ArrayList<Double> sourceAmounts = new ArrayList<Double>();
	private int locationOfCurrencyInDirective = -1;
	private ArrayList<Integer> locationOfAmountInRecords = new ArrayList<Integer>();

	public Invoice(String filename) {
		/* Read the invoice file */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename)));

			/* First line is the directive */
			directive = br.readLine();
			Debug.log("Invoice.constructor by file.read directive", directive);

			/* Rest of the lines are records */
			records = new ArrayList<String>();
			String record = br.readLine();
			while (record != null) {
				records.add(record);
				record = br.readLine();
				Debug.log("Invoice.constructor by file.read record", record);
			}

		} catch (FileNotFoundException e) {
			System.err.println("File " + filename + " not found.");
		} catch (IOException e) {
			System.err
					.println("Could not read properties from build.properties file.");
		}
	}

	public Invoice(String directive, ArrayList<String> records) {
		this.directive = directive;
		this.records = records;
	}

	private String identifyCurrency(String[] currencies) {
		/* Search the string for a mention of a currency */
		for (String currency : currencies) {
			if (directive.contains(currency))
				return currency;
			// TODO check for more than one mention
		}
		throw new NoSuchElementException(
				"Could not find a currency in the invoice file. Make sure it is in CAPITALS.");
	}

	private ArrayList<Double> identifyAmounts() {
		/* Get the amounts from the records */
		ArrayList<Double> amounts = new ArrayList<Double>();
		for (String record : records) {
			String[] recordContents = record.split(",");
			amounts.add(Double
					.parseDouble(recordContents[recordContents.length - 1]));
		}
		return amounts;
	}

	public void populate(String[] currencies) {
		sourceCurrency = identifyCurrency(currencies);
		sourceAmounts = identifyAmounts();
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public double[] getSourceAmounts() {
		double[] sourceAmountsProcessed = new double[sourceAmounts.size()];
		for (int i = 0; i < sourceAmounts.size(); i++) {
			sourceAmountsProcessed[i] = sourceAmounts.get(i);
		}
		return sourceAmountsProcessed;
	}

	public Invoice generateCopyInvoice(String newCurrency, double[] newAmounts) {
		/* Generate new directive */
		String newDirective = directive.replaceAll(sourceCurrency, newCurrency);

		Debug.log("Invoice.generateCopyInvoice.original directive", directive);
		Debug.log("Invoice.generateCopyInvoice.new directive", newDirective);

		ArrayList<String> newRecords = new ArrayList<String>();
		for (int i = 0; i < records.size(); i++) {
			String record = records.get(i);
			Double sourceAmount = sourceAmounts.get(i);
			Double newAmount = newAmounts[i];
			String newRecord = record.replace(sourceAmount.toString(),
					newAmount.toString());
			newRecords.add(newRecord);

			Debug.log("Invoice.generateCopyInvoice.original record", record);
			Debug.log("Invoice.generateCopyInvoice.original record", newRecord);
		}

		return new Invoice(newDirective, newRecords);
	}

	public void writeInvoice(String filename) {
		try {
			FileOutputStream fout = new FileOutputStream(filename);

			fout.write(directive.getBytes());
			fout.write("\n".getBytes());
			for (String record : records) {
				fout.write(record.getBytes());
				fout.write("\n".getBytes());
			}

			fout.flush();
			fout.close();

		} catch (FileNotFoundException e) {
			System.err.println("Could not create/write to the file.");
		} catch (IOException e) {
			System.err.println("Could not write to the file.");
		}
	}
}
