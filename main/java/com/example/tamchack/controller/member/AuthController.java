package com.example.tamchack.controller.member;

import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.service.member.auth.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final UserAuthService userAuthService;

    @PostMapping
    public TokenResponse signIn(@RequestBody SignInRequest signInRequest, @RequestHeader("Authorization") String Token){

        return userAuthService.UserSignIn(signInRequest);
    }
}
