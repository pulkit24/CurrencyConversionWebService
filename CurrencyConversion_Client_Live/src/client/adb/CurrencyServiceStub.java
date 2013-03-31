/**
 * CurrencyServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package client.adb;

/*
 *  CurrencyServiceStub java implementation
 */

public class CurrencyServiceStub extends org.apache.axis2.client.Stub {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static synchronized java.lang.String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("CurrencyService" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[1];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://www.restfulwebservices.net/ServiceContracts/2008/01",
				"getConversionRate"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

	}

	// populates the faults
	private void populateFaults() {

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName(
				"http://GOTLServices.FaultContracts/2008/01", "DefaultFaultContract"), "GetConversionRate"),
				"client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName(
				"http://GOTLServices.FaultContracts/2008/01", "DefaultFaultContract"), "GetConversionRate"),
				"client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage");
		faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName(
				"http://GOTLServices.FaultContracts/2008/01", "DefaultFaultContract"), "GetConversionRate"),
				"client.adb.CurrencyServiceStub$DefaultFaultContractE");

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public CurrencyServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public CurrencyServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint, boolean useSeparateListener) throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

		_serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

	}

	/**
	 * Default Constructor
	 */
	public CurrencyServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext)
			throws org.apache.axis2.AxisFault {

		this(configurationContext, "http://www.restfulwebservices.net/wcf/CurrencyService.svc");

	}

	/**
	 * Default Constructor
	 */
	public CurrencyServiceStub() throws org.apache.axis2.AxisFault {

		this("http://www.restfulwebservices.net/wcf/CurrencyService.svc");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public CurrencyServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see client.adb.CurrencyService#getConversionRate
	 * @param getConversionRate
	 * 
	 * @throws client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage
	 *             :
	 */

	public client.adb.CurrencyServiceStub.Currency getConversionRate(

	client.adb.CurrencyServiceStub.CurrencyCode fromCurrency, client.adb.CurrencyServiceStub.CurrencyCode toCurrency)

	throws java.rmi.RemoteException

	, client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0]
					.getName());
			_operationClient.getOptions().setAction("GetConversionRate");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;
			client.adb.CurrencyServiceStub.GetConversionRate dummyWrappedType = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), fromCurrency, toCurrency,
					dummyWrappedType, optimizeContent(new javax.xml.namespace.QName(
							"http://www.restfulwebservices.net/ServiceContracts/2008/01", "getConversionRate")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
					client.adb.CurrencyServiceStub.GetConversionRateResponse.class, getEnvelopeNamespaces(_returnEnv));

			return getGetConversionRateResponseGetConversionRateResult((client.adb.CurrencyServiceStub.GetConversionRateResponse) object);

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
						"GetConversionRate"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "GetConversionRate"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "GetConversionRate"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage) {
							throw (client.adb.ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
			}
		}
	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private javax.xml.namespace.QName[] opNameArray = null;

	private boolean optimizeContent(javax.xml.namespace.QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	// http://www.restfulwebservices.net/wcf/CurrencyService.svc
	public static class UnsignedInt implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt", "ns1");

		/**
		 * field for UnsignedInt
		 */

		protected org.apache.axis2.databinding.types.UnsignedInt localUnsignedInt;

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.UnsignedInt
		 */
		public org.apache.axis2.databinding.types.UnsignedInt getUnsignedInt() {
			return localUnsignedInt;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UnsignedInt
		 */
		public void setUnsignedInt(org.apache.axis2.databinding.types.UnsignedInt param) {

			this.localUnsignedInt = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "unsignedInt";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":unsignedInt", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "unsignedInt", xmlWriter);
				}
			}

			if (localUnsignedInt == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localUnsignedInt));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localUnsignedInt == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUnsignedInt) },
						null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static UnsignedInt parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UnsignedInt object = new UnsignedInt();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setUnsignedInt(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToUnsignedInt(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class UnsignedLong implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong", "ns1");

		/**
		 * field for UnsignedLong
		 */

		protected org.apache.axis2.databinding.types.UnsignedLong localUnsignedLong;

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.UnsignedLong
		 */
		public org.apache.axis2.databinding.types.UnsignedLong getUnsignedLong() {
			return localUnsignedLong;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UnsignedLong
		 */
		public void setUnsignedLong(org.apache.axis2.databinding.types.UnsignedLong param) {

			this.localUnsignedLong = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "unsignedLong";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":unsignedLong", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "unsignedLong",
							xmlWriter);
				}
			}

			if (localUnsignedLong == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localUnsignedLong));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localUnsignedLong == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUnsignedLong) },
						null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static UnsignedLong parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UnsignedLong object = new UnsignedLong();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setUnsignedLong(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToUnsignedLong(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class AnyType implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "anyType", "ns1");

		/**
		 * field for AnyType
		 */

		protected java.lang.Object localAnyType;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.Object
		 */
		public java.lang.Object getAnyType() {
			return localAnyType;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AnyType
		 */
		public void setAnyType(java.lang.Object param) {

			this.localAnyType = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "anyType";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":anyType", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "anyType", xmlWriter);
				}
			}

			if (localAnyType == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				org.apache.axis2.databinding.utils.ConverterUtil.serializeAnyType(localAnyType, xmlWriter);

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localAnyType == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnyType) }, null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static AnyType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				AnyType object = new AnyType();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "anyType")
											.equals(reader.getName())) {

								object.setAnyType(org.apache.axis2.databinding.utils.ConverterUtil.getAnyTypeObject(
										reader, ExtensionMapper.class));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class CurrencyCodeE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.restfulwebservices.net/DataContracts/2008/01", "CurrencyCode", "ns2");

		/**
		 * field for CurrencyCode
		 */

		protected CurrencyCode localCurrencyCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return CurrencyCode
		 */
		public CurrencyCode getCurrencyCode() {
			return localCurrencyCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CurrencyCode
		 */
		public void setCurrencyCode(CurrencyCode param) {

			this.localCurrencyCode = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localCurrencyCode == null) {
				java.lang.String namespace = "http://www.restfulwebservices.net/DataContracts/2008/01";
				writeStartElement(null, namespace, "CurrencyCode", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				localCurrencyCode.serialize(MY_QNAME, xmlWriter);
			}

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.restfulwebservices.net/DataContracts/2008/01")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localCurrencyCode == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return localCurrencyCode.getPullParser(MY_QNAME);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static CurrencyCodeE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				CurrencyCodeE object = new CurrencyCodeE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://www.restfulwebservices.net/DataContracts/2008/01", "CurrencyCode")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.setCurrencyCode(null);
									reader.next();

								} else {

									object.setCurrencyCode(CurrencyCode.Factory.parse(reader));
								}
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class QName implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "QName", "ns1");

		/**
		 * field for QName
		 */

		protected javax.xml.namespace.QName localQName;

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.xml.namespace.QName
		 */
		public javax.xml.namespace.QName getQName() {
			return localQName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            QName
		 */
		public void setQName(javax.xml.namespace.QName param) {

			this.localQName = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "QName";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":QName", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "QName", xmlWriter);
				}
			}

			if (localQName == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				writeQName(localQName, xmlWriter);

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localQName == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQName) }, null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static QName parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				QName object = new QName();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "QName")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									int index = content.indexOf(":");
									if (index > 0) {
										prefix = content.substring(0, index);
									} else {
										prefix = "";
									}
									namespaceuri = reader.getNamespaceURI(prefix);
									object.setQName(org.apache.axis2.databinding.utils.ConverterUtil.convertToQName(
											content, namespaceuri));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _byte implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "byte", "ns1");

		/**
		 * field for _byte
		 */

		protected byte local_byte;

		/**
		 * Auto generated getter method
		 * 
		 * @return byte
		 */
		public byte get_byte() {
			return local_byte;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _byte
		 */
		public void set_byte(byte param) {

			this.local_byte = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "byte";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":byte", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "byte", xmlWriter);
				}
			}

			if (local_byte == java.lang.Byte.MIN_VALUE) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_byte));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_byte) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _byte parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_byte object = new _byte();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						object.set_byte(java.lang.Byte.MIN_VALUE);

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "byte")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_byte(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToByte(content));

								} else {

									object.set_byte(java.lang.Byte.MIN_VALUE);

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Guid implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "guid", "ns1");

		/**
		 * field for Guid
		 */

		protected java.lang.String localGuid;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getGuid() {
			return localGuid;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Guid
		 */
		public void setGuid(java.lang.String param) {

			if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches(
					"[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}")) {
				this.localGuid = param;
			} else {
				throw new java.lang.RuntimeException();
			}

		}

		public java.lang.String toString() {

			return localGuid.toString();

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String _localName = parentQName.getLocalPart();

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":guid", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "guid", xmlWriter);
				}
			}

			if (localGuid == null) {

				throw new org.apache.axis2.databinding.ADBException("guid cannot be null !!");

			} else {

				xmlWriter.writeCharacters(localGuid);

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGuid) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			public static Guid fromString(java.lang.String value, java.lang.String namespaceURI) {
				Guid returnValue = new Guid();

				returnValue.setGuid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

				return returnValue;
			}

			public static Guid fromString(javax.xml.stream.XMLStreamReader xmlStreamReader, java.lang.String content) {
				if (content.indexOf(":") > -1) {
					java.lang.String prefix = content.substring(0, content.indexOf(":"));
					java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
					return Guid.Factory.fromString(content, namespaceUri);
				} else {
					return Guid.Factory.fromString(content, "");
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Guid parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Guid object = new Guid();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {

							if (reader.isStartElement() || reader.hasText()) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									throw new org.apache.axis2.databinding.ADBException("The element: " + "guid"
											+ "  cannot be null");
								}

								java.lang.String content = reader.getElementText();

								object.setGuid(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(content));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Decimal implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "decimal", "ns1");

		/**
		 * field for Decimal
		 */

		protected java.math.BigDecimal localDecimal;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.math.BigDecimal
		 */
		public java.math.BigDecimal getDecimal() {
			return localDecimal;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Decimal
		 */
		public void setDecimal(java.math.BigDecimal param) {

			this.localDecimal = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "decimal";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":decimal", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "decimal", xmlWriter);
				}
			}

			if (localDecimal == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localDecimal));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localDecimal == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDecimal) }, null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Decimal parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Decimal object = new Decimal();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "decimal")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setDecimal(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToDecimal(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DateTime implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "dateTime", "ns1");

		/**
		 * field for DateTime
		 */

		protected java.util.Calendar localDateTime;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.util.Calendar
		 */
		public java.util.Calendar getDateTime() {
			return localDateTime;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DateTime
		 */
		public void setDateTime(java.util.Calendar param) {

			this.localDateTime = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "dateTime";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":dateTime", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "dateTime", xmlWriter);
				}
			}

			if (localDateTime == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localDateTime));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localDateTime == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateTime) }, null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DateTime parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				DateTime object = new DateTime();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "dateTime")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setDateTime(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToDateTime(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _long implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "long", "ns1");

		/**
		 * field for _long
		 */

		protected long local_long;

		/**
		 * Auto generated getter method
		 * 
		 * @return long
		 */
		public long get_long() {
			return local_long;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _long
		 */
		public void set_long(long param) {

			this.local_long = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "long";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":long", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "long", xmlWriter);
				}
			}

			if (local_long == java.lang.Long.MIN_VALUE) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_long));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_long) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _long parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_long object = new _long();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						object.set_long(java.lang.Long.MIN_VALUE);

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "long")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_long(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToLong(content));

								} else {

									object.set_long(java.lang.Long.MIN_VALUE);

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Currency implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * Currency Namespace URI =
		 * http://www.restfulwebservices.net/DataContracts/2008/01 Namespace
		 * Prefix = ns2
		 */

		/**
		 * field for FromCurrency
		 */

		protected CurrencyCode localFromCurrency;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFromCurrencyTracker = false;

		public boolean isFromCurrencySpecified() {
			return localFromCurrencyTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return CurrencyCode
		 */
		public CurrencyCode getFromCurrency() {
			return localFromCurrency;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FromCurrency
		 */
		public void setFromCurrency(CurrencyCode param) {
			localFromCurrencyTracker = param != null;

			this.localFromCurrency = param;

		}

		/**
		 * field for ToCurrency
		 */

		protected CurrencyCode localToCurrency;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localToCurrencyTracker = false;

		public boolean isToCurrencySpecified() {
			return localToCurrencyTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return CurrencyCode
		 */
		public CurrencyCode getToCurrency() {
			return localToCurrency;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ToCurrency
		 */
		public void setToCurrency(CurrencyCode param) {
			localToCurrencyTracker = param != null;

			this.localToCurrency = param;

		}

		/**
		 * field for Rate
		 */

		protected double localRate;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localRateTracker = false;

		public boolean isRateSpecified() {
			return localRateTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return double
		 */
		public double getRate() {
			return localRate;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Rate
		 */
		public void setRate(double param) {

			// setting primitive attribute tracker to true
			localRateTracker = !java.lang.Double.isNaN(param);

			this.localRate = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
					parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.restfulwebservices.net/DataContracts/2008/01");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":Currency", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Currency", xmlWriter);
				}

			}
			if (localFromCurrencyTracker) {
				if (localFromCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("FromCurrency cannot be null!!");
				}
				localFromCurrency.serialize(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/DataContracts/2008/01", "FromCurrency"), xmlWriter);
			}
			if (localToCurrencyTracker) {
				if (localToCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("ToCurrency cannot be null!!");
				}
				localToCurrency.serialize(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/DataContracts/2008/01", "ToCurrency"), xmlWriter);
			}
			if (localRateTracker) {
				namespace = "http://www.restfulwebservices.net/DataContracts/2008/01";
				writeStartElement(null, namespace, "Rate", xmlWriter);

				if (java.lang.Double.isNaN(localRate)) {

					throw new org.apache.axis2.databinding.ADBException("Rate cannot be null!!");

				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localRate));
				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.restfulwebservices.net/DataContracts/2008/01")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localFromCurrencyTracker) {
				elementList.add(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/DataContracts/2008/01", "FromCurrency"));

				if (localFromCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("FromCurrency cannot be null!!");
				}
				elementList.add(localFromCurrency);
			}
			if (localToCurrencyTracker) {
				elementList.add(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/DataContracts/2008/01", "ToCurrency"));

				if (localToCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("ToCurrency cannot be null!!");
				}
				elementList.add(localToCurrency);
			}
			if (localRateTracker) {
				elementList.add(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/DataContracts/2008/01", "Rate"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRate));
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
					attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Currency parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Currency object = new Currency();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue(
								"http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"Currency".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (Currency) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01",
									"FromCurrency").equals(reader.getName())) {

						object.setFromCurrency(CurrencyCode.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01",
									"ToCurrency").equals(reader.getName())) {

						object.setToCurrency(CurrencyCode.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01",
									"Rate").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "Rate"
									+ "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setRate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setRate(java.lang.Double.NaN);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class ExtensionMapper {

		public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName,
				javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {

			if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) && "guid".equals(typeName)) {

				return Guid.Factory.parse(reader);

			}

			if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI)
					&& "duration".equals(typeName)) {

				return Duration.Factory.parse(reader);

			}

			if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(namespaceURI) && "char".equals(typeName)) {

				return _char.Factory.parse(reader);

			}

			if ("http://www.restfulwebservices.net/DataContracts/2008/01".equals(namespaceURI)
					&& "Currency".equals(typeName)) {

				return Currency.Factory.parse(reader);

			}

			if ("http://www.restfulwebservices.net/DataContracts/2008/01".equals(namespaceURI)
					&& "CurrencyCode".equals(typeName)) {

				return CurrencyCode.Factory.parse(reader);

			}

			if ("http://GOTLServices.FaultContracts/2008/01".equals(namespaceURI)
					&& "DefaultFaultContract".equals(typeName)) {

				return DefaultFaultContract.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class Duration implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "duration", "ns1");

		/**
		 * field for Duration
		 */

		protected org.apache.axis2.databinding.types.Duration localDuration;

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.Duration
		 */
		public org.apache.axis2.databinding.types.Duration getDuration() {
			return localDuration;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Duration
		 */
		public void setDuration(org.apache.axis2.databinding.types.Duration param) {

			if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches(
					"\\-?P(\\d*D)?(T(\\d*H)?(\\d*M)?(\\d*(\\.\\d*)?S)?)?")) {
				this.localDuration = param;
			} else {
				throw new java.lang.RuntimeException();
			}

		}

		public java.lang.String toString() {

			return localDuration.toString();

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String _localName = parentQName.getLocalPart();

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":duration", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "duration", xmlWriter);
				}
			}

			if (localDuration == null) {

				throw new org.apache.axis2.databinding.ADBException("duration cannot be null !!");

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localDuration));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDuration) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			public static Duration fromString(java.lang.String value, java.lang.String namespaceURI) {
				Duration returnValue = new Duration();

				returnValue.setDuration(org.apache.axis2.databinding.utils.ConverterUtil.convertToDuration(value));

				return returnValue;
			}

			public static Duration fromString(javax.xml.stream.XMLStreamReader xmlStreamReader, java.lang.String content) {
				if (content.indexOf(":") > -1) {
					java.lang.String prefix = content.substring(0, content.indexOf(":"));
					java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
					return Duration.Factory.fromString(content, namespaceUri);
				} else {
					return Duration.Factory.fromString(content, "");
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Duration parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Duration object = new Duration();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {

							if (reader.isStartElement() || reader.hasText()) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									throw new org.apache.axis2.databinding.ADBException("The element: " + "duration"
											+ "  cannot be null");
								}

								java.lang.String content = reader.getElementText();

								object.setDuration(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToDuration(content));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DefaultFaultContract implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * DefaultFaultContract Namespace URI =
		 * http://GOTLServices.FaultContracts/2008/01 Namespace Prefix = ns4
		 */

		/**
		 * field for ErrorId
		 */

		protected int localErrorId;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getErrorId() {
			return localErrorId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorId
		 */
		public void setErrorId(int param) {

			this.localErrorId = param;

		}

		/**
		 * field for ErrorMessage
		 */

		protected java.lang.String localErrorMessage;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorMessage() {
			return localErrorMessage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorMessage
		 */
		public void setErrorMessage(java.lang.String param) {

			this.localErrorMessage = param;

		}

		/**
		 * field for CorrelationId
		 */

		protected Guid localCorrelationId;

		/**
		 * Auto generated getter method
		 * 
		 * @return Guid
		 */
		public Guid getCorrelationId() {
			return localCorrelationId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CorrelationId
		 */
		public void setCorrelationId(Guid param) {

			this.localCorrelationId = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
					parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://GOTLServices.FaultContracts/2008/01");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":DefaultFaultContract", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "DefaultFaultContract",
							xmlWriter);
				}

			}

			namespace = "http://GOTLServices.FaultContracts/2008/01";
			writeStartElement(null, namespace, "ErrorId", xmlWriter);

			if (localErrorId == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException("ErrorId cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localErrorId));
			}

			xmlWriter.writeEndElement();

			namespace = "http://GOTLServices.FaultContracts/2008/01";
			writeStartElement(null, namespace, "ErrorMessage", xmlWriter);

			if (localErrorMessage == null) {
				// write the nil attribute

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localErrorMessage);

			}

			xmlWriter.writeEndElement();

			if (localCorrelationId == null) {
				throw new org.apache.axis2.databinding.ADBException("CorrelationId cannot be null!!");
			}
			localCorrelationId.serialize(new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01",
					"CorrelationId"), xmlWriter);

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://GOTLServices.FaultContracts/2008/01")) {
				return "ns4";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01", "ErrorId"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorId));

			elementList
					.add(new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01", "ErrorMessage"));

			elementList.add(localErrorMessage == null ? null : org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localErrorMessage));

			elementList
					.add(new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01", "CorrelationId"));

			if (localCorrelationId == null) {
				throw new org.apache.axis2.databinding.ADBException("CorrelationId cannot be null!!");
			}
			elementList.add(localCorrelationId);

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
					attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DefaultFaultContract parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DefaultFaultContract object = new DefaultFaultContract();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue(
								"http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"DefaultFaultContract".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (DefaultFaultContract) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01", "ErrorId")
									.equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							throw new org.apache.axis2.databinding.ADBException("The element: " + "ErrorId"
									+ "  cannot be null");
						}

						java.lang.String content = reader.getElementText();

						object.setErrorId(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01",
									"ErrorMessage").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setErrorMessage(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(content));

						} else {

							reader.getElementText(); // throw away text nodes if
														// any.
						}

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01",
									"CorrelationId").equals(reader.getName())) {

						object.setCorrelationId(Guid.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _float implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "float", "ns1");

		/**
		 * field for _float
		 */

		protected float local_float;

		/**
		 * Auto generated getter method
		 * 
		 * @return float
		 */
		public float get_float() {
			return local_float;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _float
		 */
		public void set_float(float param) {

			this.local_float = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "float";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":float", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "float", xmlWriter);
				}
			}

			if (java.lang.Float.isNaN(local_float)) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_float));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_float) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _float parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_float object = new _float();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						object.set_float(java.lang.Float.NaN);

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "float")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_float(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToFloat(content));

								} else {

									object.set_float(java.lang.Float.NaN);

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _short implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "short", "ns1");

		/**
		 * field for _short
		 */

		protected short local_short;

		/**
		 * Auto generated getter method
		 * 
		 * @return short
		 */
		public short get_short() {
			return local_short;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _short
		 */
		public void set_short(short param) {

			this.local_short = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "short";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":short", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "short", xmlWriter);
				}
			}

			if (local_short == java.lang.Short.MIN_VALUE) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_short));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_short) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _short parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_short object = new _short();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						object.set_short(java.lang.Short.MIN_VALUE);

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "short")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_short(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToShort(content));

								} else {

									object.set_short(java.lang.Short.MIN_VALUE);

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _charE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "char", "ns1");

		/**
		 * field for _char
		 */

		protected _char local_char;

		/**
		 * Auto generated getter method
		 * 
		 * @return _char
		 */
		public _char get_char() {
			return local_char;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _char
		 */
		public void set_char(_char param) {

			this.local_char = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (local_char == null) {
				java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
				writeStartElement(null, namespace, "char", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				local_char.serialize(MY_QNAME, xmlWriter);
			}

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (local_char == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return local_char.getPullParser(MY_QNAME);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _charE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_charE object = new _charE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "char")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.set_char(null);
									reader.next();

								} else {

									object.set_char(_char.Factory.parse(reader));
								}
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class UnsignedByte implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte", "ns1");

		/**
		 * field for UnsignedByte
		 */

		protected org.apache.axis2.databinding.types.UnsignedByte localUnsignedByte;

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.UnsignedByte
		 */
		public org.apache.axis2.databinding.types.UnsignedByte getUnsignedByte() {
			return localUnsignedByte;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UnsignedByte
		 */
		public void setUnsignedByte(org.apache.axis2.databinding.types.UnsignedByte param) {

			this.localUnsignedByte = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "unsignedByte";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":unsignedByte", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "unsignedByte",
							xmlWriter);
				}
			}

			if (localUnsignedByte == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localUnsignedByte));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localUnsignedByte == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUnsignedByte) },
						null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static UnsignedByte parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UnsignedByte object = new UnsignedByte();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setUnsignedByte(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToUnsignedByte(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class AnyURI implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "anyURI", "ns1");

		/**
		 * field for AnyURI
		 */

		protected org.apache.axis2.databinding.types.URI localAnyURI;

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI
		 */
		public org.apache.axis2.databinding.types.URI getAnyURI() {
			return localAnyURI;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AnyURI
		 */
		public void setAnyURI(org.apache.axis2.databinding.types.URI param) {

			this.localAnyURI = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "anyURI";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":anyURI", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "anyURI", xmlWriter);
				}
			}

			if (localAnyURI == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnyURI));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localAnyURI == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnyURI) }, null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static AnyURI parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				AnyURI object = new AnyURI();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "anyURI")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setAnyURI(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToAnyURI(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Base64Binary implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary", "ns1");

		/**
		 * field for Base64Binary
		 */

		protected javax.activation.DataHandler localBase64Binary;

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.activation.DataHandler
		 */
		public javax.activation.DataHandler getBase64Binary() {
			return localBase64Binary;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Base64Binary
		 */
		public void setBase64Binary(javax.activation.DataHandler param) {

			this.localBase64Binary = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "base64Binary";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":base64Binary", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "base64Binary",
							xmlWriter);
				}
			}

			if (localBase64Binary == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				if (localBase64Binary != null) {
					try {
						org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localBase64Binary,
								null, true);
					} catch (java.io.IOException ex) {
						throw new javax.xml.stream.XMLStreamException("Unable to read data handler for base64Binary",
								ex);
					}
				}

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localBase64Binary == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBase64Binary) },
						null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Base64Binary parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Base64Binary object = new Base64Binary();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.setBase64Binary(null);
									reader.next();
								} else {

									object.setBase64Binary(org.apache.axiom.util.stax.XMLStreamReaderUtils
											.getDataHandlerFromElement(reader));

								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetConversionRate implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.restfulwebservices.net/ServiceContracts/2008/01", "GetConversionRate", "ns3");

		/**
		 * field for FromCurrency
		 */

		protected CurrencyCode localFromCurrency;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFromCurrencyTracker = false;

		public boolean isFromCurrencySpecified() {
			return localFromCurrencyTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return CurrencyCode
		 */
		public CurrencyCode getFromCurrency() {
			return localFromCurrency;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FromCurrency
		 */
		public void setFromCurrency(CurrencyCode param) {
			localFromCurrencyTracker = param != null;

			this.localFromCurrency = param;

		}

		/**
		 * field for ToCurrency
		 */

		protected CurrencyCode localToCurrency;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localToCurrencyTracker = false;

		public boolean isToCurrencySpecified() {
			return localToCurrencyTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return CurrencyCode
		 */
		public CurrencyCode getToCurrency() {
			return localToCurrency;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ToCurrency
		 */
		public void setToCurrency(CurrencyCode param) {
			localToCurrencyTracker = param != null;

			this.localToCurrency = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.restfulwebservices.net/ServiceContracts/2008/01");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":GetConversionRate", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "GetConversionRate",
							xmlWriter);
				}

			}
			if (localFromCurrencyTracker) {
				if (localFromCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("FromCurrency cannot be null!!");
				}
				localFromCurrency.serialize(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/ServiceContracts/2008/01", "FromCurrency"), xmlWriter);
			}
			if (localToCurrencyTracker) {
				if (localToCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("ToCurrency cannot be null!!");
				}
				localToCurrency.serialize(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/ServiceContracts/2008/01", "ToCurrency"), xmlWriter);
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.restfulwebservices.net/ServiceContracts/2008/01")) {
				return "ns3";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localFromCurrencyTracker) {
				elementList.add(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/ServiceContracts/2008/01", "FromCurrency"));

				if (localFromCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("FromCurrency cannot be null!!");
				}
				elementList.add(localFromCurrency);
			}
			if (localToCurrencyTracker) {
				elementList.add(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/ServiceContracts/2008/01", "ToCurrency"));

				if (localToCurrency == null) {
					throw new org.apache.axis2.databinding.ADBException("ToCurrency cannot be null!!");
				}
				elementList.add(localToCurrency);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
					attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GetConversionRate parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetConversionRate object = new GetConversionRate();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue(
								"http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"GetConversionRate".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GetConversionRate) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://www.restfulwebservices.net/ServiceContracts/2008/01", "FromCurrency")
									.equals(reader.getName())) {

						object.setFromCurrency(CurrencyCode.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://www.restfulwebservices.net/ServiceContracts/2008/01", "ToCurrency")
									.equals(reader.getName())) {

						object.setToCurrency(CurrencyCode.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class CurrencyCode implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.restfulwebservices.net/DataContracts/2008/01", "CurrencyCode", "ns2");

		/**
		 * field for CurrencyCode
		 */

		protected java.lang.String localCurrencyCode;

		private static java.util.HashMap _table_ = new java.util.HashMap();

		// Constructor

		protected CurrencyCode(java.lang.String value, boolean isRegisterValue) {
			localCurrencyCode = value;
			if (isRegisterValue) {

				_table_.put(localCurrencyCode, this);

			}

		}

		public static final java.lang.String _AFA = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("AFA");

		public static final java.lang.String _ALL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ALL");

		public static final java.lang.String _DZD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("DZD");

		public static final java.lang.String _ARS = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ARS");

		public static final java.lang.String _AWG = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("AWG");

		public static final java.lang.String _AUD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("AUD");

		public static final java.lang.String _BSD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BSD");

		public static final java.lang.String _BHD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BHD");

		public static final java.lang.String _BDT = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BDT");

		public static final java.lang.String _BBD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BBD");

		public static final java.lang.String _BZD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BZD");

		public static final java.lang.String _BMD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BMD");

		public static final java.lang.String _BTN = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BTN");

		public static final java.lang.String _BOB = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BOB");

		public static final java.lang.String _BWP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BWP");

		public static final java.lang.String _BRL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BRL");

		public static final java.lang.String _GBP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GBP");

		public static final java.lang.String _BND = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BND");

		public static final java.lang.String _BIF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("BIF");

		public static final java.lang.String _XOF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XOF");

		public static final java.lang.String _XAF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XAF");

		public static final java.lang.String _KHR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KHR");

		public static final java.lang.String _CAD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CAD");

		public static final java.lang.String _CVE = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CVE");

		public static final java.lang.String _KYD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KYD");

		public static final java.lang.String _CLP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CLP");

		public static final java.lang.String _CNY = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CNY");

		public static final java.lang.String _COP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("COP");

		public static final java.lang.String _KMF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KMF");

		public static final java.lang.String _CRC = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CRC");

		public static final java.lang.String _HRK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("HRK");

		public static final java.lang.String _CUP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CUP");

		public static final java.lang.String _CYP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CYP");

		public static final java.lang.String _CZK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CZK");

		public static final java.lang.String _DKK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("DKK");

		public static final java.lang.String _DJF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("DJF");

		public static final java.lang.String _DOP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("DOP");

		public static final java.lang.String _XCD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XCD");

		public static final java.lang.String _EGP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("EGP");

		public static final java.lang.String _SVC = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SVC");

		public static final java.lang.String _EEK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("EEK");

		public static final java.lang.String _ETB = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ETB");

		public static final java.lang.String _EUR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("EUR");

		public static final java.lang.String _FKP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("FKP");

		public static final java.lang.String _GMD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GMD");

		public static final java.lang.String _GHC = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GHC");

		public static final java.lang.String _GIP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GIP");

		public static final java.lang.String _XAU = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XAU");

		public static final java.lang.String _GTQ = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GTQ");

		public static final java.lang.String _GNF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GNF");

		public static final java.lang.String _GYD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("GYD");

		public static final java.lang.String _HTG = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("HTG");

		public static final java.lang.String _HNL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("HNL");

		public static final java.lang.String _HKD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("HKD");

		public static final java.lang.String _HUF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("HUF");

		public static final java.lang.String _ISK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ISK");

		public static final java.lang.String _INR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("INR");

		public static final java.lang.String _IDR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("IDR");

		public static final java.lang.String _IQD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("IQD");

		public static final java.lang.String _ILS = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ILS");

		public static final java.lang.String _JMD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("JMD");

		public static final java.lang.String _JPY = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("JPY");

		public static final java.lang.String _JOD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("JOD");

		public static final java.lang.String _KZT = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KZT");

		public static final java.lang.String _KES = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KES");

		public static final java.lang.String _KRW = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KRW");

		public static final java.lang.String _KWD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KWD");

		public static final java.lang.String _LAK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LAK");

		public static final java.lang.String _LVL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LVL");

		public static final java.lang.String _LBP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LBP");

		public static final java.lang.String _LSL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LSL");

		public static final java.lang.String _LRD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LRD");

		public static final java.lang.String _LYD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LYD");

		public static final java.lang.String _LTL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LTL");

		public static final java.lang.String _MOP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MOP");

		public static final java.lang.String _MKD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MKD");

		public static final java.lang.String _MGF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MGF");

		public static final java.lang.String _MWK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MWK");

		public static final java.lang.String _MYR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MYR");

		public static final java.lang.String _MVR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MVR");

		public static final java.lang.String _MTL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MTL");

		public static final java.lang.String _MRO = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MRO");

		public static final java.lang.String _MUR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MUR");

		public static final java.lang.String _MXN = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MXN");

		public static final java.lang.String _MDL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MDL");

		public static final java.lang.String _MNT = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MNT");

		public static final java.lang.String _MAD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MAD");

		public static final java.lang.String _MZM = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MZM");

		public static final java.lang.String _MMK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("MMK");

		public static final java.lang.String _NAD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("NAD");

		public static final java.lang.String _NPR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("NPR");

		public static final java.lang.String _ANG = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ANG");

		public static final java.lang.String _NZD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("NZD");

		public static final java.lang.String _NIO = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("NIO");

		public static final java.lang.String _NGN = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("NGN");

		public static final java.lang.String _KPW = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("KPW");

		public static final java.lang.String _NOK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("NOK");

		public static final java.lang.String _OMR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("OMR");

		public static final java.lang.String _XPF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XPF");

		public static final java.lang.String _PKR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PKR");

		public static final java.lang.String _XPD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XPD");

		public static final java.lang.String _PAB = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PAB");

		public static final java.lang.String _PGK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PGK");

		public static final java.lang.String _PYG = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PYG");

		public static final java.lang.String _PEN = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PEN");

		public static final java.lang.String _PHP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PHP");

		public static final java.lang.String _XPT = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XPT");

		public static final java.lang.String _PLN = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("PLN");

		public static final java.lang.String _QAR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("QAR");

		public static final java.lang.String _ROL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ROL");

		public static final java.lang.String _RUB = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("RUB");

		public static final java.lang.String _WST = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("WST");

		public static final java.lang.String _STD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("STD");

		public static final java.lang.String _SAR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SAR");

		public static final java.lang.String _SCR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SCR");

		public static final java.lang.String _SLL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SLL");

		public static final java.lang.String _XAG = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("XAG");

		public static final java.lang.String _SGD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SGD");

		public static final java.lang.String _SKK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SKK");

		public static final java.lang.String _SIT = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SIT");

		public static final java.lang.String _SBD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SBD");

		public static final java.lang.String _SOS = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SOS");

		public static final java.lang.String _ZAR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ZAR");

		public static final java.lang.String _LKR = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("LKR");

		public static final java.lang.String _SHP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SHP");

		public static final java.lang.String _SDD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SDD");

		public static final java.lang.String _SRG = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SRG");

		public static final java.lang.String _SZL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SZL");

		public static final java.lang.String _SEK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SEK");

		public static final java.lang.String _CHF = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("CHF");

		public static final java.lang.String _SYP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("SYP");

		public static final java.lang.String _TWD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TWD");

		public static final java.lang.String _TZS = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TZS");

		public static final java.lang.String _THB = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("THB");

		public static final java.lang.String _TOP = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TOP");

		public static final java.lang.String _TTD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TTD");

		public static final java.lang.String _TND = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TND");

		public static final java.lang.String _TRL = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TRL");

		public static final java.lang.String _USD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("USD");

		public static final java.lang.String _AED = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("AED");

		public static final java.lang.String _UGX = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("UGX");

		public static final java.lang.String _UAH = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("UAH");

		public static final java.lang.String _UYU = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("UYU");

		public static final java.lang.String _VUV = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("VUV");

		public static final java.lang.String _VEB = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("VEB");

		public static final java.lang.String _VND = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("VND");

		public static final java.lang.String _YER = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("YER");

		public static final java.lang.String _YUM = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("YUM");

		public static final java.lang.String _ZMK = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ZMK");

		public static final java.lang.String _ZWD = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("ZWD");

		public static final java.lang.String _TRY = org.apache.axis2.databinding.utils.ConverterUtil
				.convertToString("TRY");

		public static final CurrencyCode AFA = new CurrencyCode(_AFA, true);

		public static final CurrencyCode ALL = new CurrencyCode(_ALL, true);

		public static final CurrencyCode DZD = new CurrencyCode(_DZD, true);

		public static final CurrencyCode ARS = new CurrencyCode(_ARS, true);

		public static final CurrencyCode AWG = new CurrencyCode(_AWG, true);

		public static final CurrencyCode AUD = new CurrencyCode(_AUD, true);

		public static final CurrencyCode BSD = new CurrencyCode(_BSD, true);

		public static final CurrencyCode BHD = new CurrencyCode(_BHD, true);

		public static final CurrencyCode BDT = new CurrencyCode(_BDT, true);

		public static final CurrencyCode BBD = new CurrencyCode(_BBD, true);

		public static final CurrencyCode BZD = new CurrencyCode(_BZD, true);

		public static final CurrencyCode BMD = new CurrencyCode(_BMD, true);

		public static final CurrencyCode BTN = new CurrencyCode(_BTN, true);

		public static final CurrencyCode BOB = new CurrencyCode(_BOB, true);

		public static final CurrencyCode BWP = new CurrencyCode(_BWP, true);

		public static final CurrencyCode BRL = new CurrencyCode(_BRL, true);

		public static final CurrencyCode GBP = new CurrencyCode(_GBP, true);

		public static final CurrencyCode BND = new CurrencyCode(_BND, true);

		public static final CurrencyCode BIF = new CurrencyCode(_BIF, true);

		public static final CurrencyCode XOF = new CurrencyCode(_XOF, true);

		public static final CurrencyCode XAF = new CurrencyCode(_XAF, true);

		public static final CurrencyCode KHR = new CurrencyCode(_KHR, true);

		public static final CurrencyCode CAD = new CurrencyCode(_CAD, true);

		public static final CurrencyCode CVE = new CurrencyCode(_CVE, true);

		public static final CurrencyCode KYD = new CurrencyCode(_KYD, true);

		public static final CurrencyCode CLP = new CurrencyCode(_CLP, true);

		public static final CurrencyCode CNY = new CurrencyCode(_CNY, true);

		public static final CurrencyCode COP = new CurrencyCode(_COP, true);

		public static final CurrencyCode KMF = new CurrencyCode(_KMF, true);

		public static final CurrencyCode CRC = new CurrencyCode(_CRC, true);

		public static final CurrencyCode HRK = new CurrencyCode(_HRK, true);

		public static final CurrencyCode CUP = new CurrencyCode(_CUP, true);

		public static final CurrencyCode CYP = new CurrencyCode(_CYP, true);

		public static final CurrencyCode CZK = new CurrencyCode(_CZK, true);

		public static final CurrencyCode DKK = new CurrencyCode(_DKK, true);

		public static final CurrencyCode DJF = new CurrencyCode(_DJF, true);

		public static final CurrencyCode DOP = new CurrencyCode(_DOP, true);

		public static final CurrencyCode XCD = new CurrencyCode(_XCD, true);

		public static final CurrencyCode EGP = new CurrencyCode(_EGP, true);

		public static final CurrencyCode SVC = new CurrencyCode(_SVC, true);

		public static final CurrencyCode EEK = new CurrencyCode(_EEK, true);

		public static final CurrencyCode ETB = new CurrencyCode(_ETB, true);

		public static final CurrencyCode EUR = new CurrencyCode(_EUR, true);

		public static final CurrencyCode FKP = new CurrencyCode(_FKP, true);

		public static final CurrencyCode GMD = new CurrencyCode(_GMD, true);

		public static final CurrencyCode GHC = new CurrencyCode(_GHC, true);

		public static final CurrencyCode GIP = new CurrencyCode(_GIP, true);

		public static final CurrencyCode XAU = new CurrencyCode(_XAU, true);

		public static final CurrencyCode GTQ = new CurrencyCode(_GTQ, true);

		public static final CurrencyCode GNF = new CurrencyCode(_GNF, true);

		public static final CurrencyCode GYD = new CurrencyCode(_GYD, true);

		public static final CurrencyCode HTG = new CurrencyCode(_HTG, true);

		public static final CurrencyCode HNL = new CurrencyCode(_HNL, true);

		public static final CurrencyCode HKD = new CurrencyCode(_HKD, true);

		public static final CurrencyCode HUF = new CurrencyCode(_HUF, true);

		public static final CurrencyCode ISK = new CurrencyCode(_ISK, true);

		public static final CurrencyCode INR = new CurrencyCode(_INR, true);

		public static final CurrencyCode IDR = new CurrencyCode(_IDR, true);

		public static final CurrencyCode IQD = new CurrencyCode(_IQD, true);

		public static final CurrencyCode ILS = new CurrencyCode(_ILS, true);

		public static final CurrencyCode JMD = new CurrencyCode(_JMD, true);

		public static final CurrencyCode JPY = new CurrencyCode(_JPY, true);

		public static final CurrencyCode JOD = new CurrencyCode(_JOD, true);

		public static final CurrencyCode KZT = new CurrencyCode(_KZT, true);

		public static final CurrencyCode KES = new CurrencyCode(_KES, true);

		public static final CurrencyCode KRW = new CurrencyCode(_KRW, true);

		public static final CurrencyCode KWD = new CurrencyCode(_KWD, true);

		public static final CurrencyCode LAK = new CurrencyCode(_LAK, true);

		public static final CurrencyCode LVL = new CurrencyCode(_LVL, true);

		public static final CurrencyCode LBP = new CurrencyCode(_LBP, true);

		public static final CurrencyCode LSL = new CurrencyCode(_LSL, true);

		public static final CurrencyCode LRD = new CurrencyCode(_LRD, true);

		public static final CurrencyCode LYD = new CurrencyCode(_LYD, true);

		public static final CurrencyCode LTL = new CurrencyCode(_LTL, true);

		public static final CurrencyCode MOP = new CurrencyCode(_MOP, true);

		public static final CurrencyCode MKD = new CurrencyCode(_MKD, true);

		public static final CurrencyCode MGF = new CurrencyCode(_MGF, true);

		public static final CurrencyCode MWK = new CurrencyCode(_MWK, true);

		public static final CurrencyCode MYR = new CurrencyCode(_MYR, true);

		public static final CurrencyCode MVR = new CurrencyCode(_MVR, true);

		public static final CurrencyCode MTL = new CurrencyCode(_MTL, true);

		public static final CurrencyCode MRO = new CurrencyCode(_MRO, true);

		public static final CurrencyCode MUR = new CurrencyCode(_MUR, true);

		public static final CurrencyCode MXN = new CurrencyCode(_MXN, true);

		public static final CurrencyCode MDL = new CurrencyCode(_MDL, true);

		public static final CurrencyCode MNT = new CurrencyCode(_MNT, true);

		public static final CurrencyCode MAD = new CurrencyCode(_MAD, true);

		public static final CurrencyCode MZM = new CurrencyCode(_MZM, true);

		public static final CurrencyCode MMK = new CurrencyCode(_MMK, true);

		public static final CurrencyCode NAD = new CurrencyCode(_NAD, true);

		public static final CurrencyCode NPR = new CurrencyCode(_NPR, true);

		public static final CurrencyCode ANG = new CurrencyCode(_ANG, true);

		public static final CurrencyCode NZD = new CurrencyCode(_NZD, true);

		public static final CurrencyCode NIO = new CurrencyCode(_NIO, true);

		public static final CurrencyCode NGN = new CurrencyCode(_NGN, true);

		public static final CurrencyCode KPW = new CurrencyCode(_KPW, true);

		public static final CurrencyCode NOK = new CurrencyCode(_NOK, true);

		public static final CurrencyCode OMR = new CurrencyCode(_OMR, true);

		public static final CurrencyCode XPF = new CurrencyCode(_XPF, true);

		public static final CurrencyCode PKR = new CurrencyCode(_PKR, true);

		public static final CurrencyCode XPD = new CurrencyCode(_XPD, true);

		public static final CurrencyCode PAB = new CurrencyCode(_PAB, true);

		public static final CurrencyCode PGK = new CurrencyCode(_PGK, true);

		public static final CurrencyCode PYG = new CurrencyCode(_PYG, true);

		public static final CurrencyCode PEN = new CurrencyCode(_PEN, true);

		public static final CurrencyCode PHP = new CurrencyCode(_PHP, true);

		public static final CurrencyCode XPT = new CurrencyCode(_XPT, true);

		public static final CurrencyCode PLN = new CurrencyCode(_PLN, true);

		public static final CurrencyCode QAR = new CurrencyCode(_QAR, true);

		public static final CurrencyCode ROL = new CurrencyCode(_ROL, true);

		public static final CurrencyCode RUB = new CurrencyCode(_RUB, true);

		public static final CurrencyCode WST = new CurrencyCode(_WST, true);

		public static final CurrencyCode STD = new CurrencyCode(_STD, true);

		public static final CurrencyCode SAR = new CurrencyCode(_SAR, true);

		public static final CurrencyCode SCR = new CurrencyCode(_SCR, true);

		public static final CurrencyCode SLL = new CurrencyCode(_SLL, true);

		public static final CurrencyCode XAG = new CurrencyCode(_XAG, true);

		public static final CurrencyCode SGD = new CurrencyCode(_SGD, true);

		public static final CurrencyCode SKK = new CurrencyCode(_SKK, true);

		public static final CurrencyCode SIT = new CurrencyCode(_SIT, true);

		public static final CurrencyCode SBD = new CurrencyCode(_SBD, true);

		public static final CurrencyCode SOS = new CurrencyCode(_SOS, true);

		public static final CurrencyCode ZAR = new CurrencyCode(_ZAR, true);

		public static final CurrencyCode LKR = new CurrencyCode(_LKR, true);

		public static final CurrencyCode SHP = new CurrencyCode(_SHP, true);

		public static final CurrencyCode SDD = new CurrencyCode(_SDD, true);

		public static final CurrencyCode SRG = new CurrencyCode(_SRG, true);

		public static final CurrencyCode SZL = new CurrencyCode(_SZL, true);

		public static final CurrencyCode SEK = new CurrencyCode(_SEK, true);

		public static final CurrencyCode CHF = new CurrencyCode(_CHF, true);

		public static final CurrencyCode SYP = new CurrencyCode(_SYP, true);

		public static final CurrencyCode TWD = new CurrencyCode(_TWD, true);

		public static final CurrencyCode TZS = new CurrencyCode(_TZS, true);

		public static final CurrencyCode THB = new CurrencyCode(_THB, true);

		public static final CurrencyCode TOP = new CurrencyCode(_TOP, true);

		public static final CurrencyCode TTD = new CurrencyCode(_TTD, true);

		public static final CurrencyCode TND = new CurrencyCode(_TND, true);

		public static final CurrencyCode TRL = new CurrencyCode(_TRL, true);

		public static final CurrencyCode USD = new CurrencyCode(_USD, true);

		public static final CurrencyCode AED = new CurrencyCode(_AED, true);

		public static final CurrencyCode UGX = new CurrencyCode(_UGX, true);

		public static final CurrencyCode UAH = new CurrencyCode(_UAH, true);

		public static final CurrencyCode UYU = new CurrencyCode(_UYU, true);

		public static final CurrencyCode VUV = new CurrencyCode(_VUV, true);

		public static final CurrencyCode VEB = new CurrencyCode(_VEB, true);

		public static final CurrencyCode VND = new CurrencyCode(_VND, true);

		public static final CurrencyCode YER = new CurrencyCode(_YER, true);

		public static final CurrencyCode YUM = new CurrencyCode(_YUM, true);

		public static final CurrencyCode ZMK = new CurrencyCode(_ZMK, true);

		public static final CurrencyCode ZWD = new CurrencyCode(_ZWD, true);

		public static final CurrencyCode TRY = new CurrencyCode(_TRY, true);

		public java.lang.String getValue() {
			return localCurrencyCode;
		}

		public boolean equals(java.lang.Object obj) {
			return (obj == this);
		}

		public int hashCode() {
			return toString().hashCode();
		}

		public java.lang.String toString() {

			return localCurrencyCode.toString();

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String _localName = parentQName.getLocalPart();

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.restfulwebservices.net/DataContracts/2008/01");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":CurrencyCode", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "CurrencyCode",
							xmlWriter);
				}
			}

			if (localCurrencyCode == null) {

				throw new org.apache.axis2.databinding.ADBException("CurrencyCode cannot be null !!");

			} else {

				xmlWriter.writeCharacters(localCurrencyCode);

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.restfulwebservices.net/DataContracts/2008/01")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCurrencyCode) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			public static CurrencyCode fromValue(java.lang.String value) throws java.lang.IllegalArgumentException {
				CurrencyCode enumeration = (CurrencyCode)

				_table_.get(value);

				if ((enumeration == null) && !((value == null) || (value.equals("")))) {
					throw new java.lang.IllegalArgumentException();
				}
				return enumeration;
			}

			public static CurrencyCode fromString(java.lang.String value, java.lang.String namespaceURI)
					throws java.lang.IllegalArgumentException {
				try {

					return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

				} catch (java.lang.Exception e) {
					throw new java.lang.IllegalArgumentException();
				}
			}

			public static CurrencyCode fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
					java.lang.String content) {
				if (content.indexOf(":") > -1) {
					java.lang.String prefix = content.substring(0, content.indexOf(":"));
					java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
					return CurrencyCode.Factory.fromString(content, namespaceUri);
				} else {
					return CurrencyCode.Factory.fromString(content, "");
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static CurrencyCode parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				CurrencyCode object = null;
				// initialize a hash map to keep values
				java.util.Map attributeMap = new java.util.HashMap();
				java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {

							nillableValue = reader
									.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
							if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
								throw new org.apache.axis2.databinding.ADBException("The element: " + "CurrencyCode"
										+ "  cannot be null");
							}

							java.lang.String content = reader.getElementText();

							if (content.indexOf(":") > 0) {
								// this seems to be a Qname so find the
								// namespace and send
								prefix = content.substring(0, content.indexOf(":"));
								namespaceuri = reader.getNamespaceURI(prefix);
								object = CurrencyCode.Factory.fromString(content, namespaceuri);
							} else {
								// this seems to be not a qname send and empty
								// namespace incase of it is
								// check is done in fromString method
								object = CurrencyCode.Factory.fromString(content, "");
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _int implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "int", "ns1");

		/**
		 * field for _int
		 */

		protected int local_int;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int get_int() {
			return local_int;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _int
		 */
		public void set_int(int param) {

			this.local_int = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "int";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
							namespacePrefix + ":int", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "int", xmlWriter);
				}
			}

			if (local_int == java.lang.Integer.MIN_VALUE) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_int));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_int) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _int parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_int object = new _int();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						object.set_int(java.lang.Integer.MIN_VALUE);

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "int").equals(reader
											.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_int(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToInt(content));

								} else {

									object.set_int(java.lang.Integer.MIN_VALUE);

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _char implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "char", "ns1");

		/**
		 * field for _char
		 */

		protected int local_char;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int get_char() {
			return local_char;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _char
		 */
		public void set_char(int param) {

			this.local_char = param;

		}

		public java.lang.String toString() {

			return org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_char);

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String _localName = parentQName.getLocalPart();

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":char", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "char", xmlWriter);
				}
			}

			if (local_char == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException("property value cannot be null!!");

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_char));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_char) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			public static _char fromString(java.lang.String value, java.lang.String namespaceURI) {
				_char returnValue = new _char();

				returnValue.set_char(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(value));

				return returnValue;
			}

			public static _char fromString(javax.xml.stream.XMLStreamReader xmlStreamReader, java.lang.String content) {
				if (content.indexOf(":") > -1) {
					java.lang.String prefix = content.substring(0, content.indexOf(":"));
					java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
					return _char.Factory.fromString(content, namespaceUri);
				} else {
					return _char.Factory.fromString(content, "");
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _char parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_char object = new _char();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {

							if (reader.isStartElement() || reader.hasText()) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									throw new org.apache.axis2.databinding.ADBException("The element: " + "char"
											+ "  cannot be null");
								}

								java.lang.String content = reader.getElementText();

								object.set_char(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DurationE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "duration", "ns1");

		/**
		 * field for Duration
		 */

		protected Duration localDuration;

		/**
		 * Auto generated getter method
		 * 
		 * @return Duration
		 */
		public Duration getDuration() {
			return localDuration;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Duration
		 */
		public void setDuration(Duration param) {

			this.localDuration = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localDuration == null) {
				java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
				writeStartElement(null, namespace, "duration", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				localDuration.serialize(MY_QNAME, xmlWriter);
			}

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localDuration == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return localDuration.getPullParser(MY_QNAME);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DurationE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				DurationE object = new DurationE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "duration")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.setDuration(null);
									reader.next();

								} else {

									object.setDuration(Duration.Factory.parse(reader));
								}
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _double implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "double", "ns1");

		/**
		 * field for _double
		 */

		protected double local_double;

		/**
		 * Auto generated getter method
		 * 
		 * @return double
		 */
		public double get_double() {
			return local_double;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _double
		 */
		public void set_double(double param) {

			this.local_double = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "double";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":double", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "double", xmlWriter);
				}
			}

			if (java.lang.Double.isNaN(local_double)) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(local_double));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_double) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _double parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_double object = new _double();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						object.set_double(java.lang.Double.NaN);

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "double")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_double(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToDouble(content));

								} else {

									object.set_double(java.lang.Double.NaN);

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GuidE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "guid", "ns1");

		/**
		 * field for Guid
		 */

		protected Guid localGuid;

		/**
		 * Auto generated getter method
		 * 
		 * @return Guid
		 */
		public Guid getGuid() {
			return localGuid;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Guid
		 */
		public void setGuid(Guid param) {

			this.localGuid = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localGuid == null) {
				java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
				writeStartElement(null, namespace, "guid", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				localGuid.serialize(MY_QNAME, xmlWriter);
			}

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localGuid == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return localGuid.getPullParser(MY_QNAME);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GuidE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GuidE object = new GuidE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "guid")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.setGuid(null);
									reader.next();

								} else {

									object.setGuid(Guid.Factory.parse(reader));
								}
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class CurrencyE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.restfulwebservices.net/DataContracts/2008/01", "Currency", "ns2");

		/**
		 * field for Currency
		 */

		protected Currency localCurrency;

		/**
		 * Auto generated getter method
		 * 
		 * @return Currency
		 */
		public Currency getCurrency() {
			return localCurrency;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Currency
		 */
		public void setCurrency(Currency param) {

			this.localCurrency = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localCurrency == null) {
				java.lang.String namespace = "http://www.restfulwebservices.net/DataContracts/2008/01";
				writeStartElement(null, namespace, "Currency", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				localCurrency.serialize(MY_QNAME, xmlWriter);
			}

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.restfulwebservices.net/DataContracts/2008/01")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localCurrency == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return localCurrency.getPullParser(MY_QNAME);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static CurrencyE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				CurrencyE object = new CurrencyE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://www.restfulwebservices.net/DataContracts/2008/01", "Currency")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.setCurrency(null);
									reader.next();

								} else {

									object.setCurrency(Currency.Factory.parse(reader));
								}
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DefaultFaultContractE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://GOTLServices.FaultContracts/2008/01", "DefaultFaultContract", "ns4");

		/**
		 * field for DefaultFaultContract
		 */

		protected DefaultFaultContract localDefaultFaultContract;

		/**
		 * Auto generated getter method
		 * 
		 * @return DefaultFaultContract
		 */
		public DefaultFaultContract getDefaultFaultContract() {
			return localDefaultFaultContract;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DefaultFaultContract
		 */
		public void setDefaultFaultContract(DefaultFaultContract param) {

			this.localDefaultFaultContract = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localDefaultFaultContract == null) {
				java.lang.String namespace = "http://GOTLServices.FaultContracts/2008/01";
				writeStartElement(null, namespace, "DefaultFaultContract", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				localDefaultFaultContract.serialize(MY_QNAME, xmlWriter);
			}

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://GOTLServices.FaultContracts/2008/01")) {
				return "ns4";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localDefaultFaultContract == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return localDefaultFaultContract.getPullParser(MY_QNAME);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DefaultFaultContractE parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DefaultFaultContractE object = new DefaultFaultContractE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName("http://GOTLServices.FaultContracts/2008/01",
											"DefaultFaultContract").equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
									object.setDefaultFaultContract(null);
									reader.next();

								} else {

									object.setDefaultFaultContract(DefaultFaultContract.Factory.parse(reader));
								}
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class _boolean implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "boolean", "ns1");

		/**
		 * field for _boolean
		 */

		protected boolean local_boolean;

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean get_boolean() {
			return local_boolean;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _boolean
		 */
		public void set_boolean(boolean param) {

			this.local_boolean = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "boolean";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":boolean", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "boolean", xmlWriter);
				}
			}

			if (false) {

				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(local_boolean));
			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
							org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_boolean) }, null);

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static _boolean parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				_boolean object = new _boolean();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "boolean")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.set_boolean(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToBoolean(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class UnsignedShort implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort", "ns1");

		/**
		 * field for UnsignedShort
		 */

		protected org.apache.axis2.databinding.types.UnsignedShort localUnsignedShort;

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.UnsignedShort
		 */
		public org.apache.axis2.databinding.types.UnsignedShort getUnsignedShort() {
			return localUnsignedShort;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UnsignedShort
		 */
		public void setUnsignedShort(org.apache.axis2.databinding.types.UnsignedShort param) {

			this.localUnsignedShort = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "unsignedShort";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":unsignedShort", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "unsignedShort",
							xmlWriter);
				}
			}

			if (localUnsignedShort == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
						.convertToString(localUnsignedShort));

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localUnsignedShort == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUnsignedShort) },
						null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static UnsignedShort parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UnsignedShort object = new UnsignedShort();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setUnsignedShort(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToUnsignedShort(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class String implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://schemas.microsoft.com/2003/10/Serialization/", "string", "ns1");

		/**
		 * field for String
		 */

		protected java.lang.String localString;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getString() {
			return localString;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            String
		 */
		public void setString(java.lang.String param) {

			this.localString = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			java.lang.String namespace = "http://schemas.microsoft.com/2003/10/Serialization/";
			java.lang.String _localName = "string";

			writeStartElement(null, namespace, _localName, xmlWriter);

			// add the type details if this is used in a simple type
			if (serializeType) {
				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://schemas.microsoft.com/2003/10/Serialization/");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":string", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "string", xmlWriter);
				}
			}

			if (localString == null) {

				// write the nil attribute
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localString);

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://schemas.microsoft.com/2003/10/Serialization/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			// We can safely assume an element has only one type associated with
			// it

			if (localString == null) {
				return new org.apache.axis2.databinding.utils.reader.NullXMLStreamReader(MY_QNAME);
			} else {
				return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
						new java.lang.Object[] {
								org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localString) }, null);
			}

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static String parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				String object = new String();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return object;

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {

							if (reader.isStartElement()
									&& new javax.xml.namespace.QName(
											"http://schemas.microsoft.com/2003/10/Serialization/", "string")
											.equals(reader.getName())) {

								nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
										"nil");
								if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

									java.lang.String content = reader.getElementText();

									object.setString(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(content));

								} else {

									reader.getElementText(); // throw away text
																// nodes if any.
								}

							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
										+ reader.getName());
							}

						} else {
							reader.next();
						}
					} // end of while loop

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetConversionRateResponse implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.restfulwebservices.net/ServiceContracts/2008/01", "GetConversionRateResponse", "ns3");

		/**
		 * field for GetConversionRateResult
		 */

		protected Currency localGetConversionRateResult;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localGetConversionRateResultTracker = false;

		public boolean isGetConversionRateResultSpecified() {
			return localGetConversionRateResultTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return Currency
		 */
		public Currency getGetConversionRateResult() {
			return localGetConversionRateResult;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            GetConversionRateResult
		 */
		public void setGetConversionRateResult(Currency param) {
			localGetConversionRateResultTracker = true;

			this.localGetConversionRateResult = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType) throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.restfulwebservices.net/ServiceContracts/2008/01");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
							+ ":GetConversionRateResponse", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
							"GetConversionRateResponse", xmlWriter);
				}

			}
			if (localGetConversionRateResultTracker) {
				if (localGetConversionRateResult == null) {

					writeStartElement(null, "http://www.restfulwebservices.net/ServiceContracts/2008/01",
							"GetConversionRateResult", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();
				} else {
					localGetConversionRateResult.serialize(new javax.xml.namespace.QName(
							"http://www.restfulwebservices.net/ServiceContracts/2008/01", "GetConversionRateResult"),
							xmlWriter);
				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.restfulwebservices.net/ServiceContracts/2008/01")) {
				return "ns3";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localGetConversionRateResultTracker) {
				elementList.add(new javax.xml.namespace.QName(
						"http://www.restfulwebservices.net/ServiceContracts/2008/01", "GetConversionRateResult"));

				elementList.add(localGetConversionRateResult == null ? null : localGetConversionRateResult);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
					attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GetConversionRateResponse parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				GetConversionRateResponse object = new GetConversionRateResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue(
								"http://www.w3.org/2001/XMLSchema-instance", "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"GetConversionRateResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GetConversionRateResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://www.restfulwebservices.net/ServiceContracts/2008/01",
									"GetConversionRateResult").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							object.setGetConversionRateResult(null);
							reader.next();

							reader.next();

						} else {

							object.setGetConversionRateResult(Currency.Factory.parse(reader));

							reader.next();
						}
					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	private org.apache.axiom.om.OMElement toOM(client.adb.CurrencyServiceStub.GetConversionRate param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(client.adb.CurrencyServiceStub.GetConversionRate.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(client.adb.CurrencyServiceStub.GetConversionRateResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(client.adb.CurrencyServiceStub.GetConversionRateResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(client.adb.CurrencyServiceStub.DefaultFaultContractE param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(client.adb.CurrencyServiceStub.DefaultFaultContractE.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			client.adb.CurrencyServiceStub.CurrencyCode param1, client.adb.CurrencyServiceStub.CurrencyCode param2,
			client.adb.CurrencyServiceStub.GetConversionRate dummyWrappedType, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			client.adb.CurrencyServiceStub.GetConversionRate wrappedType = new client.adb.CurrencyServiceStub.GetConversionRate();

			wrappedType.setFromCurrency(param1);

			wrappedType.setToCurrency(param2);

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(
					wrappedType.getOMElement(client.adb.CurrencyServiceStub.GetConversionRate.MY_QNAME, factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */

	private client.adb.CurrencyServiceStub.Currency getGetConversionRateResponseGetConversionRateResult(
			client.adb.CurrencyServiceStub.GetConversionRateResponse wrappedType) {

		return wrappedType.getGetConversionRateResult();

	}

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type,
			java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

		try {

			if (client.adb.CurrencyServiceStub.GetConversionRate.class.equals(type)) {

				return client.adb.CurrencyServiceStub.GetConversionRate.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

			if (client.adb.CurrencyServiceStub.GetConversionRateResponse.class.equals(type)) {

				return client.adb.CurrencyServiceStub.GetConversionRateResponse.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

			if (client.adb.CurrencyServiceStub.DefaultFaultContractE.class.equals(type)) {

				return client.adb.CurrencyServiceStub.DefaultFaultContractE.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
