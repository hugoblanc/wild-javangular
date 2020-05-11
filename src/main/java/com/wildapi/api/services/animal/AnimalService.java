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


    public Animal update(Animal animal, String name) {

        Optional<Animal> optionalAnimal = repository.findByScientificName(animal.getScientificName());
        // petit soucis ici, je ne comprends pas pourquoi.
        Animal entity = optionalAnimal.get();
        this.modelMapper.map(animal, entity);

        return repository.save(entity);
    }


    public void delete(String name) {
        Animal animal = (Animal) getByScientificName(name);
        repository.deleteById(animal.getId());
    }
}
