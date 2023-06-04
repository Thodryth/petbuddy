package de.codingclover.petbuddy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.codingclover.petbuddy.persistence.entity.Animal;
import de.codingclover.petbuddy.persistence.repository.AnimalRepository;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        return this.animalRepository.save(animal);
    }

    public List<Animal> findAll() {
        return this.animalRepository.findAll();
    }

    public List<Animal> findAllByOwner(String owner) {
        return this.animalRepository.findAllByOwner(owner);
    }

}
