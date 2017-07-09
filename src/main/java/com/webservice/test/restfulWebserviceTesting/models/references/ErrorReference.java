package com.webservice.test.restfulWebserviceTesting.models.references;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "errors")
public class ErrorReference {
	private Map<String, String> description = new HashMap<>();

	public Map<String, String> getDescription() {
		return description;
	}

	public void setDescription(Map<String, String> description) {
		this.description = description;
	}

	public String getDescription(String errorCode) {
		return this.description.get(errorCode);
	}

}
