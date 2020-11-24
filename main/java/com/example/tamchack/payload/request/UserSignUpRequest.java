package com.example.tamchack.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequest { //User 회원 가입
    private String id;
    private String password;
    private String name;
}
