package com.mav.proto.api.exceptions;

public class NoMatchingRecordFoundException extends Exception {

	public NoMatchingRecordFoundException(){
		super("No matching record found!");
	}
	
	public NoMatchingRecordFoundException(String message){
		super(message);
	}
}
