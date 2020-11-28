package com.example.tamchack.controller;

import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.service.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PutMapping
    public void reviseStore (@RequestBody ReviseStoreRequest reviseStoreRequest, @RequestHeader("Authorization") String token) {
        storeService.reviseStore(reviseStoreRequest, token);
    }

}