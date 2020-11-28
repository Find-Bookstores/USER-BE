package com.example.tamchack.controller;

import com.example.tamchack.domain.store.Store;
import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.service.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("storeuser/mypage/revisestore")
    public void reviseStore (@RequestBody ReviseStoreRequest reviseStoreRequest, @RequestHeader String token) {
        storeService.reviseStore(reviseStoreRequest, token);
    }

}