package com.wildapi.api.services.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgoService {


    @Autowired AlgoRepository repository;


    public List<Algo> getAll(){
        return repository.findAll();
    }

    public Algo save(Algo algo) { return repository.save(algo); }

    public Algo update(Algo algo) {
        return repository.save(algo);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}