package com.example.tamchack.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviseStoreRequest {
    private String number;
    private String openingHours;
}
