package com.adobe.policy.policyGeneration;

import java.util.HashMap;

import com.adobe.policy.serviceprovider.authentication.L7Credentials;
import com.adobe.policygenerator.assertion.L7Url;

public class L7Service {
	
	private String[] serviceComment = new String[4];
	private int serviceCounter =0;
	
	private L7Url devURL = null;
	private L7Url qaURL = null;
	private L7Url stageURL = null;
	private L7Url prodURL = null;
	
	private L7Credentials credentials = null;
	
	public int CONTENT_TYPE_XML = 1;
	public int CONTENT_TYPE_JSON = 2;
	public int CONTENT_TYPE_QUERY_PARAMETER = 3;
	
	public final static int XML_TO_JSON = 1;
	public final static int JSON_TO_XML = 2;
	
	public int CONTENT_TYPE_NO_REQUEST_CONVERSION = 4;
	public int CONTENT_TYPE_NO_RESPONSE_CONVERSION = 5;
	
	private int requestContentType = CONTENT_TYPE_QUERY_PARAMETER;
	private int responseContentType = CONTENT_TYPE_XML;
	
	public int requestConversionType = CONTENT_TYPE_NO_REQUEST_CONVERSION;
	public int responseConversionType = CONTENT_TYPE_NO_RESPONSE_CONVERSION;
	
	private int contentType = CONTENT_TYPE_QUERY_PARAMETER;
	
	private String serviceName = "";
	
	private HashMap requestHeader = new HashMap();
	private HashMap responseHeader = new HashMap();
	
	
	public void addServiceComment(String comment){
		serviceComment[serviceCounter++] = comment;
	}
	
	public String[] getServiceComment(){
		return serviceComment;
	}

	public static void main(String[] args) {
		

	}

	public L7Url getDevURL() {
		return devURL;
	}

	public void setDevURL(L7Url devURL) {
		this.devURL = devURL;
	}

	public L7Url getQaURL() {
		return qaURL;
	}

	public void setQaURL(L7Url qaURL) {
		this.qaURL = qaURL;
	}

	public L7Url getStageURL() {
		return stageURL;
	}

	public void setStageURL(L7Url stageURL) {
		this.stageURL = stageURL;
	}

	public L7Url getProdURL() {
		return prodURL;
	}

	public void setProdURL(L7Url prodURL) {
		this.prodURL = prodURL;
	}

	public int getRequestConversionType() {
		return requestConversionType;
	}

	public void setRequestConversionType(int requestConversionType) {
		this.requestConversionType = requestConversionType;
	}

	public int getResponseConversionType() {
		return responseConversionType;
	}

	public void setResponseConversionType(int responseConversionType) {
		this.responseConversionType = responseConversionType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public HashMap getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(HashMap requestHeader) {
		this.requestHeader = requestHeader;
	}

	public HashMap getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(HashMap responseHeader) {
		this.responseHeader = responseHeader;
	}

	public L7Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(L7Credentials credentials) {
		this.credentials = credentials;
	}

}
