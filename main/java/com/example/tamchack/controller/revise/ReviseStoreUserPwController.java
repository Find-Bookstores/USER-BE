package com.example.tamchack.controller.revise;

import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;
import com.example.tamchack.service.member.storeUser.ReviseStoreUserPwService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storeuser/mypage/revisepw")
@RequiredArgsConstructor
public class ReviseStoreUserPwController {
    private final ReviseStoreUserPwService reviseStoreUserPwService;

    @PostMapping
    public void reviseStoreUserPw (@RequestBody ReviseStoreUserPwRequest reviseStoreUserPwRequest, @RequestHeader String token) {
        reviseStoreUserPwService.reviseStoreUserPw(reviseStoreUserPwRequest, token);
    }
}
