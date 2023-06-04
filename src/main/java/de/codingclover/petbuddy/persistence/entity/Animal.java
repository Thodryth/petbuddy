package de.codingclover.petbuddy.persistence.entity;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;

import de.codingclover.petbuddy.controller.dto.AnimalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Animal extends AnimalDTO implements AnimalInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Period getAge() {
        var now = LocalDate.now(Clock.systemDefaultZone());
        return Period.between(this.getBirthday(), now);
    }

}
