package com.webservice.test.restfulWebserviceTesting.responses;

import org.springframework.stereotype.Component;

@Component
public class Response {
	private int value;
	private String message;
	

	public Response() {
	}

	public Response(int value, String message) {
		super();
		this.value = value;
		this.message = message;

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
