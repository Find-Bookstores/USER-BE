package com.example.tamchack.service.member.storeUser;

import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;
import com.example.tamchack.payload.request.StoreUserSignUpRequest;

public interface StoreUserService {
    void storeUserSignUp(StoreUserSignUpRequest storeUserSignUpRequest);

    void reviseStoreUserPassword(ReviseStoreUserPwRequest reviseStoreUserPwRequest, String token);
}
