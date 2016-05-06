package com.adobe.policygenerator.service.L7JSonPassThroughService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import com.adobe.policygenerator.assertion.L7ApiPortalIntegration;
import com.adobe.policygenerator.assertion.L7Comment;
import com.adobe.policygenerator.assertion.L7EnvironmentAssertionDMZ;
import com.adobe.policygenerator.assertion.L7EnvironmentAssertionInternal;
import com.adobe.policygenerator.assertion.L7HTTPRoutingAssertion;
import com.adobe.policygenerator.assertion.L7Include;
import com.adobe.policygenerator.assertion.L7LogResponseAssertion;
import com.adobe.policygenerator.assertion.L7ValidateAPIServicePlanAssertion;
import com.adobe.policygenerator.encapsulatedassertion.dmz.L7LogMessage;
//import com.adobe.policygenerator.encapsulatedassertion.dmz.L7ServiceToken;
//import com.adobe.policygenerator.encapsulatedassertion.dmz.L7ValidateAPIServicePlan;
import com.adobe.policygenerator.encapsulatedassertion.dmz.L7ValidateIMSToken;
import com.adobe.policygenerator.encapsulatedassertion.dmz.L7ValidateNONEAuthType;
import com.adobe.policygenerator.encapsulatedassertion.dmz.L7ValidateTwoWaySSL;
import com.adobe.policygenerator.encapsulatedassertion.dmz.L7ServiceToken;
import com.adobe.policygenerator.referencedpolicy.JSONPolicy;

public class L7DMZ {
	
	private static String XML_HEADER="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private static String EXPORT_HEADER_START="<exp:Export Version=\"3.0\" xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:exp=\"http://www.layer7tech.com/ws/policy/export\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">";
	private static String EXPORT_HEADER_END="</exp:Export>";
	
	private static String INCLUDE_POLICY_REFERENCE_START="<IncludedPolicyReference RefType=\"com.l7tech.console.policy.exporter.IncludedPolicyReference\" guid=\"6e00a3e8-7215-45b0-84fe-08d12fa6eb87\" included=\"true\" name=\"errorHandling\" soap=\"false\" type=\"INCLUDE_FRAGMENT\">";
	private static String INCLUDE_POLICY_REFERENCE_END=" </IncludedPolicyReference>";
	
	private static final String AUTHENTICATION_TYPE = "authenticationtype";
	private static final String TWO_WAY_SSL_AUTH_TYPE="twowayssl";
	private static final String NONE_SSL_AUTH_TYPE="noneauthtypes";
	private static final String SERVICE_TOKEN_AUTH_TYPE="servicetoken";
	
	private static final String EXP_REFERENCE_START="<exp:References>";
	private static final String EXP_REFERENCE_END="</exp:References>";
	
	private static final String POLICY_START="<wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">";
	private static final String POLICY_END="</wsp:Policy>";
	
	private static final String ALL_START ="<wsp:All wsp:Usage=\"Required\">";
	private static final String ALL_END ="</wsp:All>";
	
	private static final String ONE_OR_MORE_REQUIRED_START="<wsp:OneOrMore wsp:Usage=\"Required\">";
	private static final String ONE_OR_MORE_REQUIRED_END="</wsp:OneOrMore>";
		
	private static  String getComment(String message){
		return (new L7Comment(message)).toL7XML();
	}
	
	private static final String getIncludedSOAPPolicyReference(){
		StringBuffer soapPolicyReferenceBuffer = new StringBuffer();

		return soapPolicyReferenceBuffer.toString();
	}
	
	private static  String getEncapsulatedAssertionsForSAPRestServices(){
		
		StringBuffer encapsulatedAssertion = new StringBuffer();
		
		encapsulatedAssertion.append(new L7ValidateTwoWaySSL().toL7XML());
		encapsulatedAssertion.append(new L7ServiceToken().toL7XML());
		encapsulatedAssertion.append(new L7LogMessage().toL7XML());
		
		return encapsulatedAssertion.toString();
	}
	
	private static final void writePolicy(String policyName, String policyData){
		FileWriter fw;
		        try {
		            fw = new FileWriter(new File(policyName));
		            fw.write(policyData);
		            fw.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
	}
	
	private static final String getServiceDetails(HashMap serviceDetails){
		StringBuffer serviceBuffer = new StringBuffer();
		
		UUID guid = java.util.UUID.randomUUID();
		serviceBuffer.append(XML_HEADER);
		serviceBuffer.append(EXPORT_HEADER_START);
		
		serviceBuffer.append(EXP_REFERENCE_START);
		
		//Import Reference
		serviceBuffer.append(getEncapsulatedAssertionsForSAPRestServices());
		serviceBuffer.append(INCLUDE_POLICY_REFERENCE_START);
		serviceBuffer.append(new JSONPolicy().toL7XML());
		
		serviceBuffer.append(INCLUDE_POLICY_REFERENCE_END);
		serviceBuffer.append(EXP_REFERENCE_END);
		
		serviceBuffer.append(POLICY_START);
		serviceBuffer.append(ALL_START);
		serviceBuffer.append(ALL_START);
		
		serviceBuffer.append(new L7Comment("---------------------------------------").toL7XML());
		serviceBuffer.append(new L7Comment("- This is Auto Generated Policy demo for DMZ").toL7XML());
		serviceBuffer.append(new L7Comment("- This is Comment Section").toL7XML());
		serviceBuffer.append(new L7Comment("---------------------------------------").toL7XML());
		
		serviceBuffer.append(ALL_END);
		
		serviceBuffer.append(ONE_OR_MORE_REQUIRED_START);	
	//	serviceBuffer.append(new L7EnvironmentAssertionDMZ("ipaasapi", "apisg", "${gateway.adobe.sg.internal.prod}/sap/bc/zservice","Authentication Failed", "Prod").toL7XML());
	//	serviceBuffer.append(new L7EnvironmentAssertionDMZ("ipaasapi-stage", "s2api", "${gateway.adobe.sg.internal.s2}/sap/bc/zservice","Authentication Failed", "stage").toL7XML());
	//	serviceBuffer.append(new L7EnvironmentAssertionDMZ("ipaasapi-qa", "s4api",  "${gateway.adobe.sg.internal.s4}/sap/bc/zservice","Authentication Failed", "qa").toL7XML());
	//	serviceBuffer.append(new L7EnvironmentAssertionDMZ("ipaasapi-dev", "d4api",  "${gateway.adobe.sg.internal.d4}/sap/bc/zservice","Authentication Failed", "Dev").toL7XML());
		serviceBuffer.append(ONE_OR_MORE_REQUIRED_END);
		
		serviceBuffer.append(new L7ValidateIMSToken().toL7XML());
		
		serviceBuffer.append(ONE_OR_MORE_REQUIRED_START);
		serviceBuffer.append(ALL_START);
	//	serviceBuffer.append(new L7HTTPRoutingAssertion().toL7XML());
    	serviceBuffer.append(new L7LogResponseAssertion("Self Service Cancellation ResponseStatus","${response.http.status}",1 ,"ResponseStatus").toL7XML());
		serviceBuffer.append(new L7LogResponseAssertion("Self Service Cancellation Backend Latency","${httpRouting.latency} ms",3 ,"Latency").toL7XML());
		
		serviceBuffer.append(ALL_END);
		
		serviceBuffer.append(ALL_START);
		serviceBuffer.append(new L7Comment("Call Common Error handling Fragment Below").toL7XML());
		serviceBuffer.append(new L7LogResponseAssertion("Error","Unable to invoke ${target.url}",1 ,"Error").toL7XML());
		serviceBuffer.append(new L7Include("6e00a3e8-7215-45b0-84fe-08d12fa6eb87").toL7XML());
		serviceBuffer.append(ALL_END);
		
		serviceBuffer.append(ONE_OR_MORE_REQUIRED_END);
		
		
		serviceBuffer.append(ALL_END);
		serviceBuffer.append(POLICY_END);
		
		
		serviceBuffer.append(EXPORT_HEADER_END);
			
		return serviceBuffer.toString(); 
	}

	public static void main(String[] args) {
		
		HashMap<String, String> serviceDetails = new HashMap();
		
		writePolicy("/Users/nex53212/Desktop/gen_policy/logCPPolicy123_DMZ.xml", getServiceDetails(serviceDetails));

	}

}