package de.codingclover.petbuddy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import de.codingclover.petbuddy.persistence.repository.AnimalRepository;

public class AnimalServiceTest {

    @Autowired
    private AnimalService animalService;

    @MockBean
    AnimalRepository animalRepository;

    @Test
    void saveAnimal() {

    }

}
