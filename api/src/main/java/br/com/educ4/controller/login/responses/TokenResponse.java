package br.com.educ4.controller.login.responses;

import lombok.Getter;

@Getter
public class TokenResponse {

    private String accessToken;

    TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
