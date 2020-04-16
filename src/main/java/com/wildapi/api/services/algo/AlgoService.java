package com.wildapi.api.services.algo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlgoService {


    @Autowired AlgoRepository repository;


    public List<Algo> getAll(){
        return repository.findAll();
    }

    public Algo save(Algo algo) { return repository.save(algo); }

    public Algo update(Algo algo, Long id) {
        if(algo.getId() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }
        return repository.save(algo);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}