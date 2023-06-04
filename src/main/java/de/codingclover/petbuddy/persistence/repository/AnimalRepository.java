package de.codingclover.petbuddy.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.codingclover.petbuddy.persistence.entity.Animal;

public interface AnimalRepository extends JpaRepository<Long, Animal> {

}
