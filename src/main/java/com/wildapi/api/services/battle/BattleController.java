package com.wildapi.api.services.battle;

import com.wildapi.api.services.task.Task;
import com.wildapi.api.services.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battles")
public class BattleController {
    @Autowired
    BattleService service;

    @GetMapping()
    public List<Battle> getTasks(){
        return service.getAll();
    }


    @PostMapping()
    public Battle postTask(@RequestBody Battle battle) {
        return service.save(battle);
    }

    @PutMapping("/{id}")
    public Battle putTask(@PathVariable("id") Long id, @RequestBody Battle battle) {
        return service.update(battle, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") Long id){
        service.delete(id);
    }
}
