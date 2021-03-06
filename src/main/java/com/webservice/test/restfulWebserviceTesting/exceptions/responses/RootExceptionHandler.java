package com.webservice.test.restfulWebserviceTesting.exceptions.responses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
/**
@author sabin
*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webservice.test.restfulWebserviceTesting.exceptions.CustomException;
import com.webservice.test.restfulWebserviceTesting.exceptions.ModelError;
import com.webservice.test.restfulWebserviceTesting.exceptions.ValidationErrorRespose;
import com.webservice.test.restfulWebserviceTesting.models.references.ErrorReference;

@ControllerAdvice
public class RootExceptionHandler {

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@Autowired
	private ErrorReference errorReference;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorRespose> handleErrors(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		ValidationErrorRespose errResponse = new ValidationErrorRespose();
		errResponse.setErrorCode(422);
		errResponse.setErrorType("Validation Error");
		errResponse.setMessage(errorReference.getDescription().get("EXC400"));
		fieldErrors.forEach(fieldError -> {
			ModelError error = new ModelError(fieldError.getField(), messageSourceAccessor.getMessage(fieldError));
			errResponse.addError(error);
		});
		return new ResponseEntity<ValidationErrorRespose>(errResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionErrorResponse> customExceptionHandler(CustomException ex) {
		ExceptionErrorResponse error = new ExceptionErrorResponse();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getErrorMessage());
		return new ResponseEntity<ExceptionErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionErrorResponse> exceptionHandler(Exception ex) {
		ExceptionErrorResponse error = new ExceptionErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage("BAD request");
		return new ResponseEntity<ExceptionErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
