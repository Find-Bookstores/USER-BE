package com.example.tamchack.controller;

import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;
import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.request.StoreUserSignUpRequest;
import com.example.tamchack.payload.response.BookResponse;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.service.book.BookService;
import com.example.tamchack.service.member.auth.AuthService;
import com.example.tamchack.service.member.storeUser.StoreUserService;
import com.example.tamchack.service.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeuser")
@RequiredArgsConstructor
public class StoreUserController {
    private final StoreUserService storeUserService;
    private final AuthService authService;
    private final BookService bookService;
    private final StoreService storeService;

    @PostMapping("/signup")
    public void storeUserSignUp(@RequestBody StoreUserSignUpRequest storeUserSignUpRequest) {
        storeUserService.storeUserSignUp(storeUserSignUpRequest);
    }

    @PostMapping("/login")
    public TokenResponse storeUserSignIn(@RequestBody SignInRequest signInRequest, @RequestHeader("Authorization") String token){

        return authService.storeUserSignIn(signInRequest);
    }

    @PutMapping("/mypage/password")
    public void reviseStoreUserPassword (@RequestBody ReviseStoreUserPwRequest reviseStoreUserPwRequest, @RequestHeader String token) {
        storeUserService.reviseStoreUserPassword(reviseStoreUserPwRequest, token);
    }

    @GetMapping("/mypage/bookmanagement")
    public void showBookList() {
        List<BookResponse> bookResponseList = bookService.showBookList();
    }

    @PutMapping("/mypage/store")
    public void reviseStore (@RequestBody ReviseStoreRequest reviseStoreRequest, @RequestHeader("Authorization") String token) {
        storeService.reviseStore(reviseStoreRequest, token);
    }
}