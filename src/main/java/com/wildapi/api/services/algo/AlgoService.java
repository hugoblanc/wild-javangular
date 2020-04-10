package com.wildapi.api.services.algo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgoService {


    @Autowired AlgoRepository repository;


    public List<Algo> getAll(){
        return repository.findAll();
    }

}