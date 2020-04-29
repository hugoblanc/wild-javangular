package com.wildapi.api.services.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {


    public List<Animal> findByScientificName(String name);
}
