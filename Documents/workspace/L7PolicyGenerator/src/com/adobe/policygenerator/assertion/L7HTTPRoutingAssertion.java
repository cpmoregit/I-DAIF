package com.adobe.policygenerator.assertion;

import com.adobe.policy.serviceprovider.authentication.L7Credentials;
import com.adobe.policy.serviceprovider.authentication.L7RequestHeader;
import com.adobe.policy.serviceprovider.authentication.L7ResponseHeaderRules;
import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7HTTPRoutingAssertion implements IL7OBJECT {

	private String protectedServiceURL = "";
	L7Credentials l7Credentials = null;
	L7RequestHeader requestHeader=null;
	L7ResponseHeaderRules responseHeader=null;
	
	public L7HTTPRoutingAssertion(String newProtectedServiceURL, L7Credentials newl7Credentials, L7RequestHeader newRequestHeader, L7ResponseHeaderRules newResponseHeader){
		protectedServiceURL = newProtectedServiceURL;
		l7Credentials = newl7Credentials;
		requestHeader = newRequestHeader;
		responseHeader = newResponseHeader;
	}
	
	@Override
	public String toL7XML() {
	
		StringBuffer httpRoutingAssertion = new StringBuffer();
		
		httpRoutingAssertion.append("<L7p:HttpRoutingAssertion>");
		httpRoutingAssertion.append(l7Credentials.toL7XML());
		httpRoutingAssertion.append("<L7p:ProtectedServiceUrl stringValue=\"");
		httpRoutingAssertion.append(protectedServiceURL);
		httpRoutingAssertion.append("\"/>");
		
		httpRoutingAssertion.append(requestHeader.toL7XML());

	//	httpRoutingAssertion.append(responseHeader.toL7XML());
		
		httpRoutingAssertion.append("<L7p:UseKeepAlives booleanValue=\"false\"/>");
		httpRoutingAssertion.append("</L7p:HttpRoutingAssertion>");
		
		return httpRoutingAssertion.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
