package com.adobe.policygenerator.assertion;

public class L7Entry {
	
	private static final String ENTRY_START="<L7p:entry>";
	private static final String ENTRY_END="</L7p:entry>";
	
	private String key;
	private String value;
	
	public L7Entry(String newName, String newValue)
	{
		key = newName;
		value = newValue;
	}
	
	public String toL7XML(){
		StringBuffer xmlStringBuffer = new StringBuffer();
		
		xmlStringBuffer.append(ENTRY_START);
		
		xmlStringBuffer.append("<L7p:key stringValue=\"");
		xmlStringBuffer.append(key);
		xmlStringBuffer.append("\"/>");
		
		xmlStringBuffer.append("<L7p:value stringValue=\"");
		xmlStringBuffer.append(value);
		xmlStringBuffer.append("\"/>");
		
		xmlStringBuffer.append(ENTRY_END);
		
		
		return xmlStringBuffer.toString();
	}
	
	public static void main(String[] args) {
	 System.out.println((new L7Entry("in.ErrorMessage", "This is a sample String")).toL7XML());
	}
}
