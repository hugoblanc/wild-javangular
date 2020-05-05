package com.wildapi.api.services.band;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Long> {

    public List<Band> findByIdUser(Long userId);
}
