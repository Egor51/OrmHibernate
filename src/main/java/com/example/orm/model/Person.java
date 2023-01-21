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
public class Person {
    @EmbeddedId
    private PersonId id;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @Column(name = "City_of_Living")
    private String cityOfLiving;

    @Override
    public String toString() {
        return "Person{" +
                "person=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}


