package com.adobe.policy.exportimport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.l7tech.gateway.api.Accessor;
import com.l7tech.gateway.api.Client;
import com.l7tech.gateway.api.ClientFactory;
import com.l7tech.gateway.api.ManagedObjectFactory;
import com.l7tech.gateway.api.PolicyDetail;
import com.l7tech.gateway.api.Resource;
import com.l7tech.gateway.api.ResourceSet;
import com.l7tech.gateway.api.ServiceDetail;
import com.l7tech.gateway.api.ServiceMO;
import com.l7tech.gateway.api.ServiceMOAccessor;
import com.l7tech.gateway.api.ServiceDetail.HttpMapping;
import com.l7tech.gateway.api.ServiceDetail.SoapMapping;

public class L7PolicyImport {
	
	public static String getServiceXML(String fileName){
		StringBuffer xmlBuffer = new StringBuffer();
	    String line;
	 
	    // wrap a BufferedReader around FileReader
		try {
			  BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			  
			  // use the readLine method of the BufferedReader to read one line at a time.
			  // the readLine method returns null when there is nothing else to read.
			  while ((line = bufferedReader.readLine()) != null)
			  {
				  xmlBuffer.append(line);
			  }
	    
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
	    return xmlBuffer.toString();
	}

	public static void main(String[] args) {
		final ClientFactory factory = ClientFactory.newInstance();
		
		L7GatewayConfig gatewayConfig = new L7GatewayConfig(L7GatewayConfig.DEV_ENV);

        try {
			factory.setAttribute( ClientFactory.ATTRIBUTE_USERNAME, gatewayConfig.getUserID() );
		
			factory.setAttribute( ClientFactory.ATTRIBUTE_PASSWORD, gatewayConfig.getPassword() );

			// For the example we disable certificate and hostname validation,
			// you would not do this in production
			factory.setFeature( ClientFactory.FEATURE_CERTIFICATE_VALIDATION, false );
			factory.setFeature( ClientFactory.FEATURE_HOSTNAME_VALIDATION, false );
			
			final Client client = factory.createClient( gatewayConfig.getURL() );
	        final Accessor<ServiceMO> serviceAccessor = client.getAccessor( ServiceMO.class );

			// Create objects for the service
            final ServiceMO serviceMO = ManagedObjectFactory.createService();
            final ServiceDetail serviceDetail = ManagedObjectFactory.createServiceDetail();
            serviceMO.setServiceDetail(serviceDetail);
            serviceDetail.setEnabled( true );
            serviceDetail.setName( "TestService Import" );
            serviceDetail.setFolderId("a2e951b5fd0683dd2ee29ac493c3c508");
            
            final HttpMapping httpMapping = ManagedObjectFactory.createHttpMapping();
            httpMapping.setUrlPattern( "/testServiceImportForCPMore" );
            httpMapping.setVerbs( Arrays.asList( "GET" ) );
                      
            final SoapMapping soapMapping = ManagedObjectFactory.createSoapMapping();
            soapMapping.setLax( false );
     
            serviceDetail.setServiceMappings( Arrays.asList( httpMapping, soapMapping ) );         
            final Map<String, Object> serviceProperties = new HashMap<String, Object>();
            serviceProperties.put("soapVersion", "1.2");
            serviceProperties.put("soap", "true");
            
            serviceDetail.setProperties(serviceProperties);
            
    /*        
            serviceProperties.put("internal", "false");
            serviceProperties.put("wssProcessingEnabled", "false");
            serviceProperties.put("policyRevision", "2");
            serviceProperties.put("soap", "false");
            serviceProperties.put("tracingEnabled", "false");*/
            
            
            final ResourceSet policyResourceSet = ManagedObjectFactory.createResourceSet();
            final Resource policyResource = ManagedObjectFactory.createResource();
            policyResourceSet.setTag("policy");
            policyResource.setType("policy");
            policyResource.setContent(getServiceXML("//Users//nex53212//Desktop//gen_policy//logCPPolicy123Dinesh_internal.xml"));
            policyResourceSet.setResources(Arrays.asList(policyResource));
            
            serviceMO.setServiceDetail( serviceDetail );
            serviceMO.setResourceSets(Arrays.asList(policyResourceSet));
            // Create the policy and log the identifier
            final String identifier = serviceAccessor.create(serviceMO);
            
            
            System.out.println( "Created service with identifier: " + identifier );
          
           
        } catch (Exception e) {
			e.printStackTrace();
		}

	}

}
