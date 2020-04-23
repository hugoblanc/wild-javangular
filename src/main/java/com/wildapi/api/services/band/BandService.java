package com.wildapi.api.services.band;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    @Autowired BandRepository repository;


    List<Band> getAll(){
        return repository.findAll();
    }


    Band save(Band band){
        return repository.save(band);
    }

    Band update(Band band){
        return repository.save(band);
    }


    void delete(Long id){
        repository.deleteById(id);
    }
}
