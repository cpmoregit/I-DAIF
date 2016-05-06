package com.adobe.policy.exportimport;

public class L7GatewayConfig {
	
    /**
     * The URL of the Gateway Management Service to connect to.
     */
    private static final String GATEWAY_URL = "https://sj1svm065.corp.adobe.com:9443/wsman";

    /**
     * The credentials for an administrative user with permission to export the
     * private key.
     *
     * Note that export is typically only supported for private keys stored in
     * the software key store.
     */
    private static final String USERNAME = "ssgadm";
    private static final String PASSWORD = "X3@*ZMYkeJMN";
    
    public static final int DEV_ENV = 1;
    public static final int STAGE_ENV = 2;
    public static final int QA_ENV = 3;
    public static final int PROD_ENV = 4;
     
    private int currentEnvironemt = 1;
    
    public L7GatewayConfig(int Environment){
    	currentEnvironemt = Environment;
    }
    
    public String getURL(){
    	return GATEWAY_URL;
    }
    
    public String getUserID(){
    	return USERNAME;
    }
    
    public String getPassword(){
    	return PASSWORD;
    }

}
