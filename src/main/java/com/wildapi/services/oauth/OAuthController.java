package com.wildapi.services.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("oauth")
public class OAuthController {


    @GetMapping()
    String setupOAuth(@RequestParam(name = "code") String code){
        
    }

}