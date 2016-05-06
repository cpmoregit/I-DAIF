package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7LogResponseAssertion implements IL7OBJECT{
	
	private String errorMessage = null;
	private String errorMessageDetails=null; 
	private int loglevel=1;
	private String source = null;
	
	public L7LogResponseAssertion(String newErrorMessage, String newErrorMessageDetails, int newLoglevel, String newSource){
		errorMessage = newErrorMessage;
		errorMessageDetails = newErrorMessageDetails;
		loglevel = newLoglevel;
		source = newSource;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toL7XML() {
		StringBuffer logBuffer = new StringBuffer();
		
		logBuffer.append("<L7p:Encapsulated>");
		logBuffer.append("<L7p:EncapsulatedAssertionConfigGuid stringValue=\"ef786bf3-1462-4933-bcf3-3b94d1f45062\"/>");
		logBuffer.append("<L7p:EncapsulatedAssertionConfigName stringValue=\"Util.Adobe.LogMessage\"/>");
		logBuffer.append("<L7p:Parameters mapValue=\"included\">");
		logBuffer.append("<L7p:entry>");
		logBuffer.append("<L7p:key stringValue=\"in.ErrorMessage\"/>");
		logBuffer.append("<L7p:value stringValue=\"");
		logBuffer.append(errorMessage);
		logBuffer.append("\"/>");
		logBuffer.append("</L7p:entry>");
		logBuffer.append("<L7p:entry>");
		logBuffer.append("<L7p:key stringValue=\"in.ErrorMessage.Detail\"/>");
		logBuffer.append("<L7p:value stringValue=\"");
		logBuffer.append(errorMessageDetails);
		logBuffer.append("\"/>");
		logBuffer.append("</L7p:entry>");
		logBuffer.append("<L7p:entry>");
		logBuffer.append("<L7p:key stringValue=\"in.logLevel\"/>");
		logBuffer.append("<L7p:value stringValue=\"");
		logBuffer.append(String.valueOf(loglevel));
		logBuffer.append("\"/>");
		logBuffer.append("</L7p:entry>");
		logBuffer.append("<L7p:entry>");
		logBuffer.append("<L7p:key stringValue=\"in.Source\"/>");
		logBuffer.append("<L7p:value stringValue=\"");
		logBuffer.append(source);
		logBuffer.append("\"/>");
		logBuffer.append("</L7p:entry>");
		logBuffer.append("</L7p:Parameters>");
      
		logBuffer.append("</L7p:Encapsulated>");

		
		return logBuffer.toString();
	}

}
