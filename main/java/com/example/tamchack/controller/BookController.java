package com.example.tamchack.controller;

import com.example.tamchack.payload.request.BookMarkRequest;
import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.service.Book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/book/input")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public void inPutBook(@RequestParam String name,
                          @RequestParam String author,
                          @RequestParam String publisher,
                          @RequestParam MultipartFile image){
        bookService.writeBook(
                BookRequest.builder()
                .name(name)
                .author(author)
                .publisher(publisher)
                .image(image)
                .build()
        );
    }
}
