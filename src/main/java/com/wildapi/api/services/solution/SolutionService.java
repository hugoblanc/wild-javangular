package com.wildapi.api.services.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionService {
    @Autowired
    SolutionRepository repository;

    public List<Solution> findByBattleId(Long battleId) {
        return repository.findByBattleId(battleId);
    }

    public Solution save(Solution solution) {
        return repository.save(solution);
    }
}
