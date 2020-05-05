package com.wildapi.api.services.battle;

import com.wildapi.api.services.algo.Algo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BattleService {

    @Autowired
    BattleRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public List<Battle> getAll() {
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

    public Battle update(BattlePutDTO battlePutDTO, Long id) {
        System.out.println(id);
        System.out.println(battlePutDTO.getId());
        if (battlePutDTO.getId().equals(id)) {
            System.out.println("Is equal");
        }


        Optional<Battle> battleOptional = repository.findById(battlePutDTO.getId());
        Battle entity = battleOptional.get();
        this.modelMapper.map(battlePutDTO, entity);

        return repository.save(entity);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
