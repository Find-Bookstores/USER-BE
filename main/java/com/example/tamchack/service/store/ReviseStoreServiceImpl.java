package com.example.tamchack.service.store;

import com.example.tamchack.domain.store.Store;
import com.example.tamchack.domain.user.StoreUser;
import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.repository.StoreRepository;
import com.example.tamchack.repository.StoreUserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviseStoreServiceImpl implements ReviseStoreService {

    private final JwtUtil jwtUtil;

    private final StoreRepository storeRepository;
    private final StoreUserRepository storeUserRepository;


    @Override
    public void reviseStore(ReviseStoreRequest reviseStoreRequest, String token) {
        StoreUser storeUser = storeUserRepository.findById(jwtUtil.parseToken(token)).orElseThrow(RuntimeException::new);
        Store store = storeRepository.findByUserId(storeUser.getId()).orElseThrow(RuntimeException::new);
        store.update(reviseStoreRequest.getNumber(), reviseStoreRequest.getOpeningHours());
        storeRepository.save(store);
    }
}
