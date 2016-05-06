package com.adobe.policygenerator.referencedpolicy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L7Util {
	
	public static String cleanXML(String xmlString){
		String cleanXMLString = null;
		Pattern pattern = null;
		Matcher matcher = null;
		pattern = Pattern.compile("[\\000]*");
		matcher = pattern.matcher(xmlString);
		if (matcher.find()) {
		   cleanXMLString = matcher.replaceAll("");
		}
		
		return cleanXMLString;
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
