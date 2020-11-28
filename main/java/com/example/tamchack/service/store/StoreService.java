package com.example.tamchack.service.store;

import com.example.tamchack.domain.store.Store;
import com.example.tamchack.payload.request.BookMarkRequest;
import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreService{
    void reviseStore(ReviseStoreRequest reviseStoreRequest, String token);

    void recommend(BookMarkRequest bookMarkRequest);

    ApplicationListResponse searchBoard(String query, String storeName, Pageable page);
}