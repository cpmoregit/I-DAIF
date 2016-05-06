package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7Url implements IL7OBJECT {
	
	// URLs
	private static String PROD_URL =null;
	private static String STAGE_URL =null;
	private static String DEV_URL =null;
	private static String QA_URL =null;
	
	public final static int DEVELOPMENT = 1;
	public final static int QA = 2;
	public final static int STAGE = 3;
	public final static int PROD = 4;
	
	private String url="";	
	private String errorMessage="";
	private String comment="";
	
	private static final String PROD_ENVIRONMENT = "ipaasapi";
	private static final String DEV_ENVIRONMENT = "ipaasapi-dev";
	private static final String STAGE_ENVIRONMENT = "ipaasapi-stage";
	private static final String QA_ENVIRONMENT = "ipaasapi-qa";
	
	private int currentType = DEVELOPMENT;
	
	public L7Url(int envType, String newURL, String newErrorMessage, String newComment){
		currentType = envType;
		url = newURL;
		errorMessage = newErrorMessage;
		comment = newComment;
	}

	@Override
	public String toL7XML() {
		return null;
	}
	
	public String getEnvironementID(){
		String returnValue = DEV_ENVIRONMENT;
		
		switch(currentType){
			case PROD:{
				returnValue = PROD_ENVIRONMENT;
			}break;
			case STAGE:{
				returnValue = STAGE_ENVIRONMENT;
			}break;
			case QA:{
				returnValue = QA_ENVIRONMENT;
			}break;
			case DEVELOPMENT:{
				returnValue = DEV_ENVIRONMENT;
			}break;
			
		}
		
		return returnValue;
	}

	public String getUrl() {
		String returnValue = url;
		
		return returnValue;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
