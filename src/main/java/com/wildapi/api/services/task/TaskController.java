package com.wildapi.api.services.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired TaskService service;

    @GetMapping()
    public List<Task> findTasks(){
        return service.getAll();
    }


    @PostMapping()
    public Task postMethodName(@RequestBody Task task) {
        return service.save(task);
    }
    
}


