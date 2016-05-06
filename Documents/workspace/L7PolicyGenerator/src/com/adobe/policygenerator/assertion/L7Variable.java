package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7Variable implements IL7OBJECT {

	private String varaibleName;
	private String variableBase64ExpressionValue;
	
	public L7Variable(String newVariableName, String newvariableBase64ExpressionValue ){
		varaibleName = newVariableName;
		variableBase64ExpressionValue = newvariableBase64ExpressionValue;
	}
	
	@Override
	public String toL7XML() {
		StringBuffer varableBuffer = new StringBuffer();
		varableBuffer.append("<L7p:SetVariable>");
		varableBuffer.append("<L7p:Base64Expression stringValue=\"");
		varableBuffer.append(variableBase64ExpressionValue);
		varableBuffer.append("\"/>");
		varableBuffer.append("<L7p:VariableToSet stringValue=\"");
		varableBuffer.append(varaibleName);
		varableBuffer.append("\"/>");
		varableBuffer.append("</L7p:SetVariable>");
		return varableBuffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
