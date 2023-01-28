package com.example.orm.repository;

import com.example.orm.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person,Long> {
    Optional<List<Person>> findAllByCityOfLiving(String city);

    Optional<List<Person>> findAllByAge(int age);

    Optional<Person> findAllByNameAndSurname(String name, String surname);
}
