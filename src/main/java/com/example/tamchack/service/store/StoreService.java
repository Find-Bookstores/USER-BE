package com.example.tamchack.service.store;

import com.example.tamchack.payload.request.BookMarkRequest;
import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface StoreService{
    void reviseStore(ReviseStoreRequest reviseStoreRequest, String token);

    void favoriteStore(BookMarkRequest bookMarkRequest, String token);

    ApplicationListResponse searchStore(String query, Pageable page);
}