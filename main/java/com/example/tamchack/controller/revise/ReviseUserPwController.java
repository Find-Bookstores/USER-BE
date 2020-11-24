package com.example.tamchack.controller.revise;

import com.example.tamchack.payload.request.ReviseUserPwRequest;
import com.example.tamchack.service.member.user.ReviseUserPwService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/mypage/revisepw")
@RequiredArgsConstructor
public class ReviseUserPwController {
    private final ReviseUserPwService reviseUserPwService;

    @PostMapping
    public void reviseUserPw (@RequestBody ReviseUserPwRequest reviseUserPwRequest, @RequestHeader String token) {
        reviseUserPwService.reviseUserPw(reviseUserPwRequest, token);
    }
}
