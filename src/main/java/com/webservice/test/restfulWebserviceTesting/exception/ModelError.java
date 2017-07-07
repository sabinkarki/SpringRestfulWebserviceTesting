package com.webservice.test.restfulWebserviceTesting.exception;

public class ModelError {
	private String message;
	private String errorField;

	public ModelError() {
	}

	public ModelError(String errorField, String message) {
		this.errorField = errorField;
		this.message = message;
	}

	public String getErrorField() {
		return errorField;
	}

	public void setErrorField(String errorField) {
		this.errorField = errorField;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
