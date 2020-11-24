package com.example.tamchack.service.member.user;

import com.example.tamchack.payload.request.ReviseUserPwRequest;

public interface ReviseUserPwService {
    void reviseUserPw(ReviseUserPwRequest reviseUserPwRequest, String token);
}