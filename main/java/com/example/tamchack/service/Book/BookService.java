package com.example.tamchack.service.Book;

import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.repository.BookRepository;

public interface BookService {
    void writeBook(BookRequest bookRequest);
}
