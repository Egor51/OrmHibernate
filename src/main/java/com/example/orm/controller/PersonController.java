package com.example.orm.controller;

import com.example.orm.exception.NotFountPersonException;
import com.example.orm.model.Person;
import com.example.orm.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/save")
    public void save() {
        personRepository.setPersonToDb();
    }

    @GetMapping("/persons/by-city/")
    public Optional<List<Person>> getPerson(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }
}

