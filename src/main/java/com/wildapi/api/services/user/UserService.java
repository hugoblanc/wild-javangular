package com.wildapi.api.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserRepository repository;


    public User saveUser(User user){
        return repository.save(user);
    }
}
