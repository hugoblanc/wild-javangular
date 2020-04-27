package com.wildapi.api.services.oauth;

import com.wildapi.api.core.security.jwt.JwtUtil;
import com.wildapi.api.services.user.User;
import com.wildapi.api.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("oauth")
public class OAuthController {


    @Value("${odyssey.callbackUrl}")
    private String callbackUrl;

    @Autowired
    OAuthService oAuthService;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;


    @GetMapping()
    Object setupOAuth(@RequestParam(name = "code") String code, HttpServletResponse httpResponse) {
        System.out.println("Le super code renvoyé");
        System.out.println(code);

        User user = this.oAuthService.handleOAuthCallback(code);

        String token = jwtUtil.generateToken(user);

        try {
            httpResponse.sendRedirect(
                    "http://localhost:4200/auth/" + token);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return userService.saveUser(user);
    }

    @GetMapping("/odyssey")
    public void redirect(HttpServletResponse httpResponse) {

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("client_id", "fc3dfb1962ce7fcdb7b7958e9c6928e78ed030deb8462f7ef9e8db5f47301b5c");
        requestParams.put("response_type", "code");
        requestParams.put("redirect_uri", callbackUrl);

        String encodedURL = requestParams.keySet().stream()
                .map(key -> {
                    String urlParam = "";
                    try {
                        urlParam = key + "=" + encodeValue(requestParams.get(key));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return urlParam;
                })
                .collect(Collectors.joining("&", "https://odyssey.wildcodeschool.com/oauth/authorize?", ""));

        try {
            httpResponse.sendRedirect(encodedURL);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

}