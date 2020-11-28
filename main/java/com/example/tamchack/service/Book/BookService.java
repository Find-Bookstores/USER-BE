package com.example.tamchack.service.Book;

import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void inputBook(BookRequest bookRequest);

    ApplicationListResponse searchBook(String query, String bookName, Pageable page);
}
