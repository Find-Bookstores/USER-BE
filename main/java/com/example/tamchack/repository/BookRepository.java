package com.example.tamchack.repository;

import com.example.tamchack.domain.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByBookNameContainsOrderByCreatedAtDesc(
            String bookName, Pageable page);
}
