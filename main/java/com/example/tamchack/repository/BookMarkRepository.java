package com.example.tamchack.repository;

import com.example.tamchack.domain.store.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkRepository extends JpaRepository<BookMark, Integer> {
}
