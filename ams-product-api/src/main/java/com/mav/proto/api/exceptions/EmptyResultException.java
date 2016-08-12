package com.mav.proto.api.exceptions;

public class EmptyResultException extends Exception {
	
	public EmptyResultException(){
		super("No records Available!");
	}
	
	public EmptyResultException(String message){
		super(message);
	}
}
