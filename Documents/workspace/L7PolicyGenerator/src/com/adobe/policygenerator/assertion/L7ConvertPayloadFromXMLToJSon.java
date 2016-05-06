package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7ConvertPayloadFromXMLToJSon implements  IL7OBJECT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public String toL7XML() {
		
		StringBuffer jsontoXMLBuffer = new StringBuffer();	
		return jsontoXMLBuffer.toString();
	/*	jsontoXMLBuffer.append("<IncludedPolicyReference");
		jsontoXMLBuffer.append(" RefType=\"com.l7tech.console.policy.exporter.IncludedPolicyReference\"");
		jsontoXMLBuffer.append(" guid=\"8713a70d-180a-47ca-a1a8-44535ed36f05\" included=\"true\"");
		jsontoXMLBuffer.append(" name=\"util.adobe.convertPayloadFromXML2JSON\" soap=\"false\" type=\"INCLUDE_FRAGMENT\">");
		jsontoXMLBuffer.append(" <wsp:Policy xmlns:L7p=\"http://www.layer7tech.com/ws/policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2002/12/policy\">");
		jsontoXMLBuffer.append(" <wsp:All wsp:Usage=\"Required\">");
		jsontoXMLBuffer.append(" <L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append(" <L7p:Detail stringValue=\"Policy Fragment: util.adobe.convertXML2JSON\"/>");
		jsontoXMLBuffer.append(" </L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append(" <wsp:OneOrMore wsp:Usage=\"Required\">");
		jsontoXMLBuffer.append(" <wsp:All wsp:Usage=\"Required\">");
		jsontoXMLBuffer.append(" <L7p:ComparisonAssertion>");
		jsontoXMLBuffer.append(" <L7p:CaseSensitive booleanValue=\"false\"/>");
                    
		jsontoXMLBuffer.append(" <L7p:Expression1 stringValue=\"${payload.content-type}\"/>");
		jsontoXMLBuffer.append(" <L7p:Expression2 stringValue=\"xml\"/>");
		jsontoXMLBuffer.append(" <L7p:Operator operator=\"CONTAINS\"/>");                 
		jsontoXMLBuffer.append(" <L7p:Predicates predicates=\"included\">");                 
		jsontoXMLBuffer.append(" <L7p:item binary=\"included\">");                
		jsontoXMLBuffer.append(" <L7p:CaseSensitive booleanValue=\"false\"/>");                
		jsontoXMLBuffer.append("  <L7p:Operator operator=\"CONTAINS\"/>");               
		jsontoXMLBuffer.append("  <L7p:RightValue stringValue=\"xml\"/>");                   
		jsontoXMLBuffer.append("  </L7p:item>");                    
		jsontoXMLBuffer.append("   </L7p:Predicates>");                     
		jsontoXMLBuffer.append(" </L7p:ComparisonAssertion>");                     
		jsontoXMLBuffer.append(" <L7p:AuditDetailAssertion>");                 
		jsontoXMLBuffer.append(" <L7p:Detail stringValue=\"Attempting XSL Transformations\"/>");
		jsontoXMLBuffer.append(" </L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append(" <L7p:XslTransformation>");
		jsontoXMLBuffer.append(" <L7p:Direction intValue=\"-1\"/>");
		jsontoXMLBuffer.append(" <L7p:OtherTargetMessageVariable stringValue=\"local.payload\"/>");
		jsontoXMLBuffer.append(" <L7p:ResourceInfo staticResourceInfo=\"included\">");
		jsontoXMLBuffer.append(" <L7p:Document stringValueReference=\"inline\"><![CDATA[<xsl:stylesheet version=\"1.0\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
		jsontoXMLBuffer.append(" <xsl:output indent=\"yes\"/>");
		jsontoXMLBuffer.append(" <xsl:template match=\"@* | node()\">");
		jsontoXMLBuffer.append(" <xsl:copy>");
		jsontoXMLBuffer.append("<xsl:apply-templates select=\"@* | node()\"/>");
		jsontoXMLBuffer.append("</xsl:copy>");
		jsontoXMLBuffer.append("</xsl:template>");
		jsontoXMLBuffer.append("<xsl:template match=\"soapenv:*\">");
		jsontoXMLBuffer.append("<xsl:apply-templates select=\"@* | node()\"/>");
		jsontoXMLBuffer.append("</xsl:template>");
		jsontoXMLBuffer.append("</xsl:stylesheet>]]>");
		jsontoXMLBuffer.append("</L7p:Document>");
		jsontoXMLBuffer.append("</L7p:ResourceInfo>");
		jsontoXMLBuffer.append("<L7p:Target target=\"OTHER\"/>");
		jsontoXMLBuffer.append("<L7p:TransformName stringValue=\"\"/>");
		jsontoXMLBuffer.append("<L7p:XsltVersion stringValue=\"1.0\"/>");
		jsontoXMLBuffer.append("</L7p:XslTransformation>");
		jsontoXMLBuffer.append("<L7p:Include>");
		jsontoXMLBuffer.append("<L7p:PolicyGuid stringValue=\"63382df0-aa92-434b-97b3-a9dfb44f8e03\"/>");
		jsontoXMLBuffer.append("</L7p:Include>");
		jsontoXMLBuffer.append("<L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append("<L7p:Detail stringValue=\"Transformations complete.  Converting to JSON\"/>");
		jsontoXMLBuffer.append("</L7p:AuditDetailAssertion>");
		jsontoXMLBuffer.append("<L7p:XslTransformation>");
		jsontoXMLBuffer.append("<L7p:Direction intValue=\"-1\"/>");
		jsontoXMLBuffer.append("<L7p:OtherTargetMessageVariable stringValue=\"local.payload\"/>");
		jsontoXMLBuffer.append("<L7p:ResourceInfo staticResourceInfo=\"included\">");
		jsontoXMLBuffer.append("<L7p:Document stringValueReference=\"inline\"><![CDATA[<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
		jsontoXMLBuffer.append("<xsl:output encoding=\"UTF-8\" indent=\"no\" media-type=\"text/x-json\" method=\"text\" omit-xml-declaration=\"yes\"/>");
		jsontoXMLBuffer.append("<xsl:strip-space elements=\"*\"/>");
		jsontoXMLBuffer.append("<!--contant-->");
		jsontoXMLBuffer.append("<xsl:variable name=\"d\">0123456789</xsl:variable>");
		jsontoXMLBuffer.append("<!-- ignore document text -->");
		jsontoXMLBuffer.append("<xsl:template match=\"text()[preceding-sibling::node() or following-sibling::node()]\"/>");
		jsontoXMLBuffer.append("<!-- string -->");
		jsontoXMLBuffer.append("<xsl:template match=\"text()\">");
		jsontoXMLBuffer.append("<xsl:call-template name=\"escape-string\">");
		jsontoXMLBuffer.append("<xsl:with-param name=\"s\" select=\".\"/>");
		jsontoXMLBuffer.append("</xsl:call-template>");
	    jsontoXMLBuffer.append("</xsl:template>");

	    jsontoXMLBuffer.append("<!-- Main template for escaping strings; used by above template and for object-properties Responsibilities: placed quotes around string, and chain up to next filter, escape-bs-string -->");
	    jsontoXMLBuffer.append("<xsl:template name=\"escape-string\">");
	    jsontoXMLBuffer.append("<xsl:param name=\"s\"/>");
	    jsontoXMLBuffer.append("<xsl:text>\"</xsl:text>");
	    jsontoXMLBuffer.append("<xsl:call-template name=\"escape-bs-string\">");
	    jsontoXMLBuffer.append("<xsl:with-param name=\"s\" select=\"$s\"/>");
	    jsontoXMLBuffer.append("</xsl:call-template>");
	    jsontoXMLBuffer.append("<xsl:text>\"</xsl:text>");
	    jsontoXMLBuffer.append("</xsl:template>");

	    jsontoXMLBuffer.append("<!-- Escape the backslash (\\) before everything else. -->");
	    jsontoXMLBuffer.append("<xsl:template name=\"escape-bs-string\">");
	    jsontoXMLBuffer.append("<xsl:param name=\"s\"/>");
	    jsontoXMLBuffer.append("<xsl:choose>");
	    jsontoXMLBuffer.append("<xsl:when test=\"contains($s,'\')\">");
	    jsontoXMLBuffer.append("<xsl:call-template name=\"escape-quot-string\">");
	    jsontoXMLBuffer.append("<xsl:with-param name=\"s\" select=\"concat(substring-before($s,'\'),'\\')\"/>");
	    jsontoXMLBuffer.append("</xsl:call-template>");
	    jsontoXMLBuffer.append("<xsl:call-template name=\"escape-bs-string\">");
	    jsontoXMLBuffer.append("<xsl:with-param name=\"s\" select=\"substring-after($s,'\')\"/>");
	    jsontoXMLBuffer.append("</xsl:call-template>");
	    jsontoXMLBuffer.append("</xsl:when>");
	    jsontoXMLBuffer.append("<xsl:otherwise>");
	    jsontoXMLBuffer.append("<xsl:call-template name=\"escape-quot-string\">");
	    jsontoXMLBuffer.append("<xsl:with-param name=\"s\" select=\"$s\"/>");
	    jsontoXMLBuffer.append("</xsl:call-template>");
	    jsontoXMLBuffer.append("</xsl:otherwise>");
	    jsontoXMLBuffer.append("</xsl:choose>");
	    jsontoXMLBuffer.append("</xsl:template>");

	    jsontoXMLBuffer.append("<!-- Escape the double quote (\"). -->");
	    jsontoXMLBuffer.append("<xsl:template name=\"escape-quot-string\">");
	    jsontoXMLBuffer.append("<xsl:param name=\"s\"/>");
	    jsontoXMLBuffer.append("<xsl:choose>");
	    jsontoXMLBuffer.append("<xsl:when test=\"contains($s,'&quot;')\">");
	    jsontoXMLBuffer.append("<xsl:call-template name=\"encode-string\">");
	    jsontoXMLBuffer.append("<xsl:with-param name=\"s\" select=\"concat(substring-before($s,'&quot;'),'\"')\"/>");
	    jsontoXMLBuffer.append("</xsl:call-template>");
	    jsontoXMLBuffer.append("<xsl:call-template name=\"escape-quot-string\">")
             <xsl:with-param name="s" select="substring-after($s,'&quot;')"/>
         </xsl:call-template>
     </xsl:when>
     <xsl:otherwise>
         <xsl:call-template name="encode-string">
             <xsl:with-param name="s" select="$s"/>
         </xsl:call-template>
     </xsl:otherwise>
 </xsl:choose>
</xsl:template>

<!-- Replace tab, line feed and/or carriage return by its matching escape code. Can't escape backslash
 or double quote here, because they don't replace characters (&#x0; becomes \t), but they prefix 
 characters (\ becomes \\). Besides, backslash should be seperate anyway, because it should be 
 processed first. This function can't do that. -->
<xsl:template name="encode-string">
 <xsl:param name="s"/>
 <xsl:choose>
     <!-- tab -->
     <xsl:when test="contains($s,'&#x9;')">
         <xsl:call-template name="encode-string">
             <xsl:with-param name="s" select="concat(substring-before($s,'&#x9;'),'\t',substring-after($s,'&#x9;'))"/>
         </xsl:call-template>
     </xsl:when>
     <!-- line feed -->
     <xsl:when test="contains($s,'&#xa;')">
         <xsl:call-template name="encode-string">
             <xsl:with-param name="s" select="concat(substring-before($s,'&#xa;'),'\n',substring-after($s,'&#xa;'))"/>
         </xsl:call-template>
     </xsl:when>
     <!-- carriage return -->
     <xsl:when test="contains($s,'&#xd;')">
         <xsl:call-template name="encode-string">
             <xsl:with-param name="s" select="concat(substring-before($s,'&#xd;'),'\r',substring-after($s,'&#xd;'))"/>
         </xsl:call-template>
     </xsl:when>
     <xsl:otherwise><xsl:value-of select="$s"/></xsl:otherwise>
 </xsl:choose>
</xsl:template>

<!-- number (no support for javascript mantise) -->
<xsl:template match="text()[not(string(number())='NaN')]">
 <xsl:text>"</xsl:text><xsl:value-of select="."/><xsl:text>"</xsl:text>
</xsl:template>

<!-- boolean, case-insensitive -->
<xsl:template match="text()[translate(.,'TRUE','true')='true']">true</xsl:template>
<xsl:template match="text()[translate(.,'FALSE','false')='false']">false</xsl:template>

<!-- item:null -->
<xsl:template match="*[count(child::node())=0 and not(attribute::node())]">
 <xsl:call-template name="escape-string">
     <xsl:with-param name="s" select="local-name()"/>
 </xsl:call-template>
 <xsl:text>:null</xsl:text>
 <xsl:if test="following-sibling::*">,</xsl:if>
</xsl:template>

<!-- object -->
<xsl:template match="*" name="base">
 <!-- <xsl:if test="not(preceding-sibling::*)">{</xsl:if> -->
 <xsl:call-template name="escape-string">
     <xsl:with-param name="s" select="name()"/>
 </xsl:call-template>
 <xsl:text>:</xsl:text>
 <xsl:choose>
     <xsl:when test="attribute::node() and child::node()">
         <xsl:if test="attribute::node() or child::node()">
             <xsl:text>
{</xsl:text>
             <xsl:call-template name="handleAttributes">
                 <xsl:with-param name="attrib" select="attribute::*"/>
             </xsl:call-template>
             <xsl:if test="attribute::* and child::node()"><xsl:text>, </xsl:text></xsl:if>
             <xsl:apply-templates select="child::*"/>
             <xsl:if test="text()">
                 <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
             </xsl:if>
             <xsl:text>}
</xsl:text>
         </xsl:if>
     </xsl:when>
     <xsl:when test="not(attribute::node()) and child::node()">
         <xsl:if test="child::*">{</xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text() and child::*">
             <xsl:text>"$" :</xsl:text>
         </xsl:if>
         <xsl:apply-templates select="text()"/>
         <xsl:if test="child::*">}</xsl:if>
     </xsl:when>
     <xsl:when test="attribute::node()">
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:text>}
</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:apply-templates select="text()"/>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="following-sibling::*">,</xsl:if>
 <!-- <xsl:if test="not(following-sibling::*)">}</xsl:if> -->
</xsl:template>

<!-- array -->
<!-- <xsl:template match="*[count(../*[name(../*)=name(.)])=count(../*) and count(../*)&gt;1]"> -->
<xsl:template match="*[name(preceding-sibling::*[1]) = name(.) or name(following-sibling::*[1]) = name(.)]">
 <xsl:if test="name(.) != name(preceding-sibling::*[1])">
     <xsl:text>"</xsl:text><xsl:value-of select="name(.)"/><xsl:text>": [</xsl:text>
 </xsl:if>
 <xsl:choose>
     <xsl:when test="not(child::node()) and not(attribute::*)">
         <xsl:text>null</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:if test="attribute::* and (text() or child::node())"><xsl:text>, </xsl:text></xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text()">
             <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="name(.) != name(following-sibling::*[1]) or not(following-sibling::*)">]</xsl:if>
 <xsl:if test="following-sibling::*">,</xsl:if>
</xsl:template>

<xsl:template name="handleAttributes">
 <xsl:param name="attrib"/>
 <xsl:param name="count" select="count($attrib)"/>
 
 <xsl:for-each select="$attrib">
     <xsl:text>"@</xsl:text><xsl:value-of select="name()"/><xsl:text>": </xsl:text>
     <xsl:choose>
         <xsl:when test=".">
             <xsl:text>"</xsl:text><xsl:value-of select="."/><xsl:text>"</xsl:text>
         </xsl:when>
         <xsl:otherwise>
             <xsl:text>""</xsl:text>
         </xsl:otherwise>
     </xsl:choose>
     <xsl:if test="position() &lt; $count">
         <xsl:text>, </xsl:text>
     </xsl:if>
 </xsl:for-each>
</xsl:template>

<!-- convert specific element to array -->
<xsl:template match="partners">
 <xsl:if test="name(preceding-sibling::*[1]) != name(.) or name(following-sibling::*[1]) != name(.)">
     <xsl:text>"</xsl:text><xsl:value-of select="name(.)"/><xsl:text>": [</xsl:text>
 </xsl:if>
 <xsl:choose>
     <xsl:when test="not(child::node()) and not(attribute::*)">
         <xsl:text>null</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:if test="attribute::* and (text() or child::node())"><xsl:text>, </xsl:text></xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text()">
             <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="name(.) != name(following-sibling::*[1]) or not(following-sibling::*)">]</xsl:if>
 <xsl:if test="following-sibling::*">,</xsl:if>

</xsl:template>  

<xsl:template match="installed_products">
 <xsl:if test="name(preceding-sibling::*[1]) != name(.) or name(following-sibling::*[1]) != name(.)">
     <xsl:text>"</xsl:text><xsl:value-of select="name(.)"/><xsl:text>": [</xsl:text>
 </xsl:if>
 <xsl:choose>
     <xsl:when test="not(child::node()) and not(attribute::*)">
         <xsl:text>null</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:if test="attribute::* and (text() or child::node())"><xsl:text>, </xsl:text></xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text()">
             <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="name(.) != name(following-sibling::*[1]) or not(following-sibling::*)">]</xsl:if>
 <xsl:if test="following-sibling::*">,</xsl:if>

</xsl:template>  

<xsl:template match="attachments">
 <xsl:if test="name(preceding-sibling::*[1]) != name(.) or name(following-sibling::*[1]) != name(.)">
     <xsl:text>"</xsl:text><xsl:value-of select="name(.)"/><xsl:text>": [</xsl:text>
 </xsl:if>
 <xsl:choose>
     <xsl:when test="not(child::node()) and not(attribute::*)">
         <xsl:text>null</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:if test="attribute::* and (text() or child::node())"><xsl:text>, </xsl:text></xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text()">
             <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="name(.) != name(following-sibling::*[1]) or not(following-sibling::*)">]</xsl:if>
 <xsl:if test="following-sibling::*">,</xsl:if>

</xsl:template>  
<xsl:template match="notes">
 <xsl:if test="name(preceding-sibling::*[1]) != name(.) or name(following-sibling::*[1]) != name(.)">
     <xsl:text>"</xsl:text><xsl:value-of select="name(.)"/><xsl:text>": [</xsl:text>
 </xsl:if>
 <xsl:choose>
     <xsl:when test="not(child::node()) and not(attribute::*)">
         <xsl:text>null</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:if test="attribute::* and (text() or child::node())"><xsl:text>, </xsl:text></xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text()">
             <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="name(.) != name(following-sibling::*[1]) or not(following-sibling::*)">]</xsl:if>
 <xsl:if test="following-sibling::*">,</xsl:if>

</xsl:template>  
<xsl:template match="phone">
 <xsl:if test="name(preceding-sibling::*[1]) != name(.) or name(following-sibling::*[1]) != name(.)">
     <xsl:text>"</xsl:text><xsl:value-of select="name(.)"/><xsl:text>": [</xsl:text>
 </xsl:if>
 <xsl:choose>
     <xsl:when test="not(child::node()) and not(attribute::*)">
         <xsl:text>null</xsl:text>
     </xsl:when>
     <xsl:otherwise>
         <xsl:text>
{</xsl:text>
         <xsl:call-template name="handleAttributes">
             <xsl:with-param name="attrib" select="attribute::*"/>
         </xsl:call-template>
         <xsl:if test="attribute::* and (text() or child::node())"><xsl:text>, </xsl:text></xsl:if>
         <xsl:apply-templates select="child::*"/>
         <xsl:if test="text()">
             <xsl:text>"$" :</xsl:text><xsl:apply-templates select="text()"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
     </xsl:otherwise>
 </xsl:choose>
 <xsl:if test="name(.) != name(following-sibling::*[1]) or not(following-sibling::*)">]</xsl:if>
 <xsl:if test="following-sibling::*">,</xsl:if>

</xsl:template>  



<!-- convert root element to an anonymous container -->
<xsl:template match="/">
     <xsl:text>{</xsl:text><xsl:apply-templates select="node()"/><xsl:text>}
</xsl:text>
</xsl:template>

</xsl:stylesheet>]]></L7p:Document>
                         </L7p:ResourceInfo>
                         <L7p:Target target="OTHER"/>
                         <L7p:TransformName stringValue=""/>
                         <L7p:XsltVersion stringValue="1.0"/>
                     </L7p:XslTransformation>
                 </wsp:All>
                 <wsp:All wsp:Usage="Required">
                     <L7p:ComparisonAssertion>
                         <L7p:CaseSensitive booleanValue="false"/>
                         <L7p:Expression1 stringValue="${payload.content-type}"/>
                         <L7p:Expression2 stringValue="json"/>
                         <L7p:Operator operator="CONTAINS"/>
                         <L7p:Predicates predicates="included">
                             <L7p:item binary="included">
                             <L7p:CaseSensitive booleanValue="false"/>
                             <L7p:Operator operator="CONTAINS"/>
                             <L7p:RightValue stringValue="json"/>
                             </L7p:item>
                         </L7p:Predicates>
                     </L7p:ComparisonAssertion>
                 </wsp:All>
                 <wsp:All wsp:Usage="Required">
                     <L7p:Encapsulated>
                         <L7p:EncapsulatedAssertionConfigGuid stringValue="ef786bf3-1462-4933-bcf3-3b94d1f45062"/>
                         <L7p:EncapsulatedAssertionConfigName stringValue="Util.Adobe.LogMessage"/>
                         <L7p:Parameters mapValue="included">
                             <L7p:entry>
                             <L7p:key stringValue="in.ErrorMessage"/>
                             <L7p:value stringValue="Error"/>
                             </L7p:entry>
                             <L7p:entry>
                             <L7p:key stringValue="in.ErrorMessage.Detail"/>
                             <L7p:value stringValue="XML to JSON conversion failed"/>
                             </L7p:entry>
                             <L7p:entry>
                             <L7p:key stringValue="in.logLevel"/>
                             <L7p:value stringValue="1"/>
                             </L7p:entry>
                             <L7p:entry>
                             <L7p:key stringValue="in.Source"/>
                             <L7p:value stringValue="XML to JSON conversion failed"/>
                             </L7p:entry>
                         </L7p:Parameters>
                     </L7p:Encapsulated>
                     <L7p:SetVariable>
                         <L7p:Base64Expression stringValue="WWVz"/>
                         <L7p:VariableToSet stringValue="capturedError"/>
                     </L7p:SetVariable>
                 </wsp:All>
             </wsp:OneOrMore>
         </wsp:All>
     </wsp:Policy>
 </IncludedPolicyReference>
 <IncludedPolicyReference
     RefType="com.l7tech.console.policy.exporter.IncludedPolicyReference"
     guid="63382df0-aa92-434b-97b3-a9dfb44f8e03" included="true"
     name="removeXmlNamespaceNone" soap="false" type="INCLUDE_FRAGMENT">
     <wsp:Policy xmlns:L7p="http://www.layer7tech.com/ws/policy" xmlns:wsp="http://schemas.xmlsoap.org/ws/2002/12/policy">
         <wsp:All wsp:Usage="Required">
             <L7p:AuditDetailAssertion>
                 <L7p:Detail stringValue="Policy Fragment: removeXmlNamespace"/>
             </L7p:AuditDetailAssertion>
             <L7p:CommentAssertion>
                 <L7p:Comment stringValue="!-------Removes all the namespace for any XML payload-------------!"/>
             </L7p:CommentAssertion>
             <L7p:CommentAssertion>
                 <L7p:Comment stringValue="INPUT XML must be passed in Request object"/>
             </L7p:CommentAssertion>
             <L7p:CommentAssertion>
                 <L7p:Comment stringValue="OUTPUT XML will be passed back in the same Request object"/>
             </L7p:CommentAssertion>
             <L7p:XslTransformation>
                 <L7p:ResourceInfo staticResourceInfo="included">
                     <L7p:Document stringValueReference="inline"><![CDATA[<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"/>
<xsl:template match="/">
 <xsl:apply-templates select="@*|node()|text()"/>
</xsl:template>
<xsl:template match="node()">
 <xsl:variable name="element-name" select="local-name()"/>
 <xsl:element name="{$element-name}">
     <xsl:apply-templates select="@*|node()|text()"/>
 </xsl:element>
</xsl:template>
<xsl:template match="@*|text()">
 <xsl:copy>
     <xsl:apply-templates select="@*|node()|text()"/>
 </xsl:copy>
</xsl:template>
</xsl:stylesheet>]]></L7p:Document>
                 </L7p:ResourceInfo>
                 <L7p:TransformName stringValue=""/>
             </L7p:XslTransformation>
         </wsp:All>
     </wsp:Policy>
 </IncludedPolicyReference>*/
             
	}


}
