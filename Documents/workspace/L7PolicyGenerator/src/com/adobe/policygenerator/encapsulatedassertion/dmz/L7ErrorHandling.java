package com.adobe.policygenerator.encapsulatedassertion.dmz;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ErrorHandling implements IL7OBJECT {

	@Override
	public String toL7XML() {
		StringBuffer errorHandlingBuffer = new StringBuffer();
		
		errorHandlingBuffer.append("<IncludedPolicyReference RefType=\"com.l7tech.console.policy.exporter.IncludedPolicyReference\" guid=\"6e00a3e8-7215-45b0-84fe-08d12fa6eb87\" included=\"true\" name=\"errorHandling\" soap=\"false\" type=\"INCLUDE_FRAGMENT\">");
		errorHandlingBuffer.append("<wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">");  
		errorHandlingBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		errorHandlingBuffer.append("<L7p:Encapsulated>");
		errorHandlingBuffer.append("<L7p:EncapsulatedAssertionConfigGuid stringValue=\"ef786bf3-1462-4933-bcf3-3b94d1f45062\"/>");
		errorHandlingBuffer.append("<L7p:EncapsulatedAssertionConfigName stringValue=\"Util.Adobe.LogMessage\"/>");
		errorHandlingBuffer.append("<L7p:Parameters mapValue=\"included\">");
		errorHandlingBuffer.append("<L7p:entry>");
		errorHandlingBuffer.append("<L7p:key stringValue=\"in.ErrorMessage\"/>");        
		errorHandlingBuffer.append("<L7p:value stringValue=\"ERROR\"/>");        
		errorHandlingBuffer.append("</L7p:entry>");                      
		errorHandlingBuffer.append("<L7p:entry>");                
		errorHandlingBuffer.append("<L7p:key stringValue=\"in.ErrorMessage.Detail\"/>");
		errorHandlingBuffer.append("<L7p:value stringValue=\"Service Execution FAILED : ${service.errorString}\"/>");
		errorHandlingBuffer.append("</L7p:entry>");
		errorHandlingBuffer.append("<L7p:entry>");
		errorHandlingBuffer.append("<L7p:key stringValue=\"in.logLevel\"/>");
		errorHandlingBuffer.append("<L7p:value stringValue=\"1\"/>");
		errorHandlingBuffer.append("</L7p:entry>");
		errorHandlingBuffer.append("<L7p:entry>");                     
		errorHandlingBuffer.append("<L7p:key stringValue=\"in.Source\"/>");
		errorHandlingBuffer.append("<L7p:value stringValue=\"errorHandling Fragment\"/>");
		errorHandlingBuffer.append("</L7p:entry>");
		errorHandlingBuffer.append("</L7p:entry>");
		errorHandlingBuffer.append("</L7p:Parameters>");
		errorHandlingBuffer.append("</L7p:Encapsulated>");
		errorHandlingBuffer.append("<wsp:OneOrMore wsp:Usage=\"Required\">");
		errorHandlingBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		errorHandlingBuffer.append("<L7p:ComparisonAssertion>");
		errorHandlingBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		errorHandlingBuffer.append("<L7p:Expression1 stringValue=\"${request.http.header.accept}\"/>");
		errorHandlingBuffer.append("<L7p:Expression2 stringValue=\"json\"/>");
		errorHandlingBuffer.append("<L7p:Expression2 stringValue=\"json\"/>");
		errorHandlingBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");
		errorHandlingBuffer.append("<L7p:Predicates predicates=\"included\">");
		errorHandlingBuffer.append("<L7p:item binary=\"included\">");
		errorHandlingBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		errorHandlingBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");
		errorHandlingBuffer.append("<L7p:RightValue stringValue=\"json\"/>");
		errorHandlingBuffer.append("</L7p:item>");
		errorHandlingBuffer.append("</L7p:Predicates>");
		errorHandlingBuffer.append("</L7p:ComparisonAssertion>");
		errorHandlingBuffer.append("<L7p:HardcodedResponse>");
		errorHandlingBuffer.append("<L7p:Base64ResponseBody stringValue=\"eyJlcnJvciI6IiR7c2VydmljZS5lcnJvclN0cmluZ30ifQ==\"/>");
		errorHandlingBuffer.append("<L7p:ResponseContentType stringValue=\"text/json; charset=UTF-8\"/>");
		errorHandlingBuffer.append("<L7p:ResponseStatus stringValue=\"500\"/>");
		errorHandlingBuffer.append("</L7p:HardcodedResponse>");
		errorHandlingBuffer.append("</wsp:All>");
		errorHandlingBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		errorHandlingBuffer.append("<L7p:FaultLevel>");
		errorHandlingBuffer.append("<L7p:LevelInfo soapFaultLevel=\"included\">");
		errorHandlingBuffer.append("<L7p:AlwaysReturnSoapFault booleanValue=\"true\"/>");
		errorHandlingBuffer.append("<L7p:FaultTemplate stringValueReference=\"inline\"><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		errorHandlingBuffer.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		errorHandlingBuffer.append("<soapenv:Body>");
		errorHandlingBuffer.append("<soapenv:Fault>");
		errorHandlingBuffer.append("<faultcode>${service.errorCode}</faultcode>");
		errorHandlingBuffer.append("<faultstring>Policy Falsified</faultstring>");
		errorHandlingBuffer.append("<faultactor>${request.url}</faultactor>");
		errorHandlingBuffer.append("<detail>${service.errorString}</detail>");
		errorHandlingBuffer.append("</soapenv:Fault>");
		errorHandlingBuffer.append("</soapenv:Body>");
		errorHandlingBuffer.append("</soapenv:Envelope>]]></L7p:FaultTemplate>");
		errorHandlingBuffer.append("<L7p:Level intValue=\"1\"/>");
		errorHandlingBuffer.append("</L7p:LevelInfo>");
		errorHandlingBuffer.append("</L7p:FaultLevel>");
		errorHandlingBuffer.append("</wsp:All>");
		errorHandlingBuffer.append("</wsp:OneOrMore>");
		errorHandlingBuffer.append("<L7p:FalseAssertion/>");
		errorHandlingBuffer.append("</wsp:All>");
		errorHandlingBuffer.append("</wsp:Policy>");
		errorHandlingBuffer.append("</IncludedPolicyReference>");
		
		return errorHandlingBuffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
