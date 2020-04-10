package com.wildapi.api.services.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired TaskRepository repository;


    public List<Task> getAll(){
        return repository.findAll();
    }

    public Task save(Task task){
        return repository.save(task);
    }


}


