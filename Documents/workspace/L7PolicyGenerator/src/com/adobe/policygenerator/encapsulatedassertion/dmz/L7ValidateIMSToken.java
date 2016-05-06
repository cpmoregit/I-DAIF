package com.adobe.policygenerator.encapsulatedassertion.dmz;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ValidateIMSToken implements IL7OBJECT {

	@Override
	public String toL7XML() {
		
		StringBuffer imsTokenBuffer = new StringBuffer();
		
		imsTokenBuffer.append("<IncludedPolicyReference RefType=\"com.l7tech.console.policy.exporter.IncludedPolicyReference\" guid=\"cec70c24-9c8f-408a-b79d-07e2d2fd05da\" included=\"true\" name=\"util.adobe.validateIMSTokenOffline\" soap=\"false\" type=\"INCLUDE_FRAGMENT\">");
		imsTokenBuffer.append("<wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">");
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		imsTokenBuffer.append("<L7p:CommentAssertion>");
		imsTokenBuffer.append("<L7p:Comment stringValue=\"---Owner of this policy fragment: Prakash Nair ----\"/>");
		imsTokenBuffer.append("</L7p:CommentAssertion>");
		imsTokenBuffer.append("<L7p:CommentAssertion>");
		imsTokenBuffer.append("<L7p:Comment stringValue=\"Require to provide IMS token in service.adobe.imstoken as Input\"/>");
		imsTokenBuffer.append("</L7p:CommentAssertion>");
		imsTokenBuffer.append("<L7p:CommentAssertion>");
		imsTokenBuffer.append("<L7p:Comment stringValue=\"Require to proivde Gateway Environment in service.environment as Input\"/>");
		imsTokenBuffer.append("</L7p:CommentAssertion>");
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Policy Fragment: util.adobe.validateIMSTokenOffline\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");  
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Extract First Token - Contract_id\"/>");                
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");                       
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtyZXF1ZXN0Lmh0dHAuaGVhZGVyLkF1dGhvcml6YXRpb259\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"service.adobe.imstoken\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");            
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");                
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Extract First Token - Contract_id\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtzZXJ2aWNlLmFkb2JlLmVudmlyb25tZW50fQ==\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"service.environment\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:SetVariable>"); 
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Extract First Token - Contract_id\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtzZXJ2aWNlLmFkb2JlLmltc3Rva2VufQ==\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"source\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"// Comments : Get Connection Info XML from clusterwide properties\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtnYXRld2F5LmFkb2JlLmltcy5jb25uZWN0aW9uLnByb2ZpbGV9\"/>");
		imsTokenBuffer.append("<L7p:ContentType stringValue=\"text/xml; charset=utf-8\"/>");
		imsTokenBuffer.append("<L7p:DataType variableDataType=\"message\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"local.imsConnProfile\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
	
		imsTokenBuffer.append("<L7p:ResponseXpathAssertion>");
		imsTokenBuffer.append("<L7p:VariablePrefix stringValue=\"local.loginUrl\"/>");
		imsTokenBuffer.append("<L7p:XmlMsgSrc stringValue=\"local.imsConnProfile\"/>");
		imsTokenBuffer.append("<L7p:XpathExpression xpathExpressionValue=\"included\">");
		imsTokenBuffer.append("<L7p:Expression stringValue=\"/imsLoginInfo/conn[env=$service.environment]/loginUrl\"/>");
		imsTokenBuffer.append("<L7p:Namespaces mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"s\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"http://schemas.xmlsoap.org/soap/envelope/\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Namespaces>");
		imsTokenBuffer.append("</L7p:XpathExpression>");
		imsTokenBuffer.append("</L7p:ResponseXpathAssertion>");
		
		imsTokenBuffer.append("<L7p:ComparisonAssertion>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Check to see if there are more than 1 entry in the XML\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Expression1 stringValue=\"${local.loginUrl.count}\"/>");
		imsTokenBuffer.append("<L7p:MultivaluedComparison multivaluedComparison=\"FAIL\"/>");
		imsTokenBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:Predicates predicates=\"included\">");
		imsTokenBuffer.append("<L7p:item dataType=\"included\">");
		imsTokenBuffer.append("<L7p:Type variableDataType=\"int\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("<L7p:item binary=\"included\">");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:RightValue stringValue=\"1\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Predicates>");
		imsTokenBuffer.append("</L7p:ComparisonAssertion>");
	
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"// Comments : Extract the XML elements of the matched environment\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtsb2NhbC5sb2dpblVybC5yZXN1bHRzfQ==\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"imsURL\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:Split>");
		imsTokenBuffer.append("<L7p:IgnoreEmptyValues booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:InputVariable stringValue=\"source\"/>");
		imsTokenBuffer.append("<L7p:OutputVariable stringValue=\"service.adobe.ims.parts\"/>");
		imsTokenBuffer.append("<L7p:SplitPattern stringValue=\".\"/>");
		imsTokenBuffer.append("<L7p:SplitPatternRegEx booleanValue=\"false\"/>");
		imsTokenBuffer.append("</L7p:Split>");
		
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtzZXJ2aWNlLmFkb2JlLmltcy5wYXJ0c1swXX0=\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"service.adobe.ims.header\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtzZXJ2aWNlLmFkb2JlLmltcy5wYXJ0c1sxXX0=\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"service.adobe.ims.payload\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:EncodeDecode>");
		imsTokenBuffer.append("<L7p:CharacterEncoding stringValueNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:SourceVariableName stringValue=\"service.adobe.ims.header\"/>");
		imsTokenBuffer.append("<L7p:TargetContentType stringValue=\"application/json; charset=utf-8\"/>");
		imsTokenBuffer.append("<L7p:TargetDataType variableDataType=\"message\"/>");
		imsTokenBuffer.append("<L7p:TargetVariableName stringValue=\"service.adobe.ims.header.decoded\"/>");
		imsTokenBuffer.append("<L7p:TransformType transformType=\"BASE64_DECODE\"/>");
		imsTokenBuffer.append("</L7p:EncodeDecode>");
		
		imsTokenBuffer.append("<L7p:EncodeDecode>");
		imsTokenBuffer.append("<L7p:CharacterEncoding stringValueNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:SourceVariableName stringValue=\"service.adobe.ims.payload\"/>");
		imsTokenBuffer.append("<L7p:TargetContentType stringValue=\"application/json; charset=utf-8\"/>");
		imsTokenBuffer.append("<L7p:TargetDataType variableDataType=\"message\"/>");
		imsTokenBuffer.append("L7p:TargetVariableName stringValue=\"service.adobe.ims.payload.decoded\"/>");
		imsTokenBuffer.append("<L7p:TransformType transformType=\"BASE64_DECODE\"/>");
		imsTokenBuffer.append("</L7p:EncodeDecode>");
		
		imsTokenBuffer.append("<L7p:EvaluateJsonPathExpression>");
		imsTokenBuffer.append("<L7p:Expression stringValue=\"as\"/>");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"service.adobe.ims.payload.decoded\"/>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("<L7p:VariablePrefix stringValue=\"ims.token.server\"/>");
		imsTokenBuffer.append("</L7p:EvaluateJsonPathExpression>");
		
		imsTokenBuffer.append("<L7p:EvaluateJsonPathExpression>");
		imsTokenBuffer.append("<L7p:Expression stringValue=\"x5u\"/>");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"service.adobe.ims.header.decoded\"/>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("<L7p:VariablePrefix stringValue=\"ims.certpath\"/>");
		imsTokenBuffer.append("</L7p:EvaluateJsonPathExpression>");
		
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Fetch x5u IMS cert path and as IMS server url\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");
		
		imsTokenBuffer.append("</wsp:All>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtpbXNVUkx9L2tleXMvJHtpbXMuY2VydHBhdGgucmVzdWx0fQ==\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"service.adobe.ims.certurl\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Certificate Path: ${service.adobe.ims.certurl}\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<wsp:OneOrMore wsp:Usage=\"Required\">");
/*	imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Check Certificate in cache. Cache Expire in 24 hours.\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");		
		
		imsTokenBuffer.append("<L7p:ComparisonAssertion>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Important Logic: Check if the token doesnot belong to wrong environment\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Expression1 stringValue=\"${imsURL}\"/>");
		imsTokenBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:Predicates predicates=\"included\">");
		imsTokenBuffer.append("<L7p:item dataType=\"included\">");
		imsTokenBuffer.append("<L7p:Type variableDataType=\"string\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("<L7p:item binary=\"included\">");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");
		imsTokenBuffer.append("<L7p:RightValue stringValue=\"${ims.token.server.result}\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Predicates>");
		imsTokenBuffer.append("</L7p:ComparisonAssertion>");
		
		imsTokenBuffer.append("<L7p:CacheLookup>");
		imsTokenBuffer.append("<L7p:CacheEntryKey stringValue=\"${service.adobe.ims.certurl}\"/>");
		imsTokenBuffer.append("<L7p:CacheId stringValue=\"imsPublicCert\"/>");
		imsTokenBuffer.append("<L7p:ContentTypeOverride stringValue=\"\"/>");
		imsTokenBuffer.append("<L7p:MaxEntryAgeSeconds stringValue=\"86400\"/>");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"certificate\"/>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("</L7p:CacheLookup>");
		
		imsTokenBuffer.append("<L7p:ComparisonAssertion>");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Expression1 stringValue=\"${certificate.mainpart}\"/>");
		imsTokenBuffer.append("<L7p:Expression2 stringValue=\"\"/>");
		imsTokenBuffer.append("<L7p:Negate booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:Operator operator=\"EMPTY\"/>");
		imsTokenBuffer.append("<L7p:Predicates predicates=\"included\">");
		imsTokenBuffer.append("<L7p:item binary=\"included\">");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Negated booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:Operator operator=\"EMPTY\"/>");
		imsTokenBuffer.append("<L7p:RightValue stringValue=\"\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Predicates>");
		imsTokenBuffer.append("</L7p:ComparisonAssertion>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Extract First Token - Contract_id\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"UmVhZCBmcm9tIGNhY2hlKGV4cGlyeSBvZiA1IG1pbnV0ZXMpISE=\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"CacheStatus\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("</wsp:All>");
		
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Cache expired. Calling the IMS server for the certificate and storing in the cache.\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:ComparisonAssertion>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Important Logic: Check if the token doesnot belong to wrong environment\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Expression1 stringValue=\"${imsURL}\"/>");
		imsTokenBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:Predicates predicates=\"included\">");
		imsTokenBuffer.append("<L7p:item dataType=\"included\">");
		imsTokenBuffer.append("<L7p:Type variableDataType=\"string\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("<L7p:item binary=\"included\">");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Operator operator=\"CONTAINS\"/>");
		imsTokenBuffer.append("<L7p:RightValue stringValue=\"${ims.token.server.result}\"/>");
		imsTokenBuffer.append("</L7p:item>");
		
		imsTokenBuffer.append("</L7p:Predicates>");
		imsTokenBuffer.append("</L7p:ComparisonAssertion>");
		
		imsTokenBuffer.append("L7p:HttpRoutingAssertion>");
		imsTokenBuffer.append("<L7p:HttpMethod httpMethod=\"GET\"/>");
		imsTokenBuffer.append("<L7p:ProtectedServiceUrl stringValue=\"${service.adobe.ims.certurl}\"/>");
		imsTokenBuffer.append("<L7p:ProxyPassword stringValueNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:ProxyUsername stringValueNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:RequestHeaderRules httpPassthroughRuleSet=\"included\">");
		imsTokenBuffer.append("<L7p:ForwardAll booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:Rules httpPassthroughRules=\"included\">");
		imsTokenBuffer.append("<L7p:item httpPassthroughRule=\"included\">");
		imsTokenBuffer.append("<L7p:Name stringValue=\"Cookie\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("<L7p:item httpPassthroughRule=\"included\">"); 
		imsTokenBuffer.append("<L7p:Name stringValue=\"SOAPAction\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Rules>");
		imsTokenBuffer.append("</L7p:RequestHeaderRules>");
		
		imsTokenBuffer.append("<L7p:RequestParamRules httpPassthroughRuleSet=\"included\">");
		imsTokenBuffer.append("<L7p:ForwardAll booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:Rules httpPassthroughRules=\"included\"/>");
		imsTokenBuffer.append("</L7p:RequestParamRules>");
		imsTokenBuffer.append("<L7p:ResponseHeaderRules httpPassthroughRuleSet=\"included\">");
		imsTokenBuffer.append("<L7p:ForwardAll booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:Rules httpPassthroughRules=\"included\">");
		imsTokenBuffer.append("<L7p:item httpPassthroughRule=\"included\">");
		imsTokenBuffer.append("<L7p:Name stringValue=\"Set-Cookie\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Rules>");
		imsTokenBuffer.append("</L7p:ResponseHeaderRules>");
		imsTokenBuffer.append("<L7p:ResponseMsgDest stringValue=\"httpResponse\"/>");
		imsTokenBuffer.append("<L7p:SamlAssertionVersion intValue=\"2\"/>");
		imsTokenBuffer.append("<L7p:UseKeepAlives booleanValue=\"false\"/>");
		imsTokenBuffer.append("</L7p:HttpRoutingAssertion>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Extract First Token - Contract_id\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtodHRwUmVzcG9uc2V9\"/>");
		imsTokenBuffer.append("<L7p:ContentType stringValue=\"text/plain; charset=utf-8\"/>");
		imsTokenBuffer.append("<L7p:DataType variableDataType=\"message\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"certificate\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:CacheStorage>");
		imsTokenBuffer.append("<L7p:CacheEntryKey stringValue=\"${service.adobe.ims.certurl}\"/>");
		imsTokenBuffer.append("<L7p:CacheId stringValue=\"imsPublicCert\"/>");
		imsTokenBuffer.append("<L7p:MaxEntries stringValue=\"1\"/>");
		imsTokenBuffer.append("<L7p:MaxEntryAgeSeconds stringValue=\"86400\"/>");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"certificate\"/>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("</L7p:CacheStorage>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Extract First Token - Contract_id\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"Q2FjaGUgZXhwaXJlZC4gUmVhZCBjZXJ0IGZyb20gc2VydmVyLg==\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"CacheStatus\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		imsTokenBuffer.append("</wsp:All>");
		imsTokenBuffer.append("<L7p:TrueAssertion/>");
		
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Public certificate Caching Logic\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");
		
		imsTokenBuffer.append("</wsp:OneOrMore>");
		
		imsTokenBuffer.append("<wsp:OneOrMore wsp:Usage=\"Required\">");
		
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Signature Validity fragment\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:DecodeJsonWebToken>");
		imsTokenBuffer.append("<L7p:KeyType stringValue=\"Certificate\"/>");
		imsTokenBuffer.append("<L7p:PrivateKeySource stringValue=\"${certificate.mainpart}\"/>");
		imsTokenBuffer.append("<L7p:SourcePayload stringValue=\"${source}\"/>");
		imsTokenBuffer.append("<L7p:TargetVariablePrefix stringValue=\"test\"/>");
		imsTokenBuffer.append("<L7p:ValidationType stringValue=\"Using Recipient Key From Context Variable\"/>");
		imsTokenBuffer.append("</L7p:DecodeJsonWebToken>");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Signature Valid: ${test.valid}\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:ComparisonAssertion>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"!----Comments : Check If response Status is SUCCESS----!\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Expression1 stringValue=\"${test.valid}\"/>");
		imsTokenBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:Predicates predicates=\"included\">");
		imsTokenBuffer.append("<L7p:item regex=\"included\">");
		imsTokenBuffer.append("<L7p:Pattern stringValue=\"true\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Predicates>");
		imsTokenBuffer.append("</L7p:ComparisonAssertion>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHt0ZXN0LnBheWxvYWR9\"/>");
		imsTokenBuffer.append("<L7p:ContentType stringValue=\"application/json; charset=utf-8\"/>");
		imsTokenBuffer.append("<L7p:DataType variableDataType=\"message\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"payload\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:JsonTransformation>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"!----Comments : Convert json response to xml----!\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:DestinationMessageTarget MessageTarget=\"included\">");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"IMSpayload\"/>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("<L7p:TargetModifiedByGateway booleanValue=\"true\"/>");
		imsTokenBuffer.append("</L7p:DestinationMessageTarget>");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"payload\"/>");
		imsTokenBuffer.append("<L7p:PrettyPrint booleanValue=\"true\"/>");
		imsTokenBuffer.append("<L7p:RootTagString stringValue=\"Response\"/>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("<L7p:Transformation transformation=\"JSON_to_XML\"/>");
		imsTokenBuffer.append("</L7p:JsonTransformation>");
		
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Validate the signature JWT\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");
		
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Token Expiry Validity fragment\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:SetVariable>");
		imsTokenBuffer.append("<L7p:Base64Expression stringValue=\"JHtJTVNwYXlsb2FkfQ==\"/>");
		imsTokenBuffer.append("<L7p:ContentType stringValue=\"text/xml; charset=utf-8\"/>");
		imsTokenBuffer.append("<L7p:DataType variableDataType=\"message\"/>");
		imsTokenBuffer.append("<L7p:VariableToSet stringValue=\"test\"/>");
		imsTokenBuffer.append("</L7p:SetVariable>");
		
		imsTokenBuffer.append("<L7p:XslTransformation>");
		imsTokenBuffer.append("<L7p:Direction intValue=\"-1\"/>");
		imsTokenBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"test\"/>");
		imsTokenBuffer.append("<L7p:ResourceInfo staticResourceInfo=\"included\">");
		imsTokenBuffer.append("<L7p:Document stringValueReference=\"inline\"><![CDATA[<xsl:stylesheet exclude-result-prefixes=\"xs\" version=\"1.0\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
		imsTokenBuffer.append("<!-- Identity transform -->");
		imsTokenBuffer.append("<xsl:template match=\"/Response\">");
		imsTokenBuffer.append("<Response>");
		imsTokenBuffer.append("<xsl:variable name=\"currenttimeinUTC\" select=\"(( current-dateTime() -  xs:dateTime('1970-01-01T00:00:00.000Z'))div xs:dayTimeDuration('PT1S')*1000)\"/>");
		imsTokenBuffer.append("<xsl:variable name=\"tokenexpirytime\" select=\"created_at+expires_in\"/>");
		imsTokenBuffer.append("<CurrentTime>");
		
		imsTokenBuffer.append("<xsl:value-of select=\"$currenttimeinUTC\"/>");
		imsTokenBuffer.append("</CurrentTime>");
		imsTokenBuffer.append("<TokenExpiryTime>");
		imsTokenBuffer.append("<xsl:value-of select=\"$tokenexpirytime\"/>");
		imsTokenBuffer.append("</TokenExpiryTime>");
		imsTokenBuffer.append("<Status>");
		imsTokenBuffer.append("<xsl:if test=\"number($currenttimeinUTC) > number($tokenexpirytime)\">Invalid</xsl:if>");
		imsTokenBuffer.append("<xsl:if test=\"number($currenttimeinUTC) &lt; number($tokenexpirytime)\">Valid</xsl:if>");
		imsTokenBuffer.append("</Status>");
		imsTokenBuffer.append("</Response>");
		imsTokenBuffer.append("</xsl:template>");
		imsTokenBuffer.append("</xsl:stylesheet>]]></L7p:Document>");
		imsTokenBuffer.append("</L7p:ResourceInfo>");
		imsTokenBuffer.append("<L7p:Target target=\"OTHER\"/>");
		imsTokenBuffer.append("<L7p:TransformName stringValue=\"\"/>");
		imsTokenBuffer.append("<L7p:XsltVersion stringValue=\"2.0\"/>");
		imsTokenBuffer.append("</L7p:XslTransformation>");
		
		imsTokenBuffer.append("<L7p:ResponseXpathAssertion>");
		imsTokenBuffer.append("<L7p:VariablePrefix stringValue=\"local.expiry\"/>");
		imsTokenBuffer.append("<L7p:XmlMsgSrc stringValue=\"test\"/>");
		imsTokenBuffer.append("<L7p:XpathExpression xpathExpressionValue=\"included\">");
		imsTokenBuffer.append("<L7p:Expression stringValue=\"/Response/Status\"/>");
		imsTokenBuffer.append("<L7p:Namespaces mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"s\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"http://schemas.xmlsoap.org/soap/envelope/\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Namespaces>");
		imsTokenBuffer.append("<L7p:XpathVersion xpathVersion=\"XPATH_1_0\"/>");
		imsTokenBuffer.append("</L7p:XpathExpression>");
		imsTokenBuffer.append("</L7p:ResponseXpathAssertion>");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"Token (Expiry) Valid: ${local.expiry.result}\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:ComparisonAssertion>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"!----Comments : Check If response Status is SUCCESS----!\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:Expression1 stringValue=\"${local.expiry.result}\"/>");
		imsTokenBuffer.append("<L7p:Operator operatorNull=\"null\"/>");
		imsTokenBuffer.append("<L7p:Predicates predicates=\"included\">");
		imsTokenBuffer.append("<L7p:item dataType=\"included\">");
		imsTokenBuffer.append("<L7p:Type variableDataType=\"string\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("<L7p:item binary=\"included\">");
		imsTokenBuffer.append("<L7p:CaseSensitive booleanValue=\"false\"/>");
		imsTokenBuffer.append("<L7p:RightValue stringValue=\"Valid\"/>");
		imsTokenBuffer.append("</L7p:item>");
		imsTokenBuffer.append("</L7p:Predicates>");
		imsTokenBuffer.append("</L7p:ComparisonAssertion>");
		
		imsTokenBuffer.append("<L7p:ResponseXpathAssertion>");
		imsTokenBuffer.append("<L7p:AssertionComment assertionComment=\"included\">");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"!----Comments : Extract valid element from xml----!\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:AssertionComment>");
		imsTokenBuffer.append("<L7p:VariablePrefix stringValue=\"validUser\"/>");
		imsTokenBuffer.append("<L7p:XmlMsgSrc stringValue=\"IMSpayload\"/>");
		imsTokenBuffer.append("<L7p:XpathExpression xpathExpressionValue=\"included\">");
		imsTokenBuffer.append("<L7p:Expression stringValue=\"/Response/user_id\"/>");
		imsTokenBuffer.append("<L7p:Namespaces mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"s\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"http://schemas.xmlsoap.org/soap/envelope/\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Namespaces>");
		imsTokenBuffer.append("<L7p:XpathVersion xpathVersion=\"XPATH_1_0\"/>");
		imsTokenBuffer.append("</L7p:XpathExpression>");
		imsTokenBuffer.append("</L7p:ResponseXpathAssertion>");
		
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"UserId: ${validUser.result}\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Validate token expiry\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");
		imsTokenBuffer.append("</wsp:All>");
		
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Validity Logic: Signature and token expiry \"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");
		imsTokenBuffer.append("</wsp:All>");
		
		imsTokenBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		imsTokenBuffer.append("<L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:Detail stringValue=\"validateIMSBearerTokenFailed - ERROR : Bad IMS Bearer Token\"/>");
		imsTokenBuffer.append("</L7p:AuditDetailAssertion>");
		imsTokenBuffer.append("<L7p:FalseAssertion/>");
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Token Invalid\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");
		imsTokenBuffer.append("</wsp:All>");
		
		imsTokenBuffer.append("<L7p:assertionComment>");
		imsTokenBuffer.append("<L7p:Properties mapValue=\"included\">");
		imsTokenBuffer.append("<L7p:entry>");
		imsTokenBuffer.append("<L7p:key stringValue=\"RIGHT.COMMENT\"/>");
		imsTokenBuffer.append("<L7p:value stringValue=\"Token Valid/Invalid Check\"/>");
		imsTokenBuffer.append("</L7p:entry>");
		imsTokenBuffer.append("</L7p:Properties>");
		imsTokenBuffer.append("</L7p:assertionComment>");*/
		
		imsTokenBuffer.append("/wsp:OneOrMore>");
		imsTokenBuffer.append("</wsp:All>");
		imsTokenBuffer.append("</wsp:Policy>");
		
		imsTokenBuffer.append("</IncludedPolicyReference>");	
		
		// TODO Auto-generated method stub
		return imsTokenBuffer.toString();
	}

	public static void main(String[] args) {
		

	}

}
