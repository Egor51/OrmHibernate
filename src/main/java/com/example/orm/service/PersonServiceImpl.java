package com.example.orm.service;

import com.example.orm.exception.exceptions.NotFountPersonException;
import com.example.orm.model.Person;
import com.example.orm.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Optional<List<Person>>getPersonByCity(String city) {
        return repository.findAllByCityOfLiving(city);
               // .orElseThrow(() -> new NotFountPersonException("Person Not Found")));
    }

    @Override
    @Transactional
    public Optional<List<Person>> getPersonByAge(int age) {
        return repository.findAllByAge(age);
                //.orElseThrow(() -> new NotFountPersonException("Person Not Found")));
    }

    @Override
    @Transactional
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return Optional.of(repository.findAllByNameAndSurname(name, surname)
                .orElseThrow(() -> new NotFountPersonException("Person Not Found")));
    }
}
