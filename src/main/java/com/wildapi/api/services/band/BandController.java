package com.wildapi.api.services.band;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
public class BandController {

    @Autowired
    BandService service;

    @GetMapping()
    public List<Band> getBands() {
        return service.getAll();
    }


    @GetMapping("/user/{id}")
    public List<Band> getBandByUserId(@PathVariable("id") Long userId) {
        return service.getByUserId(userId);
    }


    @PostMapping()
    public Band postBands(@RequestBody Band band) {
        return service.save(band);
    }

    @PutMapping("/{id}")
    public Band putBand(@PathVariable("id") Long id, @RequestBody Band band) {
        return service.update(band);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBand(@PathVariable("id") Long id){
        service.delete(id);
    }


}


