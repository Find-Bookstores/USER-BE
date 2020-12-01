package com.example.tamchack.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkRequest {
    private String userId;
    private String StoreId;
}
