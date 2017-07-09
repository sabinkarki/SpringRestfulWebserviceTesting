package com.webservice.test.restfulWebserviceTesting.data.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.webservice.test.restfulWebserviceTesting.models.Address;
import com.webservice.test.restfulWebserviceTesting.models.Person;
import com.webservice.test.restfulWebserviceTesting.repositories.PersonRepository;

@Configuration
public class UserMockData {
	private static final Logger logger = LoggerFactory.getLogger(UserMockData.class);

	/*
	 * When you want to execute some piece of code exactly before the
	 * application startup completes, We can use it
	 */
	@Bean
	public CommandLineRunner setUp(PersonRepository personRepository) {
		return (args) -> {
			personRepository.save(new Person("Sabin", "Software Developer",
					new Address("MeadowCreek Drive", "1110", "Irving Texas", "12345")));
			personRepository
					.save(new Person("Nikita", "Lawyer", new Address("Dallas Drive", "1269", "Dallas Texas", "78569")));
			personRepository.save(
					new Person("Jack", "DBA", new Address("Washington PKWY", "8914", "Maclean Virgina ", "89567")));
			personRepository.save(new Person("Baklol", " Software Tester",
					new Address("Jonh F Carpenter Street", "1550", "Las-Colinas Texas", "10256")));
			logger.info("Sample Data Generated");
		};

	}
}
