package com.webservice.test.restfulWebserviceTesting.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ValidationErrorRespose extends ExceptionErrorResponse {
	private String errorType;
	private List<ModelError> errors;

	public ValidationErrorRespose() {
		errors = new ArrayList<>();
	}

	public void setErrorCode(int errorCode) {
		super.setErrorCode(errorCode);
	}

	public int getErrorCode() {
		return super.getErrorCode();
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public void setsetMessage(String message) {
		super.setMessage(message);

	}

	public String getMessage() {
		return super.getMessage();
	}

	public void addError(ModelError error) {
		this.errors.add(error);
	}

	public List<ModelError> getErrors() {
		return errors;
	}

	public void setErrors(List<ModelError> errors) {
		this.errors = errors;
	}

}
