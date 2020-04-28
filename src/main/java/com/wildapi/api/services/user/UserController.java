package com.wildapi.api.services.user;

import com.wildapi.api.core.security.UserAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {


    @GetMapping("/me")
    User getResult() {
        UserAuthentication userAuth = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        User user = (User) userAuth.getPrincipal();
        return user;
    }

}
