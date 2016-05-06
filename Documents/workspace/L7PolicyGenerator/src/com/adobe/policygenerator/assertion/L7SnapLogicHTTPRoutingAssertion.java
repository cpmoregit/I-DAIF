package com.adobe.policygenerator.assertion;

import com.adobe.policy.serviceprovider.authentication.L7Credentials;
import com.adobe.policy.serviceprovider.authentication.L7RequestHeader;
import com.adobe.policy.serviceprovider.authentication.L7ResponseHeaderRules;
import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7SnapLogicHTTPRoutingAssertion implements IL7OBJECT {

	private String protectedServiceURL = "";
	L7Credentials l7Credentials = null;
	L7RequestHeader requestHeader=null;
	L7ResponseHeaderRules responseHeader=null;
	L7SnaplogicToken snaplogicToken = null;
	L7EncodeDecode encodeDecode= null;
	
	public L7SnapLogicHTTPRoutingAssertion(String newProtectedServiceURL, L7SnaplogicToken newSnaplogicToken,L7EncodeDecode newEncodeDecode, L7RequestHeader newRequestHeader, L7ResponseHeaderRules newResponseHeader){
	
		l7Credentials = new L7Credentials();
		protectedServiceURL = newProtectedServiceURL;
		snaplogicToken = newSnaplogicToken;
		encodeDecode = newEncodeDecode;
		requestHeader = newRequestHeader;
		responseHeader = newResponseHeader;
		
	}
	
	@Override
	public String toL7XML() {
	
		StringBuffer httpRoutingAssertion = new StringBuffer();
		
		httpRoutingAssertion.append(snaplogicToken.toL7XML());
		if(encodeDecode!=null)
			httpRoutingAssertion.append(encodeDecode.toL7XML());
		
		httpRoutingAssertion.append("<L7p:HttpRoutingAssertion>");
		httpRoutingAssertion.append(l7Credentials.toL7XML());
		httpRoutingAssertion.append("<L7p:ProtectedServiceUrl stringValue=\"");
		httpRoutingAssertion.append(protectedServiceURL);
		httpRoutingAssertion.append("\"/>");
		
		requestHeader.addHeader(snaplogicToken.getAuthorizationTokenName(),  snaplogicToken.getAuthorizationTokenValues());
		httpRoutingAssertion.append(requestHeader.toL7XML());
		
		
		httpRoutingAssertion.append("<L7p:UseKeepAlives booleanValue=\"false\"/>");
		httpRoutingAssertion.append("</L7p:HttpRoutingAssertion>");
		
		return httpRoutingAssertion.toString();
	}

	public static void main(String[] args) {
	

	}

}
