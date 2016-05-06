package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7EncodeDecode implements IL7OBJECT {
	
	private String sourceVariableName = "";
	private String targetVariableName = "";
	private boolean isDecode = false;
	
	public L7EncodeDecode(String newSourceVariableName, String newTargetVariableName){
		sourceVariableName = newSourceVariableName;
		targetVariableName = newTargetVariableName;
	}
	
	public L7EncodeDecode(String newSourceVariableName, String newTargetVariableName, boolean newIsDecode){
		sourceVariableName = newSourceVariableName;
		targetVariableName = newTargetVariableName;
		isDecode = newIsDecode;
	}

	@Override
	public String toL7XML() {
		StringBuffer l7EncodeDecodeBuffer = new StringBuffer("");
		
		l7EncodeDecodeBuffer.append("<L7p:EncodeDecode>");
		l7EncodeDecodeBuffer.append("<L7p:SourceVariableName stringValue=\"");
		l7EncodeDecodeBuffer.append(sourceVariableName);
		l7EncodeDecodeBuffer.append("\"/>");
		l7EncodeDecodeBuffer.append("<L7p:TargetDataType variableDataType=\"string\"/>");
		l7EncodeDecodeBuffer.append("<L7p:TargetVariableName stringValue=\"");
		l7EncodeDecodeBuffer.append(targetVariableName);
		l7EncodeDecodeBuffer.append("\"/>");
		
		if(isDecode){
			l7EncodeDecodeBuffer.append("<L7p:TransformType transformType=\"URL_DECODE\"/>");
		}else{
			l7EncodeDecodeBuffer.append("<L7p:TransformType transformType=\"BASE64_ENCODE\"/>");
		}
		l7EncodeDecodeBuffer.append("</L7p:EncodeDecode>");
		
		return l7EncodeDecodeBuffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
