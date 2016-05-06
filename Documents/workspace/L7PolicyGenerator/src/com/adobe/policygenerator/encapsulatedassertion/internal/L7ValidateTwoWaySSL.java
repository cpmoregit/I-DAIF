package com.adobe.policygenerator.encapsulatedassertion.internal;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ValidateTwoWaySSL implements IL7OBJECT{
	
	private static String VALIDATE_TWO_WAY_SSL_POLICY="<EncapsulatedAssertionReference RefType=\"com.l7tech.console.policy.exporter.EncapsulatedAssertionReference\"><Name>Util.Adobe.ValidateTwoWaySSL</Name><Guid>756a6430-b7fb-443d-a3dd-0be6040871ea</Guid></EncapsulatedAssertionReference>";

	public L7ValidateTwoWaySSL(){
		
	}
	
	public String toL7XML(){
		return VALIDATE_TWO_WAY_SSL_POLICY;
	}
	
}
