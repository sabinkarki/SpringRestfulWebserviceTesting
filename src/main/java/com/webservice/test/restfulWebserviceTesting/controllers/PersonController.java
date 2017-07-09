/**
 * 
 */
package com.webservice.test.restfulWebserviceTesting.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.test.restfulWebserviceTesting.exceptions.CustomException;
import com.webservice.test.restfulWebserviceTesting.models.Person;
import com.webservice.test.restfulWebserviceTesting.responses.Response;
import com.webservice.test.restfulWebserviceTesting.services.PersonService;

import io.swagger.annotations.ApiParam;

/**
 * @author sabin
 *
 */

@RestController
@RequestMapping(value = "/api")
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/")
	public String getHome() {
		return "My name is Sabin Karki";
	}

	@RequestMapping(value = "persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPerson() {
		logger.info("All persons listed");
		List<Person> persons = personService.getAllPerson();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "persons/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(
			@ApiParam(value = "Id of person", required = true) @PathVariable("id") long id) throws CustomException {
		Person person = personService.getPersonById(id);
		if (person == null) {
			throw new CustomException("Person with provided id:" + id + " not found");
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "persons/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removePersonById(
			@ApiParam(value = "Id of person to be deleted", required = true) @PathVariable("id") long id)
			throws CustomException {
		Person person = personService.getPersonById(id);
		if (person == null) {
			throw new CustomException("Person with provided id:" + id + " cannot be deleted");
		}
		personService.removePerson(person);
		logger.info("Person deleted successfully");
		Response response = new Response(HttpStatus.OK.value(), "Person has been deleted");
		return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public ResponseEntity<Person> addPerson(
			@ApiParam(value = "Request Body for Person", required = true) @Validated @RequestBody Person person) {
		Person tempPerson = personService.savePerson(person);
		logger.info("Person added in the database");
		return new ResponseEntity<Person>(tempPerson, HttpStatus.CREATED);
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.PUT)
	public ResponseEntity<Person> updatePerson(
			@ApiParam(value = "Request Body for Person", required = true) @Validated @RequestBody Person person)
			throws CustomException {
		Person tempPerson = personService.getPersonById(person.getId());
		if (tempPerson == null) {
			throw new CustomException("Person with provided id:" + person.getId() + "cannot be updated");
		}
		logger.info("Person with provided id" + tempPerson.getId() + " updated");
		return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.OK);
	}

}
