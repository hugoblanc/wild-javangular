package com.wildapi.api.services.daybook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class DaybookService {

    @Autowired
    DaybookRepository repository;

    public List<Daybook> getAll(Date startDate, Date endDate) {
        List<Daybook> daybooks;
        if (startDate != null && endDate != null) {
            daybooks = repository.findAllByDateGreaterThanEqualAndDateLessThanEqual(startDate, endDate);
        } else {
            daybooks = repository.findAll();
        }
        return daybooks;
    }

    public Daybook save(Daybook daybook) {
        return repository.save(daybook);
    }

    public Daybook update(Daybook daybook, Long id) {
        if (daybook.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }
        return repository.save(daybook);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
