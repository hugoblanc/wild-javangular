package com.wildapi.api.services.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalService service;

    @GetMapping()
    public List<Animal> getAnimals() {
        return service.getAll();
    }

    @GetMapping("/{name}")
    public List<Animal> getByName(@PathVariable(value = "name") String name) {
        return service.getByScientificName(name);
    }

    @PostMapping()
    public Animal postTask(@RequestBody Animal animal) {
        return service.save(animal);
    }

    @PutMapping("/{name}")
    public Animal updateAnimal(@RequestBody Animal animal, @PathVariable(value = "name") String name) {
        return service.update(animal, name);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAnimal(@PathVariable(value = "name") String name) {
        service.delete(name);
    }

}
