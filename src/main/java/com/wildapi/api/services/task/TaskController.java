package com.wildapi.api.services.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired TaskService service;

    @GetMapping()
    public List<Task> getTasks(){
        return service.getAll();
    }


    @PostMapping()
    public Task postTask(@RequestBody Task task) {
        return service.save(task);
    }

    @PutMapping("/{id}")
    public Task putTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return service.update(task, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") Long id){
        service.delete(id);
    }

}


