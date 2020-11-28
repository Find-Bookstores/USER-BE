package com.example.tamchack.controller.member;

import com.example.tamchack.payload.request.ReviseUserPwRequest;
import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.request.UserSignUpRequest;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.service.member.auth.UserAuthService;
import com.example.tamchack.service.member.user.ReviseUserPwService;
import com.example.tamchack.service.member.user.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserSignUpService userSignUpService;
    private final UserAuthService userAuthService;
    private final ReviseUserPwService reviseUserPwService;

    @PostMapping("signup/user")
    public void userSignUp(@RequestBody UserSignUpRequest userSignUpRequest){

        userSignUpService.userSignUp(userSignUpRequest);
    }

    @PostMapping("login/user")
    public TokenResponse userSignIn(@RequestBody SignInRequest signInRequest, @RequestHeader("Authorization") String Token){

        return userAuthService.userSignIn(signInRequest);
    }

    @PostMapping("user/mypage/revisepw")
    public void reviseUserPassword (@RequestBody ReviseUserPwRequest reviseUserPwRequest, @RequestHeader String token) {
        reviseUserPwService.reviseUserPassword(reviseUserPwRequest, token);
    }
}