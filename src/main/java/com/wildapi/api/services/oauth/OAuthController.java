package com.wildapi.api.services.oauth;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.wildapi.api.services.user.User;
import com.wildapi.api.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oauth")
public class OAuthController {

    @Autowired
    OAuthService oAuthService;

    @Autowired
    UserService userService;

    @GetMapping()
    Object setupOAuth(@RequestParam(name = "code") String code){
        System.out.println("Le super code renvoyé");
        System.out.println(code);

        User user = this.oAuthService.handleOAuthCallback(code);
        return userService.saveUser(user);
    }

    @GetMapping("/odyssey")
    public void redirect(HttpServletResponse httpResponse) {
        try {
            httpResponse.sendRedirect(
                    "https://odyssey.wildcodeschool.com/oauth/authorize?client_id=fc3dfb1962ce7fcdb7b7958e9c6928e78ed030deb8462f7ef9e8db5f47301b5c&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}