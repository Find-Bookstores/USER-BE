package com.example.tamchack.controller.member;

import com.example.tamchack.payload.request.StoreUserSignUpRequest;
import com.example.tamchack.service.member.storeUser.StoreUserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup/storeuser")
@RequiredArgsConstructor
public class StoreUserController {
    private final StoreUserSignUpService storeUserSignUpService;

    @PostMapping
    public void storeUserSignUp(@RequestBody StoreUserSignUpRequest storeUserSignUpRequest) {
        storeUserSignUpService.storeUserSignUp(storeUserSignUpRequest);
    }
}