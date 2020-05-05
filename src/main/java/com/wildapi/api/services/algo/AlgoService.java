package com.wildapi.api.services.algo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlgoService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AlgoRepository repository;


    public List<Algo> getAll() {
        return repository.findAll();
    }

    public List<Algo> getAlgosByBattleId(Long battleId) {
        return repository.findByBattleId(battleId);
    }

    public Algo save(Algo algo) {
        return repository.save(algo);
    }

    public Algo update(AlgoPutDTO algoPutDTO) {

        Optional<Algo> optionalAlgo = repository.findById(algoPutDTO.getId());
        Algo entity = optionalAlgo.get();
        this.modelMapper.map(algoPutDTO, entity);

        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}