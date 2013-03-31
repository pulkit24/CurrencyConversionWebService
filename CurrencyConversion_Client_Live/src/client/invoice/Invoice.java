package client.invoice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import client.debug.Debug;

/**
 * Handles all operations of the Invoice file.
 * 
 * @author Pulkit Karwal (3360413)
 * 
 */
public class Invoice {
	/* Contents of the invoice file */
	private String directive = null; // first line
	private ArrayList<String> records = new ArrayList<String>(); // subsequent lines

	/* Extracted content */
	private String sourceCurrency = null; // extracted from the first line (directive)
	private ArrayList<Double> sourceAmounts = new ArrayList<Double>(); // extracted from the record lines

	/**
	 * Loads up the invoice file. Reads the invoice from the supplied filename and stores the directive and records. Note: this does not
	 * being identifying the source currency or the amounts: call populate() for that.
	 * 
	 * @param filename
	 *            String - name of the invoice file with extension. Should be within the client project for to be accessible
	 */
	public Invoice(String filename) {
		/* Read the invoice file */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

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
			System.err.println("File " + e + filename + " not found.");
		} catch (IOException e) {
			System.err.println("Could not read properties from build.properties file." + e);
		}
	}

	/**
	 * Manually create the invoice by supplying the first (directive) line and the subsequent records instead of reading from a file.
	 * 
	 * @param directive
	 *            String - First line of the invoice file that contains the currency
	 * @param records
	 *            ArrayList<String> - Dynamic array of records from the invoice file
	 */
	public Invoice(String directive, ArrayList<String> records) {
		/* Directly store the directive and records */
		this.directive = directive;
		this.records = records;
	}

	/**
	 * Locates any mention of currency in the directive line. Must pass a list of currencies to look for.
	 * Throws NoSuchElementException is no match was found.
	 * 
	 * @param currencies
	 *            String[] - List of currency names to search for
	 * @return Identified currency
	 *         String - Source currency identified from the directive (first) line of the invoice file.
	 */
	private String identifyCurrency(String[] currencies) {
		/* Search the string for a mention of a currency */
		for (String currency : currencies) {
			if (directive.contains(currency))
				return currency;
			// TODO check for more than one mention
		}
		/* No match found - either the list of currencies is incomplete or the invoice file is badly written */
		throw new NoSuchElementException("Could not find a currency in the invoice file. Make sure it is in CAPITALS.");
	}

	/**
	 * Identify and extract the list of amounts to be converted to the other currencies.
	 * 
	 * @return List of amounts
	 *         ArrayList<Double> - Dynamic array of amounts in the exact same order as mentioned in the invoice file.
	 */
	private ArrayList<Double> identifyAmounts() {
		/* Get the amounts from the records */
		ArrayList<Double> amounts = new ArrayList<Double>();
		for (String record : records) {
			String[] recordContents = record.split(","); // split the record line by the comma
			amounts.add(Double.parseDouble(recordContents[recordContents.length - 1])); // the last token is the amount
		}
		return amounts;
	}

	/**
	 * Explicit call to Invoice to identify and extract the source currency and amounts from the invoice file.
	 * This function isn't called automatically by the constructor because string searching may be expensive, and is only necessary when the
	 * user loads from an invoice file. When Invoice automatically generates copies of the invoice file in other currencies, it has no need
	 * to call this function.
	 * 
	 * @param currencies
	 *            String[] - List of valid currency names in 3-character ISO codes in capitals, used to identify currency in the invoice
	 *            file.
	 */
	public void populate(String[] currencies) {
		/* Identify the source currency and amounts mentioned in the invoice file */
		sourceCurrency = identifyCurrency(currencies);
		sourceAmounts = identifyAmounts();
	}

	/**
	 * Returns the source currency identified in the invoice file.
	 * NOTE: Must call populate() before using this function.
	 * 
	 * @return Source currency
	 *         String - 3-character ISO code representing the currency identified in the invoice file.
	 */
	public String getSourceCurrency() {
		return sourceCurrency;
	}

	/**
	 * Returns the list of amounts mentioned in the invoice file, to be converted by the web service.
	 * NOTE: Must call populate() before using this function.
	 * 
	 * @return List of source amounts
	 *         double[] - Array of amounts to be converted by the web service.
	 */
	public double[] getSourceAmounts() {
		/* Convert ArrayList to simple array */
		double[] sourceAmountsProcessed = new double[sourceAmounts.size()];
		for (int i = 0; i < sourceAmounts.size(); i++) {
			sourceAmountsProcessed[i] = sourceAmounts.get(i);
		}
		return sourceAmountsProcessed;
	}

	/**
	 * Generates a duplicate Invoice object, but with replaced currency name and amounts. Use this function to generate copies after
	 * converting the amounts in different currencies.
	 * 
	 * @param newCurrency
	 *            String - Name of the new currency in 3-character ISO code
	 * @param newAmounts
	 *            double[] - Array of new amounts converted from the original amounts using the web service
	 * @return Invoice object
	 *         Invoice - A new Invoice object ready to be written into a file
	 */
	public Invoice generateCopyInvoice(String newCurrency, double[] newAmounts) {
		/* Generate new directive by replacing the currency name */
		String newDirective = directive.replaceAll(sourceCurrency, newCurrency);

		Debug.log("Invoice.generateCopyInvoice.original directive", directive);
		Debug.log("Invoice.generateCopyInvoice.new directive", newDirective);

		/* Generate new records */
		ArrayList<String> newRecords = new ArrayList<String>();
		for (int i = 0; i < records.size(); i++) {
			String record = records.get(i);
			Double sourceAmount = sourceAmounts.get(i);
			Double newAmount = newAmounts[i];
			/* Replace the old amount with the new converted amount */
			String newRecord = record.replace(sourceAmount.toString(), newAmount.toString());
			newRecords.add(newRecord);

			Debug.log("Invoice.generateCopyInvoice.original record", record);
			Debug.log("Invoice.generateCopyInvoice.original record", newRecord);
		}

		/* Create and return the new Invoice object */
		return new Invoice(newDirective, newRecords);
	}

	/**
	 * Write the Invoice data into a file, with the exact same structure as the original.
	 * 
	 * @param filename
	 *            String - Name of the file to be written to. Note: existing files will be overwritten.
	 */
	public void writeInvoice(String filename) {
		/* Write to file */
		try {
			FileOutputStream fout = new FileOutputStream(filename);

			/* Add the directive first */
			fout.write(directive.getBytes());
			fout.write("\n".getBytes());
			/* Add each record subsequently in the same order as the original */
			for (String record : records) {
				fout.write(record.getBytes());
				fout.write("\n".getBytes());
			}

			/* Graciously close everything */
			fout.flush();
			fout.close();

		} catch (FileNotFoundException e) {
			System.err.println("Could not create/write to the file." + e);
		} catch (IOException e) {
			System.err.println("Could not write to the file." + e);
		}
	}

	/**
	 * Write an encrypted version of the Invoice data into a file, with the exact same structure as the original.
	 * Uses the DES algorithm to generate a unique key to encipher the text. The key is stored in encryption_key.txt, for future decryption.
	 * 
	 * @param filename
	 *            String - Name of the file to be written to. Note: existing files will be overwritten.
	 */
	public void writeEncryptedInvoice(String filename) {
		try {
			/* Generate encryption key for using DES algorithm */
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			SecretKeyFactory secretKeyForDESCreator = SecretKeyFactory.getInstance("DES");
			Class keySpecsDESClass = Class.forName("javax.crypto.spec.DESKeySpec");
			DESKeySpec keySpecsDES = (DESKeySpec) secretKeyForDESCreator.getKeySpec(secretKey, keySpecsDESClass);

			/* Write generator key as an object into a file */
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("encryption_key.txt"));
			oos.writeObject(keySpecsDES.getKey());

			/* Wrap a cipher printer over a regular file output stream */
			Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(filename), cipher);

			/* Write to file */
			cos.write(directive.getBytes());
			cos.write("\n".getBytes());
			for (String record : records) {
				cos.write(record.getBytes());
				cos.write("\n".getBytes());
			}

			/* Close all */
			cos.close();
			oos.writeObject(cipher.getIV());
			oos.close();

		} catch (NoSuchAlgorithmException e) {
			System.err.println("DES algorithm for key generation not found." + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Javax DESKeySpec class not found!" + e);
		} catch (InvalidKeySpecException e) {
			System.err.println("DES key spec is invalid." + e);
		} catch (FileNotFoundException e) {
			System.err.println("Key file could not be created." + e);
		} catch (IOException e) {
			System.err.println("Key file could not be opened for writing." + e);
		} catch (NoSuchPaddingException e) {
			System.err.println("Cipher could not instantiate." + e);
		} catch (InvalidKeyException e) {
			System.err.println("Cipher was given an invalid encryption key." + e);
		}
	}
}
