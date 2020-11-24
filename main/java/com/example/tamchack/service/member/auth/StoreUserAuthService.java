package com.example.tamchack.service.member.auth;

import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.response.TokenResponse;

public interface StoreUserAuthService {
    TokenResponse StoreUserSignIn(SignInRequest signInRequest);
}
