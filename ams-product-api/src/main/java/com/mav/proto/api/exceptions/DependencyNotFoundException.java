package com.mav.proto.api.exceptions;

public class DependencyNotFoundException extends Exception {
	
	public DependencyNotFoundException(Class clazz){
		super("Dependency Not Found for interface : " +clazz.getName());
	}
}
