CurrencyConversionWebService
============================

Assignment work for the Web Services course.

A complete client and sample service package that uses web services to perform arbitrary currency conversion. The client contains a file handler for reading records from a file (e.g. an invoice file) to be converted to other currencies. 

## Includes 3 Eclipse projects ##
1. Currency Converter Web Service
A sample POJO web service based on Apache Axis2, that can be accessed by the client.

Provides the following services: 
* Get the list of supported currencies
* Convert a value from one currency to another
* Convert a list of values from one currency to another
* Convert a value from one currency to every other currency supported 

The service can be accessed by both SOAP and REST techniques (i.e. direct HTTP request bindings provided).

2. Currency Converter Client
A full fledged client that peruses the above web service to perform the currency conversion. It generates alternate versions of the supplied _invoice file_ in all the other supported currencies (so far AUD, USD and EUR).

Both SOAP and REST versions of the client program are provided. The REST client also generates encrypted versions of the output _invoice files_.

3. Currency Converter Client Live
A version of the previous client program that connects to a live web service on [restfulwebservices.net](restfulwebservices.net/wcf/CurrencyService.svc?wsdl).

Both SOAP and REST versions of the client program are provided. The REST client also generates encrypted versions of the output _invoice files_. However, since the chosen live service does not provided HTTP GET bindings, the REST client will not work yet. (Pardon me, but not other free web service exists within the Google-able Internet other than this, it seems. The one on [webservicex.net](www.webservicex.net/CurrencyConvertor.asmx?WSDL) seems to have crashed. Let me know if a better free currency conversion service is available.)

## Structure of the File ##
The _invoice file_ is assumed to have the following structure:
1. The first line, called the *directive*, mentions the name of the currency somewhere (anywhere!).
2. The subsequent lines are csv records with arbitrary fields, such as names, except the last field being the monetary amounts.

## Output ##
The client program reads the _invoice file_ and generates new files with converted currencies. For example, if the _invoice file_ contains values in AUD, the client will generate *invoice_USD.txt* and *invoice_EUR.txt* files as output, which will contain the converted amounts at the right places. 

### Encryption ###
The REST clients also generate an encrypted version of the output files with the name *invoice_USD_encrypted.txt* for example. 

Encryption uses the DES algorithm, and the encryption key generated during this process is saved in _encryption_key.txt_ file for later decryption.
Information for the algorithm has been sourced from the [Java2s Tutorial on Security](http://www.java2s.com/Tutorial/Java/0490__Security/Catalog0490__Security.htm).

## Other features ##
The clients are configurable via the config.properties file, which helps reduce "hard codes" in the program.

Additionally, verbose outputs can be turned on by setting the debug mode to on (true).
