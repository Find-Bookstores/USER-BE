package com.example.tamchack.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tbl_store")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private String storeName;

    private String storeAddress;

    private String number;

    private String openingHours;

    public Store update(String number, String openingHours) {
        this.number = number;
        this.openingHours = openingHours;

        return this;
    }

}