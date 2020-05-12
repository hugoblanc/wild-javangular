package com.wildapi.api.services.oauth;

import com.wildapi.api.core.RestService;
import com.wildapi.api.core.security.jwt.JwtUtil;
import com.wildapi.api.services.oauth.dto.AskAuthorizationDto;
import com.wildapi.api.services.oauth.dto.AuthResponseDto;
import com.wildapi.api.services.oauth.dto.OdysseyUserDto;
import com.wildapi.api.services.user.User;
import com.wildapi.api.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OAuthService {

    @Autowired
    JwtUtil jwtUtil;


    @Autowired
    UserService userService;

    @Autowired
    RestService restService;

    @Value("${odyssey.callback.local.url}")
    private String callbackLocalUrl;

    @Value("${odyssey.callback.daybook.url}")
    private String callbackDaybookkUrl;

    @Value("${odyssey.callback.battle.url}")
    private String callbackBattleUrl;

    @Value("${odyssey.front.local.url}")
    private String frontLocalUrl;

    @Value("${odyssey.front.daybook.url}")
    private String frontDaybookkUrl;

    @Value("${odyssey.front.battle.url}")
    private String frontBattleUrl;

    @Value("${odyssey.clientid}")
    private String odysseyClientId;

    @Autowired
    private ModelMapper modelMapper;

    public String handleOAuthCallback(String appName, String code) {

        AskAuthorizationDto askAuth = this.createAskAuthorizationFromCode(appName, code);


        AuthResponseDto authResponse = this.restService.postObject("https://odyssey.wildcodeschool.com/oauth/token", askAuth, AuthResponseDto.class);
        ResponseEntity<OdysseyUserDto> odysseyUserDtoResponseEntity = this.restService.getObject("https://odyssey.wildcodeschool.com/api/v2/me", OdysseyUserDto.class, authResponse.getAccess_token());

        User user = this.modelMapper.map(odysseyUserDtoResponseEntity.getBody(), User.class);
        user = userService.saveUser(user);

        return jwtUtil.generateToken(user);
    }


    public AskAuthorizationDto createAskAuthorizationFromCode(String appName, String code) {
        String callbackUrl = "";

        if (appName.equals("battle")) {
            callbackUrl = callbackBattleUrl;
        } else if (appName.equals("local")) {
            callbackUrl = callbackLocalUrl;
        } else {
            callbackUrl = callbackDaybookkUrl;
        }

        AskAuthorizationDto askAuth = new AskAuthorizationDto(
                callbackUrl
                , "authorization_code", System.getenv("odyssey_secret"), odysseyClientId, code);
        return askAuth;
    }


    public String generateRedirectUrl(String appName) {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("client_id", odysseyClientId);
        requestParams.put("response_type", "code");

        if (appName.equals("battle")) {
            requestParams.put("redirect_uri", callbackBattleUrl);
        } else if (appName.equals("local")) {
            requestParams.put("redirect_uri", callbackLocalUrl);
        } else {
            requestParams.put("redirect_uri", callbackDaybookkUrl);
        }

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

        return encodedURL;
    }


    public String getWebSiteUrlByAppName(String appName) {
        String websiteUrl;
        if (appName.equals("battle")) {
            websiteUrl = frontBattleUrl;
        } else if (appName.equals("local")) {
            websiteUrl = frontLocalUrl;
        } else {
            websiteUrl = frontDaybookkUrl;
        }
        return websiteUrl;
    }

    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

}