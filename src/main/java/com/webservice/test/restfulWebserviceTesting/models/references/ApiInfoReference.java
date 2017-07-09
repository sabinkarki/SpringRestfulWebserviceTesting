package com.webservice.test.restfulWebserviceTesting.models.references;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api")
public class ApiInfoReference {
	private Map<String, String> info = new HashMap<>();

	public Map<String, String> getInfo() {
		return this.info;
	}

	public void setInfo(Map<String, String> info) {
		this.info = info;
	}

	public String getInfo(String key) {
		return this.info.get(key);
	}
}
