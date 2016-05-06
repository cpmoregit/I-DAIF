package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7RegularExpression implements IL7OBJECT {
	
	private String regularExpressionValue ="";
	private String regularExpressionName ="";
	private String replace ="";
	private String replaceRepeatCount="";
	private String replacementValue="";
	private String target="";
	private String otherTargetMessageVariable="";

	public L7RegularExpression(
			String newRegularExpressionValue, String newRegularExpressionName, 
			String newReplace, String newReplaceRepeatCount, 
			String newReplacementValue, String newTarget, String newOtherTargetMessageVariable)
	{
		regularExpressionValue = newRegularExpressionValue;
		regularExpressionName = newRegularExpressionName;
		replace = newReplace;
		replaceRepeatCount  = newReplaceRepeatCount;
		replacementValue = newReplacementValue;
		target = newTarget;
		otherTargetMessageVariable = newOtherTargetMessageVariable;
	}
	@Override
	public String toL7XML() {
		
		StringBuffer l7RegularExpression = new StringBuffer("");
		l7RegularExpression.append("<L7p:Regex>");
		l7RegularExpression.append("<L7p:AutoTarget booleanValue=\"false\"/>");
		l7RegularExpression.append("<L7p:CaseInsensitive booleanValue=\"true\"/>");
		l7RegularExpression.append("<L7p:OtherTargetMessageVariable stringValue=\"");
		l7RegularExpression.append(otherTargetMessageVariable);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("<L7p:Regex stringValue=\"");
		l7RegularExpression.append(regularExpressionValue);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("<L7p:RegexName stringValue=\"");
		l7RegularExpression.append(regularExpressionName);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("<L7p:Replace booleanValue=\"");
		l7RegularExpression.append(replace);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("<L7p:ReplaceRepeatCount intValue=\"");
		l7RegularExpression.append(replaceRepeatCount);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("<L7p:Replacement stringValue=\"");
		l7RegularExpression.append(replacementValue);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("<L7p:Target target=\"");
		l7RegularExpression.append(target);
		l7RegularExpression.append("\"/>");
		l7RegularExpression.append("</L7p:Regex>");
		return l7RegularExpression.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
