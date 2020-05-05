package com.wildapi.api.services.daybook;

import com.wildapi.api.core.security.UserAuthentication;
import com.wildapi.api.services.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DaybookService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DaybookRepository repository;

    public List<Daybook> getAll(Date startDate, Date endDate) {
        List<Daybook> daybooks;
        UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        Long userId = userAuthentication.getUser().getId();
        if (startDate != null && endDate != null) {
            daybooks = repository.findAllByDateGreaterThanEqualAndDateLessThanEqualAndCreatorId(startDate, endDate, userId);
        } else {
            daybooks = repository.findByCreatorId(userId);
        }
        return daybooks;
    }

    public Daybook save(Daybook daybook) {
        return repository.save(daybook);
    }


    public Daybook initEmptyDaybookForUser(User user) {
        Daybook daybook = new Daybook();
        return repository.save(daybook);
    }

    public Daybook update(DaybookPutDTO daybook, Long id) {
        Optional<Daybook> daybookFromSrv = repository.findById(daybook.getId());
        Daybook entity = daybookFromSrv.get();
        this.modelMapper.map(daybook, entity);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
