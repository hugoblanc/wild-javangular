package com.wildapi.api.services.oauth;

import com.wildapi.api.core.RestService;

import com.wildapi.api.services.oauth.dto.AskAuthorizationDto;
import com.wildapi.api.services.oauth.dto.AuthResponseDto;
import com.wildapi.api.services.oauth.dto.OdysseyUserDto;
import com.wildapi.api.services.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OAuthService {

    @Autowired RestService restService;

    @Autowired
    private ModelMapper modelMapper;

    User handleOAuthCallback(String code){

        AskAuthorizationDto askAuth = this.createAskAuthorizationFromCode(code);


        AuthResponseDto authResponse = this.restService.postObject("https://odyssey.wildcodeschool.com/oauth/token", askAuth, AuthResponseDto.class);
        System.out.println(authResponse);
        ResponseEntity<OdysseyUserDto> odysseyUserDtoResponseEntity = this.restService.getObject( "https://odyssey.wildcodeschool.com/api/v2/me", OdysseyUserDto.class,authResponse.getAccess_token());
        User user = this.modelMapper.map(odysseyUserDtoResponseEntity.getBody(), User.class);
        return user;
    }


    AskAuthorizationDto createAskAuthorizationFromCode(String code){

        AskAuthorizationDto askAuth = new AskAuthorizationDto(
        "http://localhost:8080/oauth"    
        , "authorization_code",System.getenv("odyssey_secret"), "fc3dfb1962ce7fcdb7b7958e9c6928e78ed030deb8462f7ef9e8db5f47301b5c", code);
        return askAuth;
    }

}