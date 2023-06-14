package de.codingclover.petbuddy.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.codingclover.petbuddy.persistence.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAllByOwner(String owner);

}
