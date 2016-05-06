package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7APIComparisonRegularExpressionAssertion implements IL7OBJECT {

	private String caseSensitive = "false";
	private String expressionValue1 = "false";		
	private String pattern = "false";	
	
	public L7APIComparisonRegularExpressionAssertion(String newCaseSensitive, String newExpressionValue1, String newPattern){
		caseSensitive = newCaseSensitive;
		expressionValue1 = newExpressionValue1;
		pattern = newPattern;
	}
		
	@Override
	public String toL7XML() {
		
		
		StringBuffer l7XMLBuffer = new StringBuffer("");
		l7XMLBuffer.append("<L7p:CaseSensitive booleanValue=\"");
		l7XMLBuffer.append(caseSensitive);
		l7XMLBuffer.append("\"/>");
		
		l7XMLBuffer.append("<L7p:Expression1 stringValue=\"");
		l7XMLBuffer.append(expressionValue1);
		l7XMLBuffer.append("\"/>");
		
		l7XMLBuffer.append("<L7p:Predicates predicates=\"included\">");
		l7XMLBuffer.append("<L7p:item regex=\"included\">");
		l7XMLBuffer.append("<L7p:Pattern stringValue=\"");
		l7XMLBuffer.append(pattern);
		l7XMLBuffer.append("\"/>");
		l7XMLBuffer.append("</L7p:item>");
		l7XMLBuffer.append("</L7p:Predicates>");
		
		
		return l7XMLBuffer.toString();
	}

}
