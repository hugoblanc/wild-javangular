package com.wildapi.api.core.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends GenericFilterBean {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);


    private JwtAuthenticationService service;

    public JwtAuthorizationFilter(JwtAuthenticationService service) {
        this.service = service;
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        SecurityContextHolder.getContext().setAuthentication(
                service.getAuthentication((HttpServletRequest) req, (HttpServletResponse) res));
        chain.doFilter(req, res);
    }

}