package de.codingclover.petbuddy.persistence.entity;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Animal implements AnimalInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String breed;

    private String species;

    private LocalDate dateOfBirth;

    @Override
    public Period getAge() {
        var now = LocalDate.now(Clock.systemDefaultZone());
        return Period.between(dateOfBirth, now);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getSpecies() {
        return this.species;
    }

}
