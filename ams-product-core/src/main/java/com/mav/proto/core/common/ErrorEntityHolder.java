package com.mav.proto.core.common;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * 
 * Entity return to return API Error details to API users
 */
public class ErrorEntityHolder {

	
	private String errorCode;
	private String errorMessage;
	
	public ErrorEntityHolder(String errorCode,String errorMessage){
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
