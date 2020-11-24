package com.example.tamchack.repository;

import com.example.tamchack.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookRepository extends JpaRepository<Book, Integer> {

}
