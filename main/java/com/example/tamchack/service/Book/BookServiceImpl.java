package com.example.tamchack.service.Book;

import com.example.tamchack.domain.book.Book;
import com.example.tamchack.payload.request.BookRequest;
import com.example.tamchack.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Value("${file.upload-dir}")
    private String imageDir;
    @Override
    public void writeBook(BookRequest bookRequest) {
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
}
