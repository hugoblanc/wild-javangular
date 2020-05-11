package com.wildapi.api.services.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("select animal from Animal animal where animal.scientific_name = ?1")
    public List<Animal> findByScientific_name(String name);
}
