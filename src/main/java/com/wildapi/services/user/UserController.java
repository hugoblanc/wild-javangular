package com.wildapi.services.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("users")
public class UserController {



    @GetMapping()
    String getResult(){
        return "TOTOT";
    }
}