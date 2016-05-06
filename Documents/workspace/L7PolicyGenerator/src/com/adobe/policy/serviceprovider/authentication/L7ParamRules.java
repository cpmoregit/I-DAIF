package com.adobe.policy.serviceprovider.authentication;

import java.util.HashMap;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ParamRules  implements IL7OBJECT{
	
	private HashMap requestParams = new HashMap();
	private boolean isForwardAll = false;
	
	private static final String REQUEST_PARAM_HEADER_START = "<L7p:RequestParamRules httpPassthroughRuleSet=\"included\">";
	private static final String REQUEST_PARAM_HEADER_END = "</L7p:RequestParamRules>";
	private static final String REQUEST_PARAM_RULES_HEADER_START="<L7p:Rules httpPassthroughRules=\"included\">";
	private static final String REQUEST_PARAM_RULES_HEADER_END="</L7p:Rules>";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String isForward(){
		if(isForwardAll)
			return "true";
		else
			return "false";
	}
	
	public L7ParamRules(HashMap newRequestHeader,boolean forwardAll){
		requestParams = newRequestHeader;
		isForwardAll = forwardAll;
	}

	@Override
	public String toL7XML() {
		StringBuffer paramRulesBuffer = new StringBuffer();
		
		paramRulesBuffer.append(REQUEST_PARAM_HEADER_START);
		paramRulesBuffer.append("<L7p:ForwardAll booleanValue=\"");
		paramRulesBuffer.append(isForward());
		paramRulesBuffer.append("\"/>");
		paramRulesBuffer.append(REQUEST_PARAM_RULES_HEADER_START);
		paramRulesBuffer.append(REQUEST_PARAM_RULES_HEADER_END);
		paramRulesBuffer.append(REQUEST_PARAM_HEADER_END);
		
		return paramRulesBuffer.toString();
	}

}
