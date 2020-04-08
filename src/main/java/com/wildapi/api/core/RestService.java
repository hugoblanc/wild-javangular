package com.wildapi.api.core;

import com.wildapi.api.services.oauth.dto.AskAuthorizationDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public <T> ResponseEntity<T> getObject(String endpointUrl,  Class<T> responseType, String token) {
        HttpHeaders headers = new HttpHeaders();
        if(token != null){
            headers = createBearerHeader(token);
        }
        HttpEntity<T> entity = new HttpEntity<T>(null, headers);
        return this.restTemplate.exchange(endpointUrl, HttpMethod.GET, entity, responseType);
    }


    public <T> T postObject(String endpointUrl, AskAuthorizationDto data, Class<T> responseType){
        HttpEntity<AskAuthorizationDto> request = new HttpEntity<>(data);
        return this.restTemplate.postForObject(endpointUrl, request, responseType);
    }


    private HttpHeaders createBearerHeader(String token)
    {
        String bearerToken = "Bearer " + token;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", bearerToken);
        return headers;
    }


}