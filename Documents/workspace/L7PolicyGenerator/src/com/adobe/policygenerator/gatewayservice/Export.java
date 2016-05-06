package com.adobe.policygenerator.gatewayservice;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

public class Export {

	public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		
		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		HttpClients.custom().setSSLSocketFactory(sslsf);
		
		CredentialsProvider provider =  new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("ssgconfig", "L7Secure&0@");
		provider.setCredentials(AuthScope.ANY, credentials);
		
		HttpClientBuilder httpClientBuilder = (HttpClientBuilder)HttpClientBuilder.create();
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		
		try {
			HttpResponse response = client.execute(new HttpGet("https://sj1svm065.corp.adobe.com:9443/wsman?wsdl"));
			int statusCode = response.getStatusLine().getStatusCode();
			
			System.out.println("Response Code : " + statusCode);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
