package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ValidateAPIServicePlanAssertion  implements IL7OBJECT{
	
	private static final String VALIDATEAPISERVICEPLAN="<wsp:All wsp:Usage=\"Required\"><L7p:Encapsulated><L7p:EncapsulatedAssertionConfigGuid stringValue=\"fe4d01fa-145c-490f-83ff-2aed4e38a9d3\"/><L7p:EncapsulatedAssertionConfigName stringValue=\"util.adobe.validateAPIServicePlan\"/></L7p:Encapsulated><L7p:assertionComment><L7p:Properties mapValue=\"included\"><L7p:entry><L7p:key stringValue=\"RIGHT.COMMENT\"/><L7p:value stringValue=\"Validate API Plans\"/></L7p:entry></L7p:Properties></L7p:assertionComment></wsp:All>";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toL7XML() {
		// TODO Auto-generated method stub
		return VALIDATEAPISERVICEPLAN;
	}

}
