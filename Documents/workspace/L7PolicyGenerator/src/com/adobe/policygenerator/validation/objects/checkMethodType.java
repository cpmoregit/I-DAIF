package com.adobe.policygenerator.validation.objects;

public class checkMethodType {
	
	private static final String CHECK_GET_METHOD="<L7p:ComparisonAssertion><L7p:Expression1 stringValue=\"${request.http.method}\"/><L7p:Expression2 stringValue=\"GET\"/><L7p:Predicates predicates=\"included\"><L7p:item binary=\"included\"><L7p:RightValue stringValue=\"GET\"/></L7p:item></L7p:Predicates></L7p:ComparisonAssertion>";
	private static final String CHECK_POST_METHOD="<L7p:ComparisonAssertion><L7p:Expression1 stringValue=\"${request.http.method}\"/><L7p:Expression2 stringValue=\"POST\"/><L7p:Predicates predicates=\"included\"><L7p:item binary=\"included\"><L7p:RightValue stringValue=\"POST\"/></L7p:item></L7p:Predicates></L7p:ComparisonAssertion>";

	private String methodType = "GET";
	
	public checkMethodType(String newMethodType){
		methodType = newMethodType;
	}
	
	public String toL7XML(){
		
		String returnValue = CHECK_GET_METHOD;
		if(methodType.trim().equalsIgnoreCase("POST")){
			returnValue = CHECK_POST_METHOD;
		}
		
		return returnValue;
	}

}
