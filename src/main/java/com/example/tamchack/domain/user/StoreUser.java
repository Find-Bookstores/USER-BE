package com.example.tamchack.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_store_user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreUser {
    @Id
    private String id;

    private String password;

    private String name;

    private String address;

    private String storeName;

    public StoreUser update(String password) {
        this.password = password;

        return this;
    }
}
