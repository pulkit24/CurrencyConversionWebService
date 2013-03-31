
/**
 * ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package client.adb;

public class ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage extends java.lang.Exception{

    private static final long serialVersionUID = 1364689747099L;
    
    private client.adb.CurrencyServiceStub.DefaultFaultContractE faultMessage;

    
        public ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage() {
            super("ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage");
        }

        public ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage(java.lang.String s) {
           super(s);
        }

        public ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ICurrencyService_GetConversionRate_DefaultFaultContractFault_FaultMessage(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(client.adb.CurrencyServiceStub.DefaultFaultContractE msg){
       faultMessage = msg;
    }
    
    public client.adb.CurrencyServiceStub.DefaultFaultContractE getFaultMessage(){
       return faultMessage;
    }
}
    