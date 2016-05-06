package com.adobe.policygenerator.encapsulatedassertion.internal;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ValidateAPIServicePlan implements IL7OBJECT{
	
	private static String VALIDATE_API_SERVICE_PLAN="<EncapsulatedAssertionReference RefType=\"com.l7tech.console.policy.exporter.EncapsulatedAssertionReference\"><Name>util.adobe.validateAPIServicePlan</Name><Guid>fe4d01fa-145c-490f-83ff-2aed4e38a9d3</Guid></EncapsulatedAssertionReference>";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String toL7XML(){
		return VALIDATE_API_SERVICE_PLAN;
	}

}
