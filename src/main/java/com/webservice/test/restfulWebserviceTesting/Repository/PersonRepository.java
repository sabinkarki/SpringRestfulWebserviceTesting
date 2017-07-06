package com.webservice.test.restfulWebserviceTesting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.test.restfulWebserviceTesting.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
