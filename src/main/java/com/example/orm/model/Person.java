package com.example.orm.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Persons")
@IdClass(PersonId.class)
public class Person {
    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @Column(name = "City_of_Living")
    private String cityOfLiving;

}


