package com.adobe.policygenerator.referencedpolicy;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class JSONPolicy implements IL7OBJECT{
	
	public String getPolicy(){
		StringBuffer soapPolicyBuffer = new StringBuffer();
		
		soapPolicyBuffer.append("<wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">");
		soapPolicyBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		soapPolicyBuffer.append("<L7p:AuditDetailAssertion>");
		soapPolicyBuffer.append("<L7p:Detail stringValue=\"Service Execution FAILED : ${service.errorString}\"/>");
		soapPolicyBuffer.append("<L7p:Level stringValue=\"WARNING\"/>");
		soapPolicyBuffer.append("</L7p:AuditDetailAssertion>");
		soapPolicyBuffer.append("<wsp:OneOrMore wsp:Usage=\"Required\">");
		soapPolicyBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		soapPolicyBuffer.append("<L7p:ComparisonAssertion>");
		soapPolicyBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		soapPolicyBuffer.append("<L7p:Expression1 stringValue=\"${request.http.header.accept}\"/>");
		soapPolicyBuffer.append("<L7p:Expression2 stringValue=\"json\"/>");
		soapPolicyBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");
		soapPolicyBuffer.append("<L7p:Predicates predicates=\"included\">");
		soapPolicyBuffer.append("<L7p:item binary=\"included\">");
		soapPolicyBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		soapPolicyBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");
		soapPolicyBuffer.append("<L7p:RightValue stringValue=\"json\"/>");
		soapPolicyBuffer.append("</L7p:item>");
		soapPolicyBuffer.append("</L7p:Predicates>");
		soapPolicyBuffer.append("</L7p:ComparisonAssertion>");
		soapPolicyBuffer.append("<L7p:HardcodedResponse>");
		soapPolicyBuffer.append("<L7p:Base64ResponseBody stringValue=\"eyJlcnJvciI6IiR7c2VydmljZS5lcnJvclN0cmluZ30ifQ==\"/>");
		soapPolicyBuffer.append("<L7p:ResponseContentType stringValue=\"text/json; charset=UTF-8\"/>");
		soapPolicyBuffer.append("<L7p:ResponseStatus stringValue=\"500\"/>");
		soapPolicyBuffer.append("</L7p:HardcodedResponse>");
		soapPolicyBuffer.append("</wsp:All>");
		soapPolicyBuffer.append("</wsp:OneOrMore>");
		soapPolicyBuffer.append("<L7p:FalseAssertion/>");
		soapPolicyBuffer.append("</wsp:All>");
		soapPolicyBuffer.append("</wsp:Policy>");

		
		return soapPolicyBuffer.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toL7XML(){
		return new JSONPolicy().getPolicy();
	}

}
