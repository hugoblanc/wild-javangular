package com.wildapi.api.services.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    MusicService service;


    @GetMapping
    public List<Music> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Music getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Music save(@Valid @RequestBody Music music) {

        if (music.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "L'id doit pas être présent", new Exception());
        }

        return service.save(music);
    }

    @PutMapping
    public Music update(@Valid @RequestBody Music music) {
        return service.save(music);
    }
}
