package com.wildapi.api.services.algo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlgoRepository extends JpaRepository<Algo, Long> {

    List<Algo> findByBattleId(Long battleId);

}