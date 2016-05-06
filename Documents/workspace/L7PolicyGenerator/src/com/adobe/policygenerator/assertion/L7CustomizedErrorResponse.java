package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7CustomizedErrorResponse implements IL7OBJECT {
	
	private static final String CUSTOMIZED_ERROR_RESPONSE="<L7p:CustomizeErrorResponse><L7p:Content stringValue=\"${service.errorString}\"/><L7p:ContentType stringValue=\"${request.contentType}; charset=UTF-8\"/><L7p:ExtraHeaders nameValuePairArray=\"included\"/><L7p:HttpStatus stringValue=\"${service.errorCode}\"/></L7p:CustomizeErrorResponse>";

	@Override
	public String toL7XML() {
		// TODO Auto-generated method stub
		return CUSTOMIZED_ERROR_RESPONSE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
