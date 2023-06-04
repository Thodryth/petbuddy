package de.codingclover.petbuddy.controller.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {

    private String name;

    private String breed;

    private String species;

    private LocalDate birthday;

    private String owner;

}
