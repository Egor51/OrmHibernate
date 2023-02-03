package com.example.orm.controller;

import com.example.orm.model.Person;
import com.example.orm.service.PersonService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RolesAllowed({"ROLE_USER"})
    @GetMapping("/persons/by-city/")
    public Optional<List<Person>> getPerson(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/persons/by-age/")
    public Optional<List<Person>> findPersonByAge(@RequestParam int age) {
        return personService.getPersonByAge(age);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')||hasRole('ROLE_USER')")
    @GetMapping("/persons/by-name/")
    public Optional<Person> findPersonByAge(@RequestParam String name,
                                            @RequestParam String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }
    @PostAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/hello/")
    public String getHello() {
        return "Hello";
    }
}


