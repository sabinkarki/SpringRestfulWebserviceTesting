package com.webservice.test.restfulWebserviceTesting.configs;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.webservice.test.restfulWebserviceTesting.models.references.ApiInfoReference;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagerConfig {

	@Autowired
	private ApiInfoReference apiInfoReference;

	/*
	 * Docket bean in a Spring Boot configuration to configure Swagger 2 for the
	 * application. A Springfox Docket instance provides the primary API
	 * configuration with sensible defaults and convenience methods for
	 * configuration
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.webservice.test.restfulWebserviceTesting.controller"))
				.paths(PathSelectors.ant("/**")).build();

		/* paths(PathSelectors.any()) */

	}

	// Swagger configuration is applied only following regex
	private Predicate<String> postPaths() {
		return or(regex("/api/*"), regex("/api/secure*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(this.apiInfoReference.getInfo("title"))
				.description(this.apiInfoReference.getInfo("description"))
				.version(this.apiInfoReference.getInfo("apiVersion")).build();
	}

}
