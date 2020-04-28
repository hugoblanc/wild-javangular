package com.wildapi.api.core.security;

import com.wildapi.api.services.user.User;
import com.wildapi.api.services.user.UserService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class JwtAuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    private static final String AUTH_HEADER_NAME = "Authorization";

    @Autowired
    UserService userService;


    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isEmpty() && token.startsWith("Bearer ")) {
            try {
                String signingKey = "tutututu";

                Object o = Jwts.parser()
                        .setSigningKey(signingKey)
                        .parseClaimsJws(token.replace("Bearer ", "")).getBody();

                String email = Jwts.parser()
                        .setSigningKey(signingKey)
                        .parseClaimsJws(token.replace("Bearer ", "")).getBody().getSubject().toString();


                UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(o, null);

                User user = userService.findByEmail(email);
                if (user == null) {
                    return null;
                }
                return new UserAuthentication(user);

//                var authorities = ((List<?>) parsedToken.getBody()
//                        .get("rol")).stream()
//                        .map(authority -> new SimpleGrantedAuthority((String) authority))
//                        .collect(Collectors.toList());
//
//                if (StringUtils.isNotEmpty(username)) {
//                    return new UserAuth(username, null, authorities);
//                }
            } catch (ExpiredJwtException exception) {
                log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
            } catch (UnsupportedJwtException exception) {
                log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
            } catch (MalformedJwtException exception) {
                log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
            } catch (SignatureException exception) {
                log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
            } catch (IllegalArgumentException exception) {
                log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
            }
        }
        return null;
    }
}
