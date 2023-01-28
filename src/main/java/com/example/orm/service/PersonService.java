package com.example.orm.service;

import com.example.orm.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<List<Person>> getPersonByCity(String city);
    Optional<List<Person>> getPersonByAge(int age);
    Optional<Person> getPersonByNameAndSurname(String name,String surname);
}
