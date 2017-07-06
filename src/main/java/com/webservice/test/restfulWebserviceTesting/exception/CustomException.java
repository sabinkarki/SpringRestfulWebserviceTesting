/**
 @author sabin
 */
package com.webservice.test.restfulWebserviceTesting.exception;

//When controller throws CustomException it first call this class and then only @ControllerAdvice is called
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public CustomException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
