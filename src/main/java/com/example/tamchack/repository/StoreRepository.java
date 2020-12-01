package com.example.tamchack.repository;

import com.example.tamchack.domain.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
    Optional <Store> findByUserId(String userId);

    Page<Store> findAllByStoreNameContainsOrStoreAddressContains(
            String storeName, String storeAddress, Pageable page);

}