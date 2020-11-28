package com.example.tamchack.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_book_mark")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {
    @Id
    private int id;

    private String user_id;

    private String store_id;
}