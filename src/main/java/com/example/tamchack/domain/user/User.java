package com.example.tamchack.domain.user;

import com.example.tamchack.domain.store.Store;
import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String password;

    private String name;

    public User update(String password) {
        this.password = password;

        return this;
    }
}