package com.wildapi.api.services.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solutions")
public class SolutionController {

    @Autowired
    SolutionService service;

    @GetMapping("/battle/{battleId}")
    public List<Solution> getByBattleId(@PathVariable("battleId") Long battleId) {
        return service.findByBattleId(battleId);
    }

    @PostMapping
    public Solution postSolution(@RequestBody Solution solution) {
        return service.save(solution);
    }

}
