package com.adobe.policygenerator.encapsulatedassertion.internal;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ValidateNONEAuthType implements IL7OBJECT{
	
	private static String VALIDATE_NONE_AUTH_TYPE_POLICY="<EncapsulatedAssertionReference RefType=\"com.l7tech.console.policy.exporter.EncapsulatedAssertionReference\"><Name>Adobe.Security.validateNONEAuthType</Name><Guid>890a1133-bbc2-4e5a-9d07-82ea06a3d240</Guid></EncapsulatedAssertionReference>";
	
	public L7ValidateNONEAuthType(){
		
	}
	
	public String toL7XML(){
		return VALIDATE_NONE_AUTH_TYPE_POLICY;
	}
	
}
