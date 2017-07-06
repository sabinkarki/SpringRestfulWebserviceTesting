package com.webservice.test.restfulWebserviceTesting.service;
/**
@author sabin
*/

import java.util.List;

import com.webservice.test.restfulWebserviceTesting.model.Person;

public interface PersonService {

	public List<Person> getAllPerson();

	public Person getPersonById(long id);

	public Person savePerson(Person person);

	public void removePerson(Person person);

}
