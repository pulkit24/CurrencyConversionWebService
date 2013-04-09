package client.invoice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
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

import client.utilities.Log;

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

	/* One-time-generated Encryption key */
	private DESKeySpec decryptionKey = null; // using DES encryption algorithm
	private SecretKey encryptionKey = null; // for use as encryption cipher

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
			Log.debug("Invoice.constructor by file.read directive", directive);

			/* Rest of the lines are records */
			records = new ArrayList<String>();
			String record = br.readLine();
			while (record != null) {
				records.add(record);
				record = br.readLine();
				Log.debug("Invoice.constructor by file.read record", record);
			}

			br.close();
		} catch (FileNotFoundException e) {
			Log.error("File " + filename + " not found.", e);
		} catch (IOException e) {
			Log.error("Could not read properties from build.properties file.", e);
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
		if (currencies != null) {
			for (String currency : currencies) {
				if (directive.contains(currency))
					return currency;
				// TODO check for more than one mention
			}
		}
		/* No match found - either the list of currencies is incomplete or the invoice file is badly written */
		throw new NoSuchElementException();
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

		Log.debug("Invoice.generateCopyInvoice.original directive", directive);
		Log.debug("Invoice.generateCopyInvoice.new directive", newDirective);

		/* Generate new records */
		ArrayList<String> newRecords = new ArrayList<String>();
		for (int i = 0; i < records.size(); i++) {
			String record = records.get(i);
			Double sourceAmount = sourceAmounts.get(i);
			Double newAmount = newAmounts[i];
			
			/* Round off to 2 significant digits beyond the decimal point */
			String roundedAmount = BigDecimal.valueOf(newAmount.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
			
			/* Replace the old amount with the new converted amount */
			String newRecord = record.replace(sourceAmount.toString(), roundedAmount);
			newRecords.add(newRecord);

			Log.debug("Invoice.generateCopyInvoice.original record", record);
			Log.debug("Invoice.generateCopyInvoice.original record", newRecord);
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
			Log.error("Could not create/write to the file.", e);
		} catch (IOException e) {
			Log.error("Could not write to the file.", e);
		}
	}

	/**
	 * Write an encrypted version of the Invoice data into a file, with the exact same structure as the original.
	 * Uses the DES algorithm to generate a unique key to encipher the text. The key is stored in encryption_key.txt, for future decryption.
	 * 
	 * @param filename
	 *            String - Name of the file to be written to. Note: existing files will be overwritten.
	 * @param storeKeys
	 *            boolean - Whether or not to store the decryption keys in files. The next parameter will define the name of the key file if yes.
	 * @param keyStoreFilename
	 *            String - Name of the file in which to write the decryption key. Leave blank to avoid.
	 */
	public void writeEncryptedInvoice(String filename, boolean storeKeys, String keyStoreFilename) {
		try {
			/* Generate encryption key for using DES algorithm the first time */
			if (decryptionKey == null) {
				KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
				keyGenerator.init(new SecureRandom());
				encryptionKey = keyGenerator.generateKey();
				SecretKeyFactory secretKeyForDESCreator = SecretKeyFactory.getInstance("DES");
				Class<?> keySpecsDESClass = Class.forName("javax.crypto.spec.DESKeySpec");
				decryptionKey = (DESKeySpec) secretKeyForDESCreator.getKeySpec(encryptionKey, keySpecsDESClass);
			}

			/* Wrap a cipher printer over a regular file output stream */
			Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
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

			/* Write generator key as an object into a file */
			if (storeKeys && (keyStoreFilename != null && !"".equals(keyStoreFilename))) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(keyStoreFilename));
				oos.writeObject(decryptionKey.getKey());
				oos.writeObject(cipher.getIV());
				oos.close();
			}

		} catch (NoSuchAlgorithmException e) {
			Log.error("DES algorithm for key generation not found.", e);
		} catch (ClassNotFoundException e) {
			Log.error("Javax DESKeySpec class not found!", e);
		} catch (InvalidKeySpecException e) {
			Log.error("DES key spec is invalid.", e);
		} catch (FileNotFoundException e) {
			Log.error("Key file could not be created.", e);
		} catch (IOException e) {
			Log.error("Key file could not be opened for writing.", e);
		} catch (NoSuchPaddingException e) {
			Log.error("Cipher could not instantiate.", e);
		} catch (InvalidKeyException e) {
			Log.error("Cipher was given an invalid encryption key.", e);
		}
	}
}
