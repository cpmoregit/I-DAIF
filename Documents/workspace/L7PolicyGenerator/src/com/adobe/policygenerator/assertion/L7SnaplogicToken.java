package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7SnaplogicToken implements IL7OBJECT {

	public static String SIMPLE_AUTHORIZATION_TOKEN ="";
	public static String BASIC_AUTHORIZATION_TOKEN ="Basic ";
	public static String BEARER_AUTHORIZATION_TOKEN ="Bearer ";
	
	private String authorizationTokenType ="";
	private String headerContextVariableName = "";
	private String headerContextVariableValue = "";
	private String authTokenValue = "";
	private String authTokenName = "";
	private String authTokenType = SIMPLE_AUTHORIZATION_TOKEN;
	
	
	public L7SnaplogicToken(String headerVariableName, String headerVariableValue, String newAuthTokenType, String newAuthTokenName, String newAuthTokenValue){
		headerContextVariableName = headerVariableName;
		headerContextVariableValue = headerVariableValue;
		authTokenType = newAuthTokenType;
		authTokenName = newAuthTokenName;
		authTokenValue = newAuthTokenValue;
	}
	
	public String getAuthorizationTokenName(){
		return authTokenName;
	}
	
	public String getAuthorizationTokenValues(){
		return authTokenValue;
	}
	
	@Override
	public String toL7XML() {
		StringBuffer snaplogicBearerTokenBuffer = new StringBuffer("");
		
		snaplogicBearerTokenBuffer.append((new L7Variable(headerContextVariableName,headerContextVariableValue)).toL7XML());
		
		return snaplogicBearerTokenBuffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
