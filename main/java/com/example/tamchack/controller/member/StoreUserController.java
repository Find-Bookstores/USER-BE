package com.example.tamchack.controller.member;

import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;
import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.request.StoreUserSignUpRequest;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.service.member.auth.StoreUserAuthService;
import com.example.tamchack.service.member.storeUser.ReviseStoreUserPwService;
import com.example.tamchack.service.member.storeUser.StoreUserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storeuser")
@RequiredArgsConstructor
public class StoreUserController {
    private final StoreUserSignUpService storeUserSignUpService;
    private final StoreUserAuthService storeUserAuthService;
    private final ReviseStoreUserPwService reviseStoreUserPwService;

    @PostMapping("/signup")
    public void storeUserSignUp(@RequestBody StoreUserSignUpRequest storeUserSignUpRequest) {
        storeUserSignUpService.storeUserSignUp(storeUserSignUpRequest);
    }

    @PostMapping("/login")
    public TokenResponse storeUserSignIn(@RequestBody SignInRequest signInRequest, @RequestHeader("Authorization") String token){

        return storeUserAuthService.storeUserSignIn(signInRequest);
    }

    @PutMapping("/mypage/password")
    public void reviseStoreUserPw (@RequestBody ReviseStoreUserPwRequest reviseStoreUserPwRequest, @RequestHeader String token) {
        reviseStoreUserPwService.reviseStoreUserPassword(reviseStoreUserPwRequest, token);
    }
}