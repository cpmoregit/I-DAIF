package com.adobe.policy.serviceprovider.authentication;

import java.util.HashMap;
import java.util.Iterator;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ResponseHeaderRules  implements IL7OBJECT {
	
	private HashMap responseHeader = new HashMap();
	private boolean isForwardAll = false;
	
	private static final String RESPONSE_HEADER_START = "<L7p:ResponseHeaderRules httpPassthroughRuleSet=\"included\">";
	private static final String RESPONSE_HEADER_END = "</L7p:ResponseHeaderRules>";
	
	private static final String HTTP_RESPONSE_HEADER_RULES_START = "<L7p:Rules httpPassthroughRules=\"included\">";
	private static final String HTTP_RESPONSE_HEADER_RULES_END = "</L7p:Rules>";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public L7ResponseHeaderRules(HashMap newResponseHeader, boolean newIsForwardAll){
		responseHeader = newResponseHeader;
		isForwardAll = newIsForwardAll;
	}
	
	private String isForward(){
		if(isForwardAll)
			return "true";
		else
			return "false";
	}

	@Override
	public String toL7XML() {
		StringBuffer responseHeaderBuffer = new StringBuffer();
		
		if(!responseHeader.isEmpty()){
			responseHeaderBuffer.append(RESPONSE_HEADER_START);
			responseHeaderBuffer.append("L7p:ForwardAll booleanValue=\"");
			responseHeaderBuffer.append(isForward());
			responseHeaderBuffer.append("\"/>");
			
			responseHeaderBuffer.append(HTTP_RESPONSE_HEADER_RULES_START);
			
			Iterator iterate = responseHeader.keySet().iterator();
			
			String key = null, value = null;
			while(iterate.hasNext()){
				key = (String)iterate.next();
				value = (String)responseHeader.get(key);
				
				responseHeaderBuffer.append("<L7p:item httpPassthroughRule=\"included\">");
				responseHeaderBuffer.append("<L7p:CustomizeValue stringValue=\"");
				responseHeaderBuffer.append(value);
				responseHeaderBuffer.append("\"/>");
				
				responseHeaderBuffer.append("<L7p:Name stringValue=\"");
				responseHeaderBuffer.append(key);
				responseHeaderBuffer.append("\"/>");
				responseHeaderBuffer.append("<L7p:UsesCustomizedValue booleanValue=\"true\"/>");
				
				responseHeaderBuffer.append("</L7p:item>");
			}
		}
		
		responseHeaderBuffer.append(HTTP_RESPONSE_HEADER_RULES_END);
		
		responseHeaderBuffer.append(RESPONSE_HEADER_END);
		
		return responseHeaderBuffer.toString();
	}

}
