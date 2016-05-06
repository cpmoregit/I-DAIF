package com.adobe.policygenerator.assertion;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adobe.policygenerator.referencedpolicy.L7Util;
import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7EnvironmentAssertionInternal implements IL7OBJECT{
	
	private String environmentID1;
	private String environmentID2;
	private String url;
	private String errorMessage;
	private String commentValue;
	
	public L7EnvironmentAssertionInternal(L7Url l7url){
		environmentID1 = l7url.getEnvironementID();
		url = l7url.getUrl();
		errorMessage = l7url.getErrorMessage();
		commentValue = l7url.getComment();
	}
	
	
	
	public String toL7XML(){
		
		StringBuffer environmentAssertionBuffer = new StringBuffer();
		
		Base64.Encoder base64Encoder = Base64.getEncoder();
		byte[] encodeURL = new byte[500];
		byte[] encodedErrorMessage = new byte[500];
		
		base64Encoder.encode(errorMessage.getBytes(), encodedErrorMessage);
		base64Encoder.encode(url.getBytes(), encodeURL);
		
		environmentAssertionBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		environmentAssertionBuffer.append("<wsp:OneOrMore wsp:Usage=\"Required\">");
	
		environmentAssertionBuffer.append("<L7p:ComparisonAssertion>");
		environmentAssertionBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		environmentAssertionBuffer.append("<L7p:Expression1 stringValue=\"${service.adobe.environment}\"/>");
		environmentAssertionBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		
		environmentAssertionBuffer.append("<L7p:Predicates predicates=\"included\">");
		
		environmentAssertionBuffer.append("<L7p:item dataType=\"included\">");
		environmentAssertionBuffer.append("<L7p:Type variableDataType=\"string\"/>");
		environmentAssertionBuffer.append("</L7p:item>");
		
		environmentAssertionBuffer.append("<L7p:item binary=\"included\">");
		environmentAssertionBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		environmentAssertionBuffer.append("<L7p:RightValue stringValue=\"");
		environmentAssertionBuffer.append(environmentID1);
		environmentAssertionBuffer.append("\"/>");
		environmentAssertionBuffer.append("</L7p:item>");
		
		environmentAssertionBuffer.append("</L7p:Predicates>");
	
		environmentAssertionBuffer.append("</L7p:ComparisonAssertion>");
		
		environmentAssertionBuffer.append("<L7p:ComparisonAssertion>");
		environmentAssertionBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		environmentAssertionBuffer.append("<L7p:Expression1 stringValue=\"${service.adobe.environment}\"/>");
		environmentAssertionBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		
		environmentAssertionBuffer.append("<L7p:Predicates predicates=\"included\">");
		environmentAssertionBuffer.append("<L7p:item dataType=\"included\">");
		environmentAssertionBuffer.append("<L7p:Type variableDataType=\"string\"/>");
		environmentAssertionBuffer.append("</L7p:item>");
		
	/*	environmentAssertionBuffer.append("<L7p:item binary=\"included\">");
		environmentAssertionBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		environmentAssertionBuffer.append("<L7p:RightValue stringValue=\"");
		environmentAssertionBuffer.append(environmentID2);
		environmentAssertionBuffer.append("\"/>");
		environmentAssertionBuffer.append("</L7p:item>");*/
		
		environmentAssertionBuffer.append("</L7p:Predicates>");
		
		environmentAssertionBuffer.append("</L7p:ComparisonAssertion>");
		
		environmentAssertionBuffer.append("</wsp:OneOrMore>");
		
		environmentAssertionBuffer.append("<L7p:SetVariable>");
		environmentAssertionBuffer.append("<L7p:Base64Expression stringValue=\"");
		environmentAssertionBuffer.append(L7Util.cleanXML(new String(encodedErrorMessage)));
		environmentAssertionBuffer.append("\"/>");
		environmentAssertionBuffer.append("<L7p:VariableToSet stringValue=\"error.text\"/>");
		environmentAssertionBuffer.append("</L7p:SetVariable>");
		environmentAssertionBuffer.append("<wsp:OneOrMore wsp:Usage=\"Required\">");
		environmentAssertionBuffer.append("<L7p:Encapsulated>");
		environmentAssertionBuffer.append("<L7p:EncapsulatedAssertionConfigGuid stringValue=\"756a6430-b7fb-443d-a3dd-0be6040871ea\"/>");
		environmentAssertionBuffer.append("<L7p:EncapsulatedAssertionConfigName stringValue=\"Util.Adobe.ValidateTwoWaySSL\"/>");
		environmentAssertionBuffer.append("</L7p:Encapsulated>");
		environmentAssertionBuffer.append("<L7p:Encapsulated>");
		environmentAssertionBuffer.append("<L7p:EncapsulatedAssertionConfigGuid stringValue=\"c88197c6-8623-4ff2-8de5-8773a0d04990\"/>");
		environmentAssertionBuffer.append("<L7p:EncapsulatedAssertionConfigName stringValue=\"Adobe.Security.ServiceToken\"/>");
		environmentAssertionBuffer.append("</L7p:Encapsulated>");
		environmentAssertionBuffer.append("<L7p:assertionComment>");
		environmentAssertionBuffer.append("<L7p:Properties mapValue=\"included\">");
		environmentAssertionBuffer.append("<L7p:entry>");
		environmentAssertionBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		environmentAssertionBuffer.append("<L7p:value stringValue=\"Authenticate\"/>");
		environmentAssertionBuffer.append("</L7p:entry>");
		environmentAssertionBuffer.append("</L7p:Properties>");
		environmentAssertionBuffer.append("</L7p:assertionComment>");
		environmentAssertionBuffer.append("</wsp:OneOrMore>");
		environmentAssertionBuffer.append("<L7p:SetVariable>");
		environmentAssertionBuffer.append("<L7p:Base64Expression stringValue=\"");
		environmentAssertionBuffer.append(L7Util.cleanXML(new String(encodeURL)));
		environmentAssertionBuffer.append("\"/>");
		environmentAssertionBuffer.append("<L7p:VariableToSet stringValue=\"target.url\"/>");
		environmentAssertionBuffer.append("</L7p:SetVariable>");
		environmentAssertionBuffer.append("<L7p:assertionComment>");
		environmentAssertionBuffer.append("<L7p:Properties mapValue=\"included\">");
		environmentAssertionBuffer.append("<L7p:entry>");
		environmentAssertionBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		environmentAssertionBuffer.append("<L7p:value stringValue=\"");
		environmentAssertionBuffer.append(commentValue);
		environmentAssertionBuffer.append("\"/>");
		environmentAssertionBuffer.append("</L7p:entry>");
		environmentAssertionBuffer.append("</L7p:Properties>");
		environmentAssertionBuffer.append("</L7p:assertionComment>");
		environmentAssertionBuffer.append("</wsp:All>");

 
		return environmentAssertionBuffer.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
