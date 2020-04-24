package com.wildapi.api.core.security.jwt;

import com.wildapi.api.services.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class JwtUtil {

    public String generateToken(User user){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user);

    }

    private String createToken(Map<String, Object> claims, User user) {

        return Jwts.builder().setId(UUID.randomUUID().toString())
                .setSubject(user.getEmail())
                .signWith(SignatureAlgorithm.HS512, "tutututu")
                .claim("user-details", user)
                .compact();
     }

}
