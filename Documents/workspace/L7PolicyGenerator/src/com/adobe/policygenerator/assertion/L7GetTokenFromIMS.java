package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7GetTokenFromIMS implements IL7OBJECT {

	@Override
	public String toL7XML() {
		
		StringBuffer l7XMLBuffer = new StringBuffer();
		return l7XMLBuffer.toString();
		
	/*	l7XMLBuffer.append("<IncludedPolicyReference RefType=\"com.l7tech.console.policy.exporter.IncludedPolicyReference\" guid=\"58abe3c7-cab7-4059-b16a-84a75b19cd27\" included=\"true\" name=\"getTokenFromIMS\" soap=\"false\" type=\"INCLUDE_FRAGMENT\">");
		l7XMLBuffer.append("<wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">");
		l7XMLBuffer.append("<wsp:All wsp:Usage=\"Required\">");
		l7XMLBuffer.append("<L7p:AuditDetailAssertion>");
		l7XMLBuffer.append("<L7p:Detail stringValue=\"Policy Fragment: getTokenFromIMS\"/>");
                  </L7p:AuditDetailAssertion>
                  <wsp:OneOrMore wsp:Usage="Required">
                      <wsp:All wsp:Usage="Required">
                          <L7p:Include>
                              <L7p:AssertionComment assertionComment="included">
                                  <L7p:Properties mapValue="included">
                                  <L7p:entry>
                                  <L7p:key stringValue="RIGHT.COMMENT"/>
                                  <L7p:value stringValue="Get Connection Info from Cluster wide properties"/>
                                  </L7p:entry>
                                  </L7p:Properties>
                              </L7p:AssertionComment>
                              <L7p:PolicyGuid stringValue="36fd32f0-0ca6-4cb2-bd0a-f69470697302"/>
                          </L7p:Include>
                          <L7p:CacheLookup>
                              <L7p:AssertionComment assertionComment="included">
                                  <L7p:Properties mapValue="included">
                                  <L7p:entry>
                                  <L7p:key stringValue="RIGHT.COMMENT"/>
                                  <L7p:value stringValue="Cached for 22 hrs"/>
                                  </L7p:entry>
                                  </L7p:Properties>
                              </L7p:AssertionComment>
                              <L7p:CacheEntryKey stringValue="${service.imsLoginUrl}"/>
                              <L7p:CacheId stringValue="cacheIMSTokens"/>
                              <L7p:ContentTypeOverride stringValue=""/>
                              <L7p:MaxEntryAgeMillis longValue="79200000"/>
                              <L7p:OtherTargetMessageVariable stringValue="local.accessToken"/>
                              <L7p:Target target="OTHER"/>
                          </L7p:CacheLookup>
                          <L7p:ComparisonAssertion>
                              <L7p:CaseSensitive booleanValue="false"/>
                              <L7p:Expression1 stringValue="${local.accessToken.mainpart}"/>
                              <L7p:Expression2 stringValue=""/>
                              <L7p:Negate booleanValue="true"/>
                              <L7p:Operator operator="EMPTY"/>
                              <L7p:Predicates predicates="included">
                                  <L7p:item binary="included">
                                  <L7p:CaseSensitive booleanValue="false"/>
                                  <L7p:Negated booleanValue="true"/>
                                  <L7p:Operator operator="EMPTY"/>
                                  <L7p:RightValue stringValue=""/>
                                  </L7p:item>
                              </L7p:Predicates>
                          </L7p:ComparisonAssertion>
                          <L7p:SetVariable>
                              <L7p:Base64Expression stringValue="JHtsb2NhbC5hY2Nlc3NUb2tlbi5tYWlucGFydH0="/>
                              <L7p:VariableToSet stringValue="local.accessToken"/>
                          </L7p:SetVariable>
                          <L7p:AuditDetailAssertion>
                              <L7p:Detail stringValue="Got IMS token from cache..."/>
                          </L7p:AuditDetailAssertion>
                          <L7p:assertionComment>
                              <L7p:Properties mapValue="included">
                                  <L7p:entry>
                                  <L7p:key stringValue="RIGHT.COMMENT"/>
                                  <L7p:value stringValue="Look in cache for IMS Token. Valid for 22  hrs"/>
                                  </L7p:entry>
                              </L7p:Properties>
                          </L7p:assertionComment>
                      </wsp:All>
                      <wsp:All wsp:Usage="Required">
                          <L7p:HttpRoutingAssertion>
                              <L7p:HttpMethod httpMethod="POST"/>
                              <L7p:ProtectedServiceUrl stringValue="${service.imsLoginUrl}${service.imsUri}"/>
                              <L7p:ProxyPassword stringValueNull="null"/>
                              <L7p:ProxyUsername stringValueNull="null"/>
                              <L7p:RequestHeaderRules httpPassthroughRuleSet="included">
                                  <L7p:Rules httpPassthroughRules="included">
                                  <L7p:item httpPassthroughRule="included">
                                  <L7p:Name stringValue="Cookie"/>
                                  </L7p:item>
                                  <L7p:item httpPassthroughRule="included">
                                  <L7p:Name stringValue="SOAPAction"/>
                                  </L7p:item>
                                  </L7p:Rules>
                              </L7p:RequestHeaderRules>
                              <L7p:RequestParamRules httpPassthroughRuleSet="included">
                                  <L7p:ForwardAll booleanValue="true"/>
                                  <L7p:Rules httpPassthroughRules="included"/>
                              </L7p:RequestParamRules>
                              <L7p:ResponseHeaderRules httpPassthroughRuleSet="included">
                                  <L7p:Rules httpPassthroughRules="included">
                                  <L7p:item httpPassthroughRule="included">
                                  <L7p:Name stringValue="Set-Cookie"/>
                                  </L7p:item>
                                  </L7p:Rules>
                              </L7p:ResponseHeaderRules>
                              <L7p:SamlAssertionVersion intValue="2"/>
                          </L7p:HttpRoutingAssertion>
                          <L7p:JsonTransformation>
                              <L7p:PrettyPrint booleanValue="true"/>
                              <L7p:RootTagString stringValue="IMS"/>
                              <L7p:Transformation transformation="JSON_to_XML"/>
                          </L7p:JsonTransformation>
                          <L7p:ResponseXpathAssertion>
                              <L7p:VariablePrefix stringValue="local.access_token"/>
                              <L7p:XpathExpression xpathExpressionValue="included">
                                  <L7p:Expression stringValue="/IMS/access_token"/>
                                  <L7p:Namespaces mapValue="included">
                                  <L7p:entry>
                                  <L7p:key stringValue="s"/>
                                  <L7p:value stringValue="http://schemas.xmlsoap.org/soap/envelope/"/>
                                  </L7p:entry>
                                  </L7p:Namespaces>
                              </L7p:XpathExpression>
                          </L7p:ResponseXpathAssertion>
                          <L7p:SetVariable>
                              <L7p:Base64Expression stringValue="JHtsb2NhbC5hY2Nlc3NfdG9rZW4ucmVzdWx0fQ=="/>
                              <L7p:VariableToSet stringValue="local.accessToken"/>
                          </L7p:SetVariable>
                          <L7p:CacheStorage>
                              <L7p:AssertionComment assertionComment="included">
                                  <L7p:Properties mapValue="included">
                                  <L7p:entry>
                                  <L7p:key stringValue="RIGHT.COMMENT"/>
                                  <L7p:value stringValue="Cache it for 22 hours"/>
                                  </L7p:entry>
                                  </L7p:Properties>
                              </L7p:AssertionComment>
                              <L7p:CacheEntryKey stringValue="${service.imsLoginUrl}"/>
                              <L7p:CacheId stringValue="cacheIMSTokens"/>
                              <L7p:MaxEntries intValue="1"/>
                              <L7p:MaxEntryAgeMillis longValue="79200000"/>
                              <L7p:OtherTargetMessageVariable stringValue="local.accessToken"/>
                              <L7p:Target target="OTHER"/>
                          </L7p:CacheStorage>
                          <L7p:AuditDetailAssertion>
                              <L7p:Detail stringValue="Got IMS Token From IMS Server..."/>
                          </L7p:AuditDetailAssertion>
                          <L7p:assertionComment>
                              <L7p:Properties mapValue="included">
                                  <L7p:entry>
                                  <L7p:key stringValue="RIGHT.COMMENT"/>
                                  <L7p:value stringValue="If Cache expires, get from IMS Server"/>
                                  </L7p:entry>
                              </L7p:Properties>
                          </L7p:assertionComment>
                      </wsp:All>
                      <wsp:All wsp:Usage="Required">
                          <L7p:HardcodedResponse>
                              <L7p:Base64ResponseBody stringValue="SU1TIGF1dGggZXJyb3IgOiAke3Jlc3BvbnNlLm1haW5wYXJ0fQ=="/>
                              <L7p:ResponseStatus intValue="400"/>
                          </L7p:HardcodedResponse>
                          <L7p:FalseAssertion/>
                      </wsp:All>
                  </wsp:OneOrMore>
              </wsp:All>
          </wsp:Policy>
      </IncludedPolicyReference>

		
		
		
		
		
		return null;*/
	}

}
