package com.wildapi.api.services.algo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/algos")
public class AlgoController {
    @Autowired AlgoService service;

    @GetMapping()
    public List<Algo> getAlgos(){
        return service.getAll();
    }

    @PostMapping()
    public Algo createAlgo(@RequestBody Algo algo ){
        return service.save(algo);
    }

    @PutMapping("/{id}")
    public Algo updateAlgo(@RequestBody Algo algo, @PathVariable Long id){ return service.update(algo, id); }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAlgo(@PathVariable Long id){ service.delete(id); }
}