package com.example.tamchack.controller.member;

import com.example.tamchack.payload.request.UserSignUpRequest;
import com.example.tamchack.service.member.user.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSignUpService userSignUpService;

    @PostMapping
    public void userSignUp(@RequestBody UserSignUpRequest userSignUpRequest){

        userSignUpService.userSignUp(userSignUpRequest);
    }
}