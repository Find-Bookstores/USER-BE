package com.example.tamchack.controller;

import com.example.tamchack.payload.request.ReviseUserPwRequest;
import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.request.UserSignUpRequest;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.service.member.auth.AuthService;
import com.example.tamchack.service.member.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public void userSignUp(@RequestBody UserSignUpRequest userSignUpRequest){

        userService.userSignUp(userSignUpRequest);
    }

    @PostMapping("/login")
    public TokenResponse userSignIn(@RequestBody SignInRequest signInRequest){

        return authService.userSignIn(signInRequest);
    }

    @PutMapping("/mypage/update")
    public void reviseUserPassword (@RequestBody ReviseUserPwRequest reviseUserPwRequest, @RequestHeader String token) {
        userService.reviseUserPassword(reviseUserPwRequest, token);
    }
}