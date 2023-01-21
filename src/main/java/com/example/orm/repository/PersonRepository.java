package com.example.orm.repository;

import com.example.orm.exception.NotFountPersonException;
import com.example.orm.model.Person;
import com.example.orm.model.PersonId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional

    public void setPersonToDb() {
        List<Person> persons = Arrays.asList(
                new Person(new PersonId("Vasya", "Ivaniv", 23), "794444444", "Moscow"),
                new Person(new PersonId("Petya", "Ivaniv", 21), "793333333", "Spb"),
                new Person(new PersonId("Vova", "Ivaniv", 24), "79222222222", "Volgograd"),
                new Person(new PersonId("Vitya", "Ivaniv", 28), "7911111111", "Moscow"),
                new Person(new PersonId("Olya", "Ivanivich", 21), "7911222222", "Moscow")
        );

        for (Person person : persons) {
            Person existingPerson = entityManager.find(Person.class, person.getId());
            if (existingPerson == null) {
                entityManager.persist(person);
                log.info("person " + person.getId() + " saved");
            } else {
                log.info("person: " + person.getId() + " already exists in the database");
            }
        }
    }

    @Transactional
    public Optional<List<Person>> getPersonsByCity(String city) {
        String query = "SELECT p FROM Person p WHERE p.cityOfLiving = :city";
        TypedQuery<Person> typedQuery = entityManager.createQuery(query, Person.class);
        typedQuery.setParameter("city", city);
        return Optional.ofNullable(typedQuery.getResultList());

    }
}



