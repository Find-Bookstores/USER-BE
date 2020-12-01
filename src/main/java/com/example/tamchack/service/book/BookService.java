package com.example.tamchack.service.book;

import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import com.example.tamchack.payload.response.BookResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    void inputBook(BookRequest bookRequest);

    ApplicationListResponse searchBook(String query, Pageable page);

    List<BookResponse> showBookList();

    ApplicationListResponse searchBookInStoreInfo(Integer storeId, String query, Pageable page);

}
