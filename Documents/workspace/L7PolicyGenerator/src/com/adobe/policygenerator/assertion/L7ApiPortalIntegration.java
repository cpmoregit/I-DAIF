package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ApiPortalIntegration implements IL7OBJECT{
	
	
	private String guid;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public L7ApiPortalIntegration(String newGuid){
		guid = newGuid;
	}

	@Override
	public String toL7XML() {
		return "<L7p:ApiPortalIntegration><L7p:ApiGroup stringValue=\"\"/><L7p:ApiId stringValue=\""+ guid + "\"/><L7p:PortalManagedApiFlag stringValue=\"L7p:ApiPortalManagedServiceAssertion\"/></L7p:ApiPortalIntegration>";
	}

}
