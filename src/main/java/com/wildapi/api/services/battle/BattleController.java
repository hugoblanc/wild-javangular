package com.wildapi.api.services.battle;

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
    public List<Battle> getBattle(){
        return service.getAll();
    }


    @PostMapping()
    public Battle postBattle(@RequestBody Battle battle) {
        return service.save(battle);
    }

    @PutMapping("/{id}")
    public Battle putBattle(@PathVariable(value = "id") Long id, @RequestBody Battle battle) {
        return service.update(battle, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBattle(@PathVariable(value = "id") long id) {
        service.delete(id);
    }
}
