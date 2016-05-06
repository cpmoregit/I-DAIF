package com.adobe.policygenerator.assertion;

import com.adobe.policygenerator.service.L7JSonPassThroughService.IL7OBJECT;

public class L7Comment implements IL7OBJECT{
	
	private final static String COMMENT_START="<L7p:CommentAssertion>";
	private final static String COMMENT_END="</L7p:CommentAssertion>";
	
	private String comment;
	
	public L7Comment(String newComment){
		comment = newComment;
	}
	
	
	public String toL7XML(){
		
		StringBuffer commentBuffer = new StringBuffer();
		commentBuffer.append(COMMENT_START);
		commentBuffer.append("<L7p:Comment stringValue=\"");
		commentBuffer.append(comment);
		commentBuffer.append("\"/>");
		commentBuffer.append(COMMENT_END);
		
		return commentBuffer.toString();
		
	}
	
	public static void main(String[] args) {
		 System.out.println((new L7Comment("in.ErrorMessage")).toL7XML());
	}

}
