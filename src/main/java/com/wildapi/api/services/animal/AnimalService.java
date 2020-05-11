package com.wildapi.api.services.animal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AnimalRepository repository;

    public List<Animal> getAll() {
        return repository.findAll();
    }


    public List<Animal> getByScientificName(String scientificName) {
        return repository.findByScientificName(scientificName);
    }


    public Animal save(Animal animal) {
        return repository.save(animal);
    }


    public void delete(long id) {
        repository.deleteById(id);
    }
}
