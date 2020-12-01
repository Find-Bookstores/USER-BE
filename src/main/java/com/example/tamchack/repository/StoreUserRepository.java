package com.example.tamchack.repository;

import com.example.tamchack.domain.user.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreUserRepository extends JpaRepository<StoreUser, String> {
    StoreUser findByIdAndPassword(String Id, String password);
    StoreUser findByPassword(String password);
}
