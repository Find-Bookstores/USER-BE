package com.example.tamchack.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse { //로그인 유지

    private String accessToken;
    private String refreshToken;

}
