package com.example.tamchack.service.store;

import com.example.tamchack.payload.request.ReviseStoreRequest;

public interface ReviseStoreService {
    void reviseStore(ReviseStoreRequest reviseStoreRequest, String token);
}
