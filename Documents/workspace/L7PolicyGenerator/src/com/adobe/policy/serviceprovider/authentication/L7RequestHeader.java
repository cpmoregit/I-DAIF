package com.adobe.policy.serviceprovider.authentication;

import java.util.HashMap;
import java.util.Iterator;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7RequestHeader implements IL7OBJECT{
	
	private static final String REQUEST_HEADER_START = "[Request Header: <L7p:RequestHeaderRules httpPassthroughRuleSet=\"included\">";
	private static final String REQUEST_HEADER_END = "</L7p:RequestHeaderRules>]";
	private static final String HTTP_PASSTHROUGH_RULES_START="<L7p:Rules httpPassthroughRules=\"included\">";
	private static final String HTTP_PASSTHROUGH_RULES_END="</L7p:Rules>";
	
	private HashMap requestHeader = new HashMap();
	private boolean isForwardAll = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void addHeader(String name, String value){
		requestHeader.put(name, value);
	}
	
	public L7RequestHeader(HashMap newRequestHeader, boolean forwardAll){
		requestHeader = newRequestHeader;
		isForwardAll = forwardAll;
	}
	
	private String isForward(){
		if(isForwardAll)
			return "true";
		else
			return "false";
	}

	@Override
	public String toL7XML() {
		StringBuffer requestHeaderBuffer = new StringBuffer();
		
		if(!requestHeader.isEmpty()){
			requestHeaderBuffer.append(REQUEST_HEADER_START);
			requestHeaderBuffer.append("L7p:ForwardAll booleanValue=\"");
			requestHeaderBuffer.append(isForward());
			requestHeaderBuffer.append("\"/>");
			
			requestHeaderBuffer.append(HTTP_PASSTHROUGH_RULES_START);
		
			Iterator iterate = requestHeader.keySet().iterator();
		
			String key = null, value = null;
			while(iterate.hasNext()){
				key = (String)iterate.next();
				value = (String)requestHeader.get(key);
			
				requestHeaderBuffer.append("<L7p:item httpPassthroughRule=\"included\">");
				requestHeaderBuffer.append("<L7p:CustomizeValue stringValue=\"");
				requestHeaderBuffer.append(value);
				requestHeaderBuffer.append("\"/>");
				requestHeaderBuffer.append("<L7p:Name stringValue=\"");
				requestHeaderBuffer.append(key);
				requestHeaderBuffer.append("\"/>");
				requestHeaderBuffer.append("<L7p:UsesCustomizedValue booleanValue=\"true\"/>");
				requestHeaderBuffer.append("</L7p:item>");
			}
		
		requestHeaderBuffer.append(HTTP_PASSTHROUGH_RULES_END);
		requestHeaderBuffer.append(REQUEST_HEADER_END);
		}
		
		return requestHeaderBuffer.toString();
	}

}
