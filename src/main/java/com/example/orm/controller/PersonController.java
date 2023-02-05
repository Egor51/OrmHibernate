package com.example.orm.controller;

import com.example.orm.model.Person;
import com.example.orm.service.PersonService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RolesAllowed({"ROLE_READ"})
    @GetMapping("/persons/by-city/")
    public Optional<List<Person>> getPerson(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }

    @Secured({"ROLE_WRITE"})
    @GetMapping("/persons/by-age/")
    public Optional<List<Person>> findPersonByAge(@RequestParam int age) {
        return personService.getPersonByAge(age);
    }

    @PreAuthorize("hasRole('ROLE_DELET')")
    @GetMapping("/persons/by-name/")
    public Optional<Person> findPersonByAge(@RequestParam String name,
                                            @RequestParam String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/user/")
    @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<String> getUser(@RequestParam("username") String username) {
        return ResponseEntity.ok("User information for " + username);
    }
}


