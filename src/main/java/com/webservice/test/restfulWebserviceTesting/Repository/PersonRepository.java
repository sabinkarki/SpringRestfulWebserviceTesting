package com.webservice.test.restfulWebserviceTesting.repository;

/**
@author sabin
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.test.restfulWebserviceTesting.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
