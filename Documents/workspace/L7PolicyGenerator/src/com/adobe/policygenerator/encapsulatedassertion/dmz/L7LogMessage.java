package com.adobe.policygenerator.encapsulatedassertion.dmz;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7LogMessage  implements IL7OBJECT{
	
	
	private static String DMZ_LOG_MESSAGE_POLICY="<EncapsulatedAssertionReference RefType=\"com.l7tech.console.policy.exporter.EncapsulatedAssertionReference\"><Name>Util.Adobe.LogMessage</Name><Guid>ef786bf3-1462-4933-bcf3-3b94d1f45062</Guid></EncapsulatedAssertionReference>";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toL7XML() {		
		return DMZ_LOG_MESSAGE_POLICY;
	}

}
