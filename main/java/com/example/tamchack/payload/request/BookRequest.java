package com.example.tamchack.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private String name;
    private String author;
    private String publisher;
}
