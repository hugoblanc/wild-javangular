package com.wildapi.api.services.battle;

import com.wildapi.api.services.algo.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BattleService {

    @Autowired BattleRepository repository;

    public List<Battle> getAll(){
        return repository.findAll();
    }

    public Battle save(Battle battle) { return repository.save(battle); }

    public Battle update(Battle battle, Long id) {
        if(battle.getId() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }
        return repository.save(battle);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
