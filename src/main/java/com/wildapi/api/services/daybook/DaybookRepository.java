package com.wildapi.api.services.daybook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DaybookRepository extends JpaRepository<Daybook, Long> {

    List<Daybook> findAllByDateGreaterThanEqualAndDateLessThanEqual(Date start, Date end);
}
