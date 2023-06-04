package de.codingclover.petbuddy.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.codingclover.petbuddy.persistence.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
