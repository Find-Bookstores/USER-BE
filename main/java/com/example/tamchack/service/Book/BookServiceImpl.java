package com.example.tamchack.service.Book;

import com.example.tamchack.domain.book.Book;
import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public void inPutBook(BookRequest bookRequest) {
        bookRepository.save(
                Book.builder()
                    .name(bookRequest.getName())
                    .author(bookRequest.getAuthor())
                    .publisher(bookRequest.getPublisher())
                    .build()
        );
    }
}
