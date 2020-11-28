package com.example.tamchack.payload.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
public class BookRequest {
    private String name;
    private String author;
    private String publisher;
    private MultipartFile image;
}
