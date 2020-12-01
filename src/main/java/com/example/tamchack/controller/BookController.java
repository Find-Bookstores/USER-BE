package com.example.tamchack.controller;

import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/inputbook")
    public void inputBook(@RequestParam String name,
                          @RequestParam String author,
                          @RequestParam String publisher,
                          @RequestParam MultipartFile image){
        bookService.inputBook(
                BookRequest.builder()
                .name(name)
                .author(author)
                .publisher(publisher)
                .image(image)
                .build()
        );
    }

    @GetMapping("/search")
    public void searchBook(@RequestParam String title,
                           @PageableDefault Pageable pageable){
        bookService.searchBook(title, pageable);
    }
}
