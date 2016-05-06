package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ResponseXPathExpression implements IL7OBJECT {
	
	private String variablePrefix = null;
	private String variableName = null;
	private String variableValue = null;
	
	public L7ResponseXPathExpression(String newVariablePrefix, String newVariableName, String newVariableValue){
		variablePrefix = newVariablePrefix;
		variableName = newVariableName;
		variableValue = newVariableValue;
	}

	@Override
	public String toL7XML() {
		StringBuffer l7XMLBuffer = new StringBuffer("");
		l7XMLBuffer.append("<L7p:ResponseXpathAssertion>");
		l7XMLBuffer.append("<L7p:VariablePrefix stringValue=\"");
		l7XMLBuffer.append(variablePrefix);
		l7XMLBuffer.append("\"/>");
		l7XMLBuffer.append("<L7p:XmlMsgSrc stringValue=\"");
		l7XMLBuffer.append(variableName);
		l7XMLBuffer.append("\"/>");
		l7XMLBuffer.append("<L7p:XpathExpression xpathExpressionValue=\"included\">");
		l7XMLBuffer.append("<L7p:Expression stringValue=\"");
		l7XMLBuffer.append(variableValue);
		l7XMLBuffer.append("\"/>");
		l7XMLBuffer.append("<L7p:Namespaces mapValue=\"included\">");
		l7XMLBuffer.append("<L7p:entry>");
		l7XMLBuffer.append("<L7p:key stringValue=\"s\"/>");
		l7XMLBuffer.append("<L7p:value stringValue=\"http://schemas.xmlsoap.org/soap/envelope/\"/>");
		l7XMLBuffer.append("</L7p:entry>");
		l7XMLBuffer.append("</L7p:Namespaces>");
		l7XMLBuffer.append("</L7p:XpathExpression>");
		l7XMLBuffer.append("</L7p:ResponseXpathAssertion>");
		return l7XMLBuffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
