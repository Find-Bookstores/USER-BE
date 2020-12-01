package com.example.tamchack.controller;

import com.example.tamchack.payload.request.BookMarkRequest;
import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.service.book.BookService;
import com.example.tamchack.service.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final BookService bookService;

    @GetMapping("/search")
    public void searchStore(@RequestParam String title,
                           @PageableDefault Pageable pageable){
        storeService.searchStore(title, pageable);
    }

    @GetMapping("/searchbook")
    public void searchBookInStoreInfo(@RequestParam Integer storeId,
                                      @RequestParam String query,
                                      @PageableDefault Pageable page){
        bookService.searchBookInStoreInfo(storeId, query, page);
    }

    @PutMapping("/favoritestore")
    public void favoriteStore(@RequestBody BookMarkRequest bookMarkRequest, @RequestHeader String token){
        storeService.favoriteStore(bookMarkRequest, token);
    }
}