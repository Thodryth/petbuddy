package de.codingclover.petbuddy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.codingclover.petbuddy.controller.dto.AnimalDTO;
import de.codingclover.petbuddy.persistence.entity.Animal;

@Service
public class ObjectMapper {

    public AnimalDTO toDto(Animal animal) {
        var animalDTO = new AnimalDTO();
        animalDTO.setBirthday(animal.getBirthday() != null ? animal.getBirthday() : null);
        animalDTO.setBreed(animal.getBreed() != null ? animal.getBreed() : null);
        animalDTO.setName(animal.getName() != null ? animal.getName() : null);
        animalDTO.setOwner(animal.getOwner() != null ? animal.getOwner() : null);
        animalDTO.setSpecies(animal.getSpecies() != null ? animal.getSpecies() : null);
        return animalDTO;
    }

    public Animal toEntity(AnimalDTO animalDTO) {
        var animal = new Animal();
        animal.setBirthday(animalDTO.getBirthday() != null ? animalDTO.getBirthday() : null);
        animal.setBreed(animalDTO.getBreed() != null ? animalDTO.getBreed() : null);
        animal.setName(animalDTO.getName() != null ? animalDTO.getName() : null);
        animal.setOwner(animalDTO.getOwner() != null ? animalDTO.getOwner() : null);
        animal.setSpecies(animalDTO.getSpecies() != null ? animalDTO.getSpecies() : null);
        return animal;
    }

    public List<Animal> dtoListToEntityList(List<AnimalDTO> animalDtoList) {
        return animalDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<AnimalDTO> entityListToDtoList(List<Animal> animalList) {
        return animalList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
