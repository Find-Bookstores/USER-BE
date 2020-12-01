package com.example.tamchack.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_bookmark")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {

    @Id
    private int id;

    private String userId;

    private String storeId;

}
