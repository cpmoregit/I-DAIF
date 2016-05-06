package com.adobe.policygenerator.encapsulatedassertion.internal;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ServiceToken implements IL7OBJECT{

	private static String SERVICE_TOKEN_POLICY="<EncapsulatedAssertionReference RefType=\"com.l7tech.console.policy.exporter.EncapsulatedAssertionReference\"><Name>Adobe.Security.ServiceToken</Name><Guid>c88197c6-8623-4ff2-8de5-8773a0d04990</Guid></EncapsulatedAssertionReference>";
	
	public L7ServiceToken(){
		
	}
	
	public String toL7XML(){
		return SERVICE_TOKEN_POLICY;
	}


}
