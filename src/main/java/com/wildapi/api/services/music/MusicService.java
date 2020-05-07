package com.wildapi.api.services.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepository repository;


    public List<Music> findAll() {
        return repository.findAll();
    }

    public Music findById(Long id) {
        return repository.findById(id).get();
    }

    public Music save(Music music) {
        return repository.save(music);
    }

    public Music update(Music music) {
        return repository.save(music);
    }

}
