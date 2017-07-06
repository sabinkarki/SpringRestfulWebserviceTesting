package com.webservice.test.restfulWebserviceTesting.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webservice.test.restfulWebserviceTesting.Model.Person;
import com.webservice.test.restfulWebserviceTesting.Repository.PersonRepository;
import com.webservice.test.restfulWebserviceTesting.service.PersonService;

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

	@Override
	public Person updatePerson(Person person) {
		Person personTemp = personRepository.findOne(person.getId());
		if (personTemp != null) {
			personTemp.setAddress(person.getAddress());
			personTemp.setName(person.getName());
			personTemp.setPosition(person.getPosition());
			return personRepository.save(personTemp);
		}
		return null;
	}
}
