package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ConvertPayloadFromJSonToXML implements IL7OBJECT {

	@Override
	public String toL7XML() {
		
		StringBuffer jsontoXMLBuffer = new StringBuffer();
		
		jsontoXMLBuffer.append("<IncludedPolicyReference RefType=\"com.l7tech.console.policy.exporter.IncludedPolicyReference\""); 
		jsontoXMLBuffer.append(" guid=\"9e78fe35-e94f-4bd4-9fa9-401c8d93f5b3\" included=\"true\"");
		jsontoXMLBuffer.append( "name=\"util.adobe.convertPayloadFromJSON2XML\" soap=\"false\" type=\"INCLUDE_FRAGMENT\">");
		jsontoXMLBuffer.append( "<wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">");
		jsontoXMLBuffer.append( "<wsp:All wsp:Usage=\"Required\">");
		jsontoXMLBuffer.append( "<L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append( "<L7p:Detail stringValue=\"Policy Fragment: util.adobe.convertPayloadFromJSON2XML\"/>");
		jsontoXMLBuffer.append( "</L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append( "<wsp:OneOrMore wsp:Usage=\"Required\">");
		jsontoXMLBuffer.append( "<wsp:All wsp:Usage=\"Required\">");
		jsontoXMLBuffer.append( "<L7p:ComparisonAssertion>");
		jsontoXMLBuffer.append( "<L7p:CaseSensitive booleanValue=\"false\"/>");
		jsontoXMLBuffer.append( "<L7p:Expression1 stringValue=\"${payload.content-type}\"/>");        
		jsontoXMLBuffer.append( "<L7p:Expression2 stringValue=\"json\"/>");            
		jsontoXMLBuffer.append( "<L7p:Operator operator=\"CONTAINS\"/>");
		jsontoXMLBuffer.append( "<L7p:Predicates predicates=\"included\">");
		jsontoXMLBuffer.append( "<L7p:item binary=\"included\">");                   
		jsontoXMLBuffer.append( "<L7p:CaseSensitive booleanValue=\"false\"/>");
		jsontoXMLBuffer.append( "<L7p:Operator operator=\"CONTAINS\"/>");                       
		jsontoXMLBuffer.append( "<L7p:RightValue stringValue=\"json\"/>");                        
		jsontoXMLBuffer.append( "</L7p:item>");                        
		jsontoXMLBuffer.append( "</L7p:Predicates>");                 
		jsontoXMLBuffer.append( "</L7p:ComparisonAssertion>");
		jsontoXMLBuffer.append( "<L7p:JsonTransformation>");                 
		jsontoXMLBuffer.append( "<L7p:DestinationMessageTarget MessageTarget=\"included\">");                
		jsontoXMLBuffer.append( "<L7p:OtherTargetMessageVariable stringValue=\"local.payload\"/>");            
		jsontoXMLBuffer.append( "<L7p:Target target=\"OTHER\"/>");                    
		jsontoXMLBuffer.append( "<L7p:TargetModifiedByGateway booleanValue=\"true\"/>");                        
		jsontoXMLBuffer.append( "</L7p:DestinationMessageTarget>");                      
		jsontoXMLBuffer.append( "<L7p:OtherTargetMessageVariable stringValue=\"local.payload\"/>");                       
		jsontoXMLBuffer.append( "<L7p:RootTagString stringValue=\"${xml.root.tag}\"/>");                    
		jsontoXMLBuffer.append( "<L7p:Target target=\"OTHER\"/>");                   
		jsontoXMLBuffer.append( "<L7p:Transformation transformation=\"JSON_to_XML\"/>");                    
		jsontoXMLBuffer.append("</L7p:JsonTransformation>");                    
		jsontoXMLBuffer.append("</wsp:All>");                    
		jsontoXMLBuffer.append("<wsp:All wsp:Usage=\"Required\">");    
		jsontoXMLBuffer.append("<L7p:ComparisonAssertion>");           
		jsontoXMLBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		jsontoXMLBuffer.append("<L7p:Expression1 stringValue=\"${payload.content-type}\"/>");                    
		jsontoXMLBuffer.append("<L7p:Expression2 stringValue=\"xml\"/>");                  
		jsontoXMLBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");                    
		jsontoXMLBuffer.append("<L7p:Predicates predicates=\"included\">");                    
		jsontoXMLBuffer.append("<L7p:item binary=\"included\">");                   
		jsontoXMLBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");                       
		jsontoXMLBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");                        
		jsontoXMLBuffer.append("<L7p:RightValue stringValue=\"xml\"/>");                        
		jsontoXMLBuffer.append("</L7p:item>");                       
		jsontoXMLBuffer.append("</L7p:Predicates>");                       
		jsontoXMLBuffer.append("</L7p:ComparisonAssertion>");                    
		jsontoXMLBuffer.append("</wsp:All>");               
		jsontoXMLBuffer.append("<wsp:All wsp:Usage=\"Required\">");          
		jsontoXMLBuffer.append("<L7p:Encapsulated>");
		jsontoXMLBuffer.append("<L7p:EncapsulatedAssertionConfigGuid stringValue=\"ef786bf3-1462-4933-bcf3-3b94d1f45062\"/>");     
		jsontoXMLBuffer.append("<L7p:EncapsulatedAssertionConfigName stringValue=\"Util.Adobe.LogMessage\"/>");                
		jsontoXMLBuffer.append("<L7p:Parameters mapValue=\"included\">");                   
		jsontoXMLBuffer.append("<L7p:entry>");                    
		jsontoXMLBuffer.append("<L7p:key stringValue=\"in.ErrorMessage\"/>");
		jsontoXMLBuffer.append("<L7p:value stringValue=\"Error\"/>");
		jsontoXMLBuffer.append("</L7p:entry>");
		jsontoXMLBuffer.append("<L7p:entry>");
		jsontoXMLBuffer.append("<L7p:key stringValue=\"in.ErrorMessage.Detail\"/>");
		jsontoXMLBuffer.append("<L7p:value stringValue=\"JSON to XML conversion failed\"/>");
		jsontoXMLBuffer.append("</L7p:entry>");
		jsontoXMLBuffer.append("<L7p:entry>");
		jsontoXMLBuffer.append("<L7p:key stringValue=\"in.logLevel\"/>");
		jsontoXMLBuffer.append("<L7p:value stringValue=\"1\"/>");
		jsontoXMLBuffer.append("</L7p:entry>");
		jsontoXMLBuffer.append("<L7p:entry>");
		jsontoXMLBuffer.append("<L7p:key stringValue=\"in.Source\"/>");
		jsontoXMLBuffer.append("<L7p:value stringValue=\"Error\"/>");
		jsontoXMLBuffer.append("</L7p:entry>");
		jsontoXMLBuffer.append("</L7p:Parameters>");
		jsontoXMLBuffer.append("</L7p:Encapsulated>");
		jsontoXMLBuffer.append("<L7p:SetVariable>");
		jsontoXMLBuffer.append("<L7p:Base64Expression stringValue=\"WWVz\"/>");
		jsontoXMLBuffer.append("<L7p:VariableToSet stringValue=\"capturedError\"/>");
		jsontoXMLBuffer.append("</L7p:SetVariable>");
		jsontoXMLBuffer.append("</wsp:All>");
		jsontoXMLBuffer.append("</wsp:OneOrMore>");
		jsontoXMLBuffer.append("</wsp:All>");
		jsontoXMLBuffer.append("</wsp:Policy>");
		jsontoXMLBuffer.append("</IncludedPolicyReference>");

		return jsontoXMLBuffer.toString();
	}

}
