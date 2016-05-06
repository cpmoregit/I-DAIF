package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7APIComparisonTwoExpressionAssertion implements IL7OBJECT {

	private String caseSensitive = "false";
	private String expressionValue1 = "false";		
	private String expressionValue2 = "false";	
	
	public L7APIComparisonTwoExpressionAssertion(String newExpresseionValue1, String newExpressionValue2, String newCaseSensitive) {
		expressionValue1 = newExpresseionValue1;
		expressionValue2 = newExpressionValue2;
		caseSensitive = newCaseSensitive;
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
		
		l7XMLBuffer.append("<L7p:Expression2 stringValue=\"");
		l7XMLBuffer.append(expressionValue2);
		l7XMLBuffer.append("\"/>");
		
		l7XMLBuffer.append("<L7p:Predicates predicates=\"included\">");
		l7XMLBuffer.append("<L7p:item binary=\"included\">");
		l7XMLBuffer.append("<L7p:CaseSensitive booleanValue=\"");
		l7XMLBuffer.append(caseSensitive);
		l7XMLBuffer.append("\"/>");
		l7XMLBuffer.append("<L7p:RightValue stringValue=\"");
		l7XMLBuffer.append(expressionValue2);		
		l7XMLBuffer.append("\"/>");
		l7XMLBuffer.append("</L7p:item>");
		l7XMLBuffer.append("</L7p:Predicates>");
		
		
		return l7XMLBuffer.toString();
	}

}
