package com.webservice.test.restfulWebserviceTesting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.test.restfulWebserviceTesting.Model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
