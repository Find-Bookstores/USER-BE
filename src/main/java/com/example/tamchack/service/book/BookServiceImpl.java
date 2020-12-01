package com.example.tamchack.service.book;

import com.example.tamchack.domain.book.Book;
import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import com.example.tamchack.payload.response.BookResponse;
import com.example.tamchack.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Value("${file.upload-dir}")
    private String imageDir;

    @Override
    public void inputBook(BookRequest bookRequest) {

        Book book = bookRepository.save(
                Book.builder()
                    .bookName(bookRequest.getName())
                    .author(bookRequest.getAuthor())
                    .publisher(bookRequest.getPublisher())
                    .build()
        );

        String fileName = String.valueOf(book.getId());

        try {
            bookRequest.getImage().transferTo(new File(imageDir, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ApplicationListResponse searchBook(String query, Pageable page) {
        Page<Book> bookPage = bookRepository
                .findAllByBookNameContains(query, page);

        List<BookResponse> bookResponse = new ArrayList<>();

        for(Book book : bookPage) {
            bookResponse.add(
                    BookResponse.builder()
                            .bookId(book.getId())
                            .title(book.getBookName())
                            .build()
            );
        }

        return ApplicationListResponse.builder()
                .totalElements((int)bookPage.getTotalElements())
                .totalPages(bookPage.getTotalPages())
                .applicationResponses(bookResponse)
                .build();
    }

    @Override
    public List<BookResponse> showBookList() {
        List<Book> bookList = bookRepository.findAll();
        List<BookResponse> bookResponseList = new ArrayList<>();

        for(Book book : bookList){
            BookResponse bookResponse = BookResponse.builder()
                    .title(book.getBookName())
                    .author(book.getAuthor())
                    .publisher(book.getPublisher())
                    .existence(book.isExistence())
                    .build();
        }

        return bookResponseList;
    }

    @Override
    public ApplicationListResponse searchBookInStoreInfo(Integer storeId, String query, Pageable page) {
        Page<Book> bookPage = bookRepository
                .findAllByStoreIdAndBookNameContains(storeId, query, page);

        List<BookResponse> bookResponse = new ArrayList<>();

        for(Book book : bookPage) {
            bookResponse.add(
                    BookResponse.builder()
                            .title(book.getBookName())
                            .author(book.getAuthor())
                            .publisher(book.getPublisher())
                            .existence(book.isExistence())
                            .build()
            );
        }

        return ApplicationListResponse.builder()
                .totalElements((int)bookPage.getTotalElements())
                .totalPages(bookPage.getTotalPages())
                .applicationResponses(bookResponse)
                .build();
    }
}
