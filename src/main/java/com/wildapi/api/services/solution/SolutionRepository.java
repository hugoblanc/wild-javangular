package com.wildapi.api.services.solution;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    public List<Solution> findByBattleId(Long id);
}
