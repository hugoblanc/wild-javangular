package com.wildapi.api.services.oauth.dto;

import java.io.Serializable;

public class AskAuthorizationDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3358377283928229052L;
    String redirect_uri;
    String grant_type;
    String client_secret;
    String client_id;
    String code;

    public AskAuthorizationDto(String redirect_uri, String grant_type, String client_secret, String client_id,
                               String code) {
        this.redirect_uri = redirect_uri;
        this.grant_type = grant_type;
        this.client_secret = client_secret;
        this.client_id = client_id;
        this.code = code;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AskAuthorizationDto{" +
                "redirect_uri='" + redirect_uri + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", client_id='" + client_id + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}