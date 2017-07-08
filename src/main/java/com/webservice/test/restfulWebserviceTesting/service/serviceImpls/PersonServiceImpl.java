package com.webservice.test.restfulWebserviceTesting.service.serviceImpls;

/**
@author sabin
*/

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.test.restfulWebserviceTesting.models.Person;
import com.webservice.test.restfulWebserviceTesting.repositories.PersonRepository;
import com.webservice.test.restfulWebserviceTesting.services.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void removePerson(Person person) {
		personRepository.delete(person);

	}

}
