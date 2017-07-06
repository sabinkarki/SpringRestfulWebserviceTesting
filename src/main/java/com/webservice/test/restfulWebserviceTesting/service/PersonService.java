package com.webservice.test.restfulWebserviceTesting.service;

import java.util.List;

import com.webservice.test.restfulWebserviceTesting.Model.Person;

public interface PersonService {

	public List<Person> getAllPerson();

	public Person getPersonById(long id);

	public Person savePerson(Person person);

	public void removePerson(Person person);

	public Person updatePerson(Person person);

}