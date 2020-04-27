package com.wildapi.api.services.battle;

import com.wildapi.api.services.algo.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleService {

    @Autowired BattleRepository repository;

    public List<Battle> getAll(){
        return repository.findAll();
    }

    public Battle save(Battle battle) {
        battle.algoList = initEmptyAlgo(battle, 5);
        return repository.save(battle);
    }

    private List<Algo> initEmptyAlgo(Battle battle, int nbAlgo) {
        List<Algo> algos = new ArrayList<>();
        for (int i = 0; i < nbAlgo; i++) {
            Algo algo = new Algo();
            algo.setTitle("Algo " + i);
            algo.setBattle(battle);
            algos.add(algo);
        }
        return algos;
    }

    public Battle update(Battle battle, Long id) {
        System.out.println(id);
        System.out.println(battle.getId());
        if (battle.getId().equals(id)) {
            System.out.println("Is equal");
        }
        return repository.save(battle);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
