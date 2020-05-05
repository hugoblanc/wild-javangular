package com.wildapi.api.services.task;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    @Autowired
    ModelMapper modelMapper;


    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }


    public Task update(TaskPutDTO task, Long id) {

        if (task.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<Task> optionalAlgo = repository.findById(task.getId());
        Task entity = optionalAlgo.get();
        this.modelMapper.map(task, entity);

        return repository.save(entity);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}


