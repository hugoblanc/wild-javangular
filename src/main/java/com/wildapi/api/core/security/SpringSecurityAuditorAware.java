package com.wildapi.api.core.security;

import com.wildapi.api.services.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringSecurityAuditorAware {

    @Bean
    public AuditorAware<User> auditorProvider() {

        return () -> {
            UserAuthentication authentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated()) {
                User anon = new User();
                return Optional.of(anon);
            }
            return Optional.of(authentication.getUser());
        };
    }
}