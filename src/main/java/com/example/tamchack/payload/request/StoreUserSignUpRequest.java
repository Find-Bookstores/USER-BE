package com.example.tamchack.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreUserSignUpRequest {
    private String id;
    private String password;
    private String address;
    private String storeName;
    private String number;
    private String openingHours;
}
