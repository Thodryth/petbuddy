package de.codingclover.petbuddy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.codingclover.petbuddy.controller.dto.AnimalDTO;
import de.codingclover.petbuddy.service.AnimalService;
import de.codingclover.petbuddy.service.ObjectMapper;

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
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> findAllAnimals() {
        var animalList = this.animalService.findAll();
        return animalDtoMapper.entityListToDtoList(animalList);
    }

    @PostMapping("/animal")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDTO saveAnimal(@RequestBody AnimalDTO animalDTO) {
        var animal = this.animalDtoMapper.toEntity(animalDTO);
        animal = this.animalService.saveAnimal(animal);
        return animalDtoMapper.toDto(animal);
    }

    @GetMapping("/animals/{owner}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> findAllAnimalsByOwner(@PathVariable String owner) {
        var animalList = this.animalService.findAllByOwner(owner);
        return animalDtoMapper.entityListToDtoList(animalList);
    }
}
