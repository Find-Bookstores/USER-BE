package com.example.tamchack.payload.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String author;
    private String publisher;
    private MultipartFile image;
}
