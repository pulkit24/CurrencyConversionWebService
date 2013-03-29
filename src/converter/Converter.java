package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import rates.Rates;

public class Converter {
	/* Model for storing exchange rate info */
	private Rates rates = null;
	
	public static void main(String[] args) {
		Converter converter = new Converter();
		
		String sourceCurrency = converter.getUserInput("Source currency");
		
	}
	
	public Converter(){
		/* Connect with the model */
		this.rates = new Rates();
	}
	
	public String getUserInput(String displayMessage){
		System.out.print(displayMessage+" : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String userInput = br.readLine();
			return userInput;
		} catch (IOException e) {
			System.err.println("Could not read user input.");
			return null;
		}
	}
	
	public String identifyCurrency(String message){
		/* Search the string for a mention of a currency */
		for(String currency: rates.getCurrencies()){
			if(message.contains(currency))
				return currency;
			// TODO check for more than one mentions
		}
		return null;
	}
}
