package com.example.tamchack.controller.revise;

import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.service.store.ReviseStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storeuser/mypage/revisestore")
@RequiredArgsConstructor
public class ReviseStoreController {
    private final ReviseStoreService reviseStoreService;

    @PostMapping
    public void reviseStore (@RequestBody ReviseStoreRequest reviseStoreRequest, @RequestHeader String token) {
        reviseStoreService.reviseStore(reviseStoreRequest, token);
    }
}