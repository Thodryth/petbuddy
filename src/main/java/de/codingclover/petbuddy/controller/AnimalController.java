package de.codingclover.petbuddy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.codingclover.petbuddy.controller.dto.AnimalDTO;
import de.codingclover.petbuddy.service.ObjectMapper;
import de.codingclover.petbuddy.service.AnimalService;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {

    private AnimalService animalService;

    private ObjectMapper animalDtoMapper;

    AnimalController(AnimalService animalService, ObjectMapper animalDtoMapper) {
        this.animalService = animalService;
        this.animalDtoMapper = animalDtoMapper;
    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AnimalDTO> findAllAnimals() {
        var animalList = this.animalService.findAllAnimals();
        return animalDtoMapper.entityListToDtoList(animalList);
    }

    @PostMapping("/animal")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDTO saveAnimal(@RequestBody AnimalDTO animalDTO) {
        var animal = this.animalDtoMapper.toEntity(animalDTO);
        animal = this.animalService.saveAnimal(animal);
        return animalDtoMapper.toDto(animal);
    }
}
