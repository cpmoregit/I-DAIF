package com.adobe.policy.exportimport;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.l7tech.gateway.api.Client;
import com.l7tech.gateway.api.ClientFactory;
import com.l7tech.gateway.api.PrivateKeyMO;
import com.l7tech.gateway.api.PrivateKeyMOAccessor;
import com.l7tech.gateway.api.ServiceDetail;
import com.l7tech.gateway.api.ServiceMO;
import com.l7tech.gateway.api.ServiceMOAccessor;
import com.l7tech.gateway.api.ClientFactory.InvalidOptionException;

public class L7PolicyExport {

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
        
			final ServiceMOAccessor serviceAccessor = client.getAccessor( ServiceMO.class, ServiceMOAccessor.class );
			String xml = serviceAccessor.exportPolicy("b3ebcbb07c8d9fc145497956559a33a8");
			
			System.out.println(xml);
			
			ServiceDetail serviceDetail = serviceAccessor.getServiceDetail("b3ebcbb07c8d9fc145497956559a33a8");
			
			System.out.println("-----------------------------------------------------");
			System.out.println("------------------Service Detail----------------------");
			System.out.println("Enabled: " +serviceDetail.getEnabled());
			System.out.println("FolderID: " +serviceDetail.getFolderId());
			System.out.println("ID: " +serviceDetail.getId());
			System.out.println("Name: " +serviceDetail.getName());
			System.out.println("Version: " +serviceDetail.getVersion());
			System.out.println("Properties: ");
			Map<String, Object> serviceProperties = serviceDetail.getProperties();
			Iterator mapIterator = serviceProperties.keySet().iterator();
			while(mapIterator.hasNext())
				System.out.println(mapIterator.next() + " = " + serviceProperties.get(mapIterator.next()));
			
		
			System.out.println("-----------------------------------------------------");
        
        
        } catch (Exception e) {
			e.printStackTrace();
		}

	}

}
