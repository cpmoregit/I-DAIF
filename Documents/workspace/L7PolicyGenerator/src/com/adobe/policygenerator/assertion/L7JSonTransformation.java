package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7JSonTransformation  implements IL7OBJECT{
	
	private String rootTag ="";
	private String target ="";
		
	
	private final static String JSONTRANSFORMATION_XML = "<L7p:JsonTransformation><L7p:RootTagString stringValue=\"\"/><L7p:Target target=\"REQUEST\"/></L7p:JsonTransformation>";
	
	public L7JSonTransformation(String newRootTag, String newTarget){
		rootTag = newRootTag;
		target = newTarget;
	}
	
	public static void main(String[] args) {
		
	}


	@Override
	public String toL7XML() {
		
		StringBuffer l7XMLStringBuffer = new StringBuffer("");
		l7XMLStringBuffer.append("<L7p:JsonTransformation>");
		l7XMLStringBuffer.append("<L7p:RootTagString stringValue=\"");
		l7XMLStringBuffer.append(rootTag);
		l7XMLStringBuffer.append("\"/>");
		l7XMLStringBuffer.append("<L7p:Target target=\"");
		l7XMLStringBuffer.append(target);
		l7XMLStringBuffer.append("\"/>");
		l7XMLStringBuffer.append("</L7p:JsonTransformation>");;
		
		return l7XMLStringBuffer.toString();
	}

}
