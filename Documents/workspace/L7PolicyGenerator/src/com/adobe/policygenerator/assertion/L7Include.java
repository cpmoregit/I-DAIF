package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.referencedpolicy.L7Util;
import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7Include implements IL7OBJECT {

	private String guid = null;
	
	@Override
	public String toL7XML() {
		StringBuffer l7IncludeBuffer = new StringBuffer();
		l7IncludeBuffer.append("<L7p:Include>");
		l7IncludeBuffer.append("<L7p:PolicyGuid stringValue=\"");
		l7IncludeBuffer.append(L7Util.cleanXML(guid));
		l7IncludeBuffer.append("\"/>");
		l7IncludeBuffer.append("</L7p:Include>");
		
		return l7IncludeBuffer.toString();
	}
	
	public L7Include(String newGuid){
		guid = newGuid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
