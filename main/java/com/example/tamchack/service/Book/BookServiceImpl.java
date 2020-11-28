package com.example.tamchack.service.Book;

import com.example.tamchack.domain.book.Book;
import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import com.example.tamchack.payload.response.SearchResponse;
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
                    .name(bookRequest.getName())
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
    public ApplicationListResponse searchBook(String query, String bookName, Pageable page) {
        Page<Book> bookPage = bookRepository
                .findAllByBookNameContainsOrderByCreatedAtDesc(
                        query, page);
        List<SearchResponse> searchResponse = new ArrayList<>();

        for(Book book : bookPage) {
            searchResponse.add(
                    SearchResponse.builder()
                            .build()
            );
        }

        return ApplicationListResponse.builder()
                .totalElements((int)bookPage.getTotalElements())
                .totalPages(bookPage.getTotalPages())
                .applicationResponses(searchResponse)
                .build();
    }
}
