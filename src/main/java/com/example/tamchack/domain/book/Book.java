package com.example.tamchack.domain.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_book")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private int id;

    private String bookName;

    private String author;

    private String publisher;

    private Integer storeId;

    private boolean existence;
}
