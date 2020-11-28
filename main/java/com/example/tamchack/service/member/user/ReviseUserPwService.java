package com.example.tamchack.service.member.user;

import com.example.tamchack.payload.request.ReviseUserPwRequest;

public interface ReviseUserPwService {
    void reviseUserPassword(ReviseUserPwRequest reviseUserPwRequest, String token);
}