package com.example.tamchack.service.member.storeUser;

import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;

public interface ReviseStoreUserPwService {
    void reviseStoreUserPw(ReviseStoreUserPwRequest reviseStoreUserPwRequest, String token);
}
