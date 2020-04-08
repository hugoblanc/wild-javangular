package com.wildapi.api.services.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {



    @GetMapping()
    String getResult(){
        return "TOTOT";
    }
}