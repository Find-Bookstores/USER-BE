package com.example.tamchack.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private Integer bookId;

    private String title;

    private String author;

    private String publisher;

    private Boolean existence;
}
