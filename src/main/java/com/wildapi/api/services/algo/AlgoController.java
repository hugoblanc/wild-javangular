package com.wildapi.api.services.algo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/algos")
public class AlgoController {
    @Autowired AlgoService service;

    @GetMapping()
    public List<Algo> getAlgos(){
        return service.getAll();
    }

}