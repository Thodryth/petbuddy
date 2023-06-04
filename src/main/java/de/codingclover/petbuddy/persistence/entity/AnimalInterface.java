package de.codingclover.petbuddy.persistence.entity;

import java.time.LocalDate;
import java.time.Period;

interface AnimalInterface {

    public Long getId();

    public String getName();

    public Period getAge();

    public LocalDate getDateOfBirth();

    public String getBreed();

    public String getSpecies();
}
