package com.example.tamchack.service.member.storeUser;

import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;

public interface ReviseStoreUserPwService {
    void reviseStoreUserPassword(ReviseStoreUserPwRequest reviseStoreUserPwRequest, String token);
}
