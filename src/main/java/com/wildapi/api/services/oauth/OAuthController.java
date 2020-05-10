package com.wildapi.api.services.oauth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("oauth")
@Log4j2
public class OAuthController {


    @Autowired
    OAuthService oAuthService;


    @GetMapping("/{appName}")
    public void setupOAuth(@PathVariable("appName") String appName, @RequestParam(name = "code") String code, HttpServletResponse httpResponse) {

        String token = this.oAuthService.handleOAuthCallback(appName, code);

        String finalFrontCallbackUrl = this.oAuthService.getWebSiteUrlByAppName(appName);
        try {
            httpResponse.sendRedirect(
                    finalFrontCallbackUrl + token);
        } catch (IOException e) {
            log.error("Redirection failed " + e.getMessage());
        }

    }

    @GetMapping("/odyssey/{appName}")
    public void redirect(@PathVariable("appName") String appName, HttpServletResponse httpResponse) {
        String encodedURL = oAuthService.generateRedirectUrl(appName);
        try {
            httpResponse.sendRedirect(encodedURL);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Redirection to odyssey failed" + e.getMessage());
        }
    }


}