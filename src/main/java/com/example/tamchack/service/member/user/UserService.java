package com.example.tamchack.service.member.user;

import com.example.tamchack.domain.user.User;
import com.example.tamchack.payload.request.ReviseUserPwRequest;
import com.example.tamchack.payload.request.UserSignUpRequest;

public interface UserService {
    void userSignUp(UserSignUpRequest userSignUpRequest);

    void reviseUserPassword(ReviseUserPwRequest reviseUserPwRequest, String token);
}
