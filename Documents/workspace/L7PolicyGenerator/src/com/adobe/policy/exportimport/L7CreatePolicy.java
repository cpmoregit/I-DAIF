package com.adobe.policy.exportimport;

import com.l7tech.gateway.api.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L7CreatePolicy {

    /**
     * The URL of the Gateway Management Service to connect to.
     */
    private static final String GATEWAY_URL = "https://sj1svm065.corp.adobe.com:9443/wsman";
    private static final String DMZ_GATEWAY_URL = "https://sj1svm066.corp.adobe.com:9443/wsman";

    /**
     * The credentials for an administrative user with permission to publish a service.
     */
    private static final String USERNAME = "ssgadm";
    private static final String PASSWORD = "X3@*ZMYkeJMN";
    
    /**
     * The credentials for an administrative user with permission to publish a service.
     */
    private static final String DMZ_USERNAME = "ssgadm";
    private static final String DMZ_PASSWORD = "r6J54YwYWcD%";
    
    public static boolean saveToGateway(String policyName, String policyXml){
    	boolean isSaved = true;
    	
    	try{
    	
        final ClientFactory factory = ClientFactory.newInstance();

        factory.setAttribute(ClientFactory.ATTRIBUTE_USERNAME, USERNAME);
        factory.setAttribute(ClientFactory.ATTRIBUTE_PASSWORD, PASSWORD);

        // For the example we disable certificate and hostname validation,
        // you would not do this in production
        factory.setFeature(ClientFactory.FEATURE_CERTIFICATE_VALIDATION, false);
        factory.setFeature(ClientFactory.FEATURE_HOSTNAME_VALIDATION, false);

        final Client client = factory.createClient(GATEWAY_URL);
        final Accessor<PolicyMO> policyAccessor = client.getAccessor(PolicyMO.class);

        // Create objects for the policy
        final PolicyMO policyMO = ManagedObjectFactory.createPolicy();
        final PolicyDetail policyDetail = ManagedObjectFactory.createPolicyDetail();
        policyMO.setPolicyDetail(policyDetail);
        policyDetail.setName(policyName);
        policyDetail.setPolicyType(PolicyDetail.PolicyType.INCLUDE);
        final Map<String, Object> detailProps = new HashMap<String, Object>();
        detailProps.put("soap", "false");

        final ResourceSet policyResourceSet = ManagedObjectFactory.createResourceSet();
        policyResourceSet.setTag("policy");
        final Resource policyResource = ManagedObjectFactory.createResource();
        policyResource.setType("policy");
        policyResource.setContent(policyXml);
        policyResourceSet.setResources(Arrays.asList(policyResource));

        policyMO.setResourceSets(Arrays.asList(policyResourceSet));

        // Create the policy and log the identifier
        final String identifier = policyAccessor.create(policyMO);
        System.out.println("Created policy with identifier: " + identifier);


    } catch (ClientFactory.InvalidOptionException e) {
    	isSaved = false;
        // Handle error due to an incorrect feature or attribute
        e.printStackTrace();
    } catch (Accessor.AccessorException e) {
    	isSaved = false;
        // Handle "business logic" errors
        e.printStackTrace();
    } catch (ManagementRuntimeException e) {
        // Handle any runtime errors, not meaninfully handled by lower level code
    	isSaved = false;
        e.printStackTrace();
    } 
    		
    	
    	return isSaved;
    }
    
    
    public static boolean saveToDMZ(String policyName, String policyXml){
    	boolean isSaved = true;
    	
    	try{
    	
        final ClientFactory factory = ClientFactory.newInstance();

        factory.setAttribute(ClientFactory.ATTRIBUTE_USERNAME, DMZ_USERNAME);
        factory.setAttribute(ClientFactory.ATTRIBUTE_PASSWORD, DMZ_PASSWORD);

        // For the example we disable certificate and hostname validation,
        // you would not do this in production
        factory.setFeature(ClientFactory.FEATURE_CERTIFICATE_VALIDATION, false);
        factory.setFeature(ClientFactory.FEATURE_HOSTNAME_VALIDATION, false);

        final Client client = factory.createClient(DMZ_GATEWAY_URL);
        final Accessor<PolicyMO> policyAccessor = client.getAccessor(PolicyMO.class);

        // Create objects for the policy
        final PolicyMO policyMO = ManagedObjectFactory.createPolicy();
        final PolicyDetail policyDetail = ManagedObjectFactory.createPolicyDetail();
        policyMO.setPolicyDetail(policyDetail);
        policyDetail.setName(policyName);
        policyDetail.setPolicyType(PolicyDetail.PolicyType.INCLUDE);
        final Map<String, Object> detailProps = new HashMap<String, Object>();
        detailProps.put("soap", "false");

        final ResourceSet policyResourceSet = ManagedObjectFactory.createResourceSet();
        policyResourceSet.setTag("policy");
        final Resource policyResource = ManagedObjectFactory.createResource();
        policyResource.setType("policy");
        policyResource.setContent(policyXml);
        policyResourceSet.setResources(Arrays.asList(policyResource));

        policyMO.setResourceSets(Arrays.asList(policyResourceSet));

        // Create the policy and log the identifier
        final String identifier = policyAccessor.create(policyMO);
        System.out.println("Created policy with identifier: " + identifier);


    } catch (ClientFactory.InvalidOptionException e) {
    	isSaved = false;
        // Handle error due to an incorrect feature or attribute
        e.printStackTrace();
    } catch (Accessor.AccessorException e) {
    	isSaved = false;
        // Handle "business logic" errors
        e.printStackTrace();
    } catch (ManagementRuntimeException e) {
        // Handle any runtime errors, not meaninfully handled by lower level code
    	isSaved = false;
        e.printStackTrace();
    } 
    		
    	
    	return isSaved;
    }
    


}
