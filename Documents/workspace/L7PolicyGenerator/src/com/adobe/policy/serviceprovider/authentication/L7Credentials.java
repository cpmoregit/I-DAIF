package com.adobe.policy.serviceprovider.authentication;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7Credentials implements IL7OBJECT{
	
	public static final String INCLUDE_IMS_TOKEN_POLICY="";
	public static final String INCLUDE_TWO_WAY_SSL_POLICY="";
	
	public static final int IMS_TOKEN = 1;
	public static final int BASIC_AUTH = 2;
	public static final int NONE = 4;
	
	private String user = "";
	private String password = "";
	private String passthroughsoapfault = "";
	private String proxyUserName = "";
	private String proxyPassword = "";
	
	private int authType = NONE;
	
	public L7Credentials(String newUser, String newPassword, String newPassthroughsoapfault, String newProxyUserName, String newProxyPassword){
		user = newUser;
		password = newPassword;
		passthroughsoapfault = newPassthroughsoapfault;
		proxyUserName = newProxyUserName;
		proxyPassword = newProxyPassword;
		authType = BASIC_AUTH;
	}
	
	public L7Credentials(){
		
	}
	
	public L7Credentials(int newAuthType){
		authType = newAuthType;
	}
	
	public String getBasicAuthL7XML(){
		StringBuffer basicAuth = new StringBuffer();
		
		basicAuth.append("<L7p:Login stringValue=\"");
		basicAuth.append(user);
		basicAuth.append("\"/>");
		basicAuth.append("<L7p:PassThroughSoapFaults booleanValue=\"");
		basicAuth.append(passthroughsoapfault);
		basicAuth.append("\"/>");
		basicAuth.append("<L7p:Password stringValue=\"");
		basicAuth.append(password);
		basicAuth.append("\"/>");
		basicAuth.append("<L7p:ProxyPassword stringValueNull=\"");
		basicAuth.append(proxyPassword);
		basicAuth.append("\"/>");
		basicAuth.append("<L7p:ProxyUsername stringValueNull=\"");
		basicAuth.append(proxyUserName);
		basicAuth.append("\"/>");
		
		return basicAuth.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toL7XML() {
		String returnValue = "";
		
		switch(authType){
			case IMS_TOKEN:{
				returnValue ="";
			}break;
			case NONE:
			case BASIC_AUTH:{
				returnValue = getBasicAuthL7XML();
			}break;
		}
		
		return returnValue;
	}

}
