package com.adobe.policy.policyGeneration.ipaas.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import com.adobe.policy.exportimport.L7CreatePolicy;
import com.adobe.policy.policyGeneration.L7Service;
import com.adobe.policy.policyGeneration.L7SnapLogicService;
import com.adobe.policy.serviceprovider.authentication.L7Credentials;
import com.adobe.policy.serviceprovider.authentication.L7RequestHeader;
import com.adobe.policy.serviceprovider.authentication.L7ResponseHeaderRules;
import com.adobe.policygenerator.assertion.L7ApiPortalIntegration;
import com.adobe.policygenerator.assertion.L7Comment;
import com.adobe.policygenerator.assertion.L7EncodeDecode;
import com.adobe.policygenerator.assertion.L7EnvironmentAssertionInternal;
import com.adobe.policygenerator.assertion.L7HTTPRoutingAssertion;
import com.adobe.policygenerator.assertion.L7Include;
import com.adobe.policygenerator.assertion.L7LogResponseAssertion;
import com.adobe.policygenerator.assertion.L7SnapLogicHTTPRoutingAssertion;
import com.adobe.policygenerator.assertion.L7SnaplogicToken;
import com.adobe.policygenerator.assertion.L7Url;
import com.adobe.policygenerator.assertion.L7ValidateAPIServicePlanAssertion;
import com.adobe.policygenerator.encapsulatedassertion.internal.L7LogMessage;
import com.adobe.policygenerator.encapsulatedassertion.internal.L7ServiceToken;
import com.adobe.policygenerator.encapsulatedassertion.internal.L7ValidateAPIServicePlan;
import com.adobe.policygenerator.encapsulatedassertion.internal.L7ValidateTwoWaySSL;
import com.adobe.policygenerator.referencedpolicy.JSONPolicy;
import com.adobe.policygenerator.assertion.L7SnaplogicToken;

public class L7GTM_Delta_Load {
	
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
	
	private String headerContextVariableName = "";
	private String headerContextVariableValue = "";
	private String base64EncodeVariableassignVariable = "";
	
	private static  String getEncapsulatedAssertions(){
		
		StringBuffer encapsulatedAssertion = new StringBuffer();
		
		encapsulatedAssertion.append(new L7ValidateTwoWaySSL().toL7XML());
		encapsulatedAssertion.append(new L7ServiceToken().toL7XML());
		encapsulatedAssertion.append(new L7LogMessage().toL7XML());
		encapsulatedAssertion.append(new L7ValidateAPIServicePlan().toL7XML());
		
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
	
	private static final String getServiceDetails(L7SnapLogicService service){
		StringBuffer serviceBuffer = new StringBuffer();
		
		UUID guid = java.util.UUID.randomUUID();
		serviceBuffer.append(XML_HEADER);
		serviceBuffer.append(EXPORT_HEADER_START);
		
		serviceBuffer.append(EXP_REFERENCE_START);
		
		//Import Reference
		serviceBuffer.append(getEncapsulatedAssertions());
		serviceBuffer.append(INCLUDE_POLICY_REFERENCE_START);
		serviceBuffer.append(new JSONPolicy().toL7XML());
		
		serviceBuffer.append(INCLUDE_POLICY_REFERENCE_END);
		serviceBuffer.append(EXP_REFERENCE_END);
		serviceBuffer.append(POLICY_START);
		serviceBuffer.append(ALL_START);
		serviceBuffer.append(ALL_START);
	
		//Documentation
		String[] comments = service.getServiceComment();
		
		int length = comments.length;
		for(int i=0;i<length; i++){
			serviceBuffer.append(new L7Comment(comments[i]).toL7XML());
		}
		
		serviceBuffer.append(ALL_END);
		
		//Set as portal Managed	
		serviceBuffer.append(new L7ApiPortalIntegration(guid.toString()).toL7XML());
		
		//Set as Environment Check	
		serviceBuffer.append(ONE_OR_MORE_REQUIRED_START);	
		serviceBuffer.append((new L7EnvironmentAssertionInternal(service.getDevURL())).toL7XML());
		serviceBuffer.append((new L7EnvironmentAssertionInternal(service.getQaURL())).toL7XML());
		serviceBuffer.append((new L7EnvironmentAssertionInternal(service.getStageURL())).toL7XML());
		serviceBuffer.append((new L7EnvironmentAssertionInternal(service.getProdURL())).toL7XML());
		serviceBuffer.append(ONE_OR_MORE_REQUIRED_END);
		
		//API Key Validation
		serviceBuffer.append(new L7ValidateAPIServicePlanAssertion().toL7XML());

		serviceBuffer.append(ONE_OR_MORE_REQUIRED_START);
		serviceBuffer.append(ALL_START);
			
		// Get Backend Service
		L7Credentials credentials = service.getCredentials();
		L7RequestHeader requestHeader = new L7RequestHeader(service.getRequestHeader(), true);
		L7ResponseHeaderRules responseHeaderRules = new L7ResponseHeaderRules(service.getResponseHeader(), true);
		
		L7SnaplogicToken l7SnaplogicToken = service.getL7SnaplogicToken();
		
		L7EncodeDecode newEncodeDecode = service.getL7EncodeDecode();
		
		serviceBuffer.append((new L7SnapLogicHTTPRoutingAssertion("${target.url}${request.url.path}${request.url.query}", 
				l7SnaplogicToken, 
				newEncodeDecode,
				requestHeader, 
				responseHeaderRules)).toL7XML());
		
    	serviceBuffer.append(new L7LogResponseAssertion("${target.url}${request.url.path}${request.url.query}" + "ResponseStatus","${response.http.status}",1 ,"ResponseStatus").toL7XML());
		serviceBuffer.append(new L7LogResponseAssertion("${target.url}${request.url.path}${request.url.query}" + "Backend Latency","${httpRouting.latency} ms",3 ,"Latency").toL7XML());
		serviceBuffer.append(ALL_END);
		
		serviceBuffer.append(ALL_START);
		serviceBuffer.append(new L7Comment(service.getServiceName() + " Fragment Below").toL7XML());
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
		L7SnapLogicService service = new L7SnapLogicService();
		
		service.setServiceName("GTM - Delta Load");
		
		service.addServiceComment("---------------------------------------");
		service.addServiceComment("- This is Auto Generated Policy for " + service.getServiceName());
		service.addServiceComment("- This is Comment Section------------  ");
		service.addServiceComment("---------------------------------------");
		
		service.setDevURL(new L7Url(L7Url.DEVELOPMENT, "${gateway.partner.adobews.dev}","Authentication Failed", "Dev"));
		service.setProdURL(new L7Url(L7Url.PROD, "${gateway.partner.adobews.prod}","Authentication Failed", "Prod"));
		service.setQaURL(new L7Url(L7Url.QA, "${gateway.partner.adobews.qa}","Authentication Failed", "QA"));
		service.setStageURL(new L7Url(L7Url.STAGE, "${gateway.partner.adobews.stage}","Authentication Failed", "STAGE"));
		
		L7Credentials backendCredentials = new L7Credentials(L7Credentials.NONE);
		service.setCredentials(backendCredentials);
		
		service.setL7SnaplogicToken(new L7SnaplogicToken(
				"snaplogic.authorization.header",
				"JHtnYXRld2F5LmFkb2JlLnNuYXBsb2dpYy5jcm0udXNlcn06JHtzZWNwYXNzLnNuYXBsb2dpY19jcm1fcGFzc3dvcmQucGxhaW50ZXh0fQ==",
				L7SnaplogicToken.BASIC_AUTHORIZATION_TOKEN,
				"Authorization",
				"${snaplogic.authorization.header.encoded}"
				));
		
		service.setL7EncodeDecode(
				new L7EncodeDecode("snaplogic.authorization.header","snaplogic.authorization.header.encoded"));
		
		HashMap requestHeaderMap = new HashMap();
		requestHeaderMap.put("x-adobe-client-id", "servicegateway");
		
		service.setRequestHeader(requestHeaderMap);
		
		HashMap responseHeaderMap = new HashMap();
		service.setResponseHeader(responseHeaderMap);
		
		System.out.println(getServiceDetails(service));
		
		writePolicy("//Users//nex53212//Desktop//gen_policy//gtm-deltaload.xml", getServiceDetails(service));
		L7CreatePolicy.saveToGateway("/gtm/deltaLoad_10", getServiceDetails(service));
		
	}

	public String getHeaderContextVariableName() {
		return headerContextVariableName;
	}

	public void setHeaderContextVariableName(String headerContextVariableName) {
		this.headerContextVariableName = headerContextVariableName;
	}

	public String getHeaderContextVariableValue() {
		return headerContextVariableValue;
	}

	public void setHeaderContextVariableValue(String headerContextVariableValue) {
		this.headerContextVariableValue = headerContextVariableValue;
	}

	public String getBase64EncodeVariableassignVariable() {
		return base64EncodeVariableassignVariable;
	}

	public void setBase64EncodeVariableassignVariable(String base64EncodeVariableassignVariable) {
		this.base64EncodeVariableassignVariable = base64EncodeVariableassignVariable;
	}

}
