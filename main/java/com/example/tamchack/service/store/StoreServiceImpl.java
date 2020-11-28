package com.example.tamchack.service.store;

import com.example.tamchack.domain.store.BookMark;
import com.example.tamchack.domain.store.Store;
import com.example.tamchack.domain.user.StoreUser;
import com.example.tamchack.domain.user.User;
import com.example.tamchack.payload.request.BookMarkRequest;
import com.example.tamchack.payload.request.ReviseStoreRequest;
import com.example.tamchack.payload.response.ApplicationListResponse;
import com.example.tamchack.payload.response.SearchResponse;
import com.example.tamchack.repository.BookMarkRepository;
import com.example.tamchack.repository.StoreRepository;
import com.example.tamchack.repository.StoreUserRepository;
import com.example.tamchack.repository.UserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final JwtUtil jwtUtil;

    private final StoreRepository storeRepository;
    private final StoreUserRepository storeUserRepository;
    private final BookMarkRepository bookMarkRepository;
    private final UserRepository userRepository;

    @Override
    public void reviseStore(ReviseStoreRequest reviseStoreRequest, String token) {
        StoreUser storeUser = storeUserRepository.findById(jwtUtil.parseToken(token)).orElseThrow(RuntimeException::new);
        Store store = storeRepository.findByUserId(storeUser.getId()).orElseThrow(RuntimeException::new);
        store.update(reviseStoreRequest.getNumber(), reviseStoreRequest.getOpeningHours());
        storeRepository.save(store);
    }

    @Override
    public void recommend(BookMarkRequest bookMarkRequest, String token) {
        User user = userRepository.findById(jwtUtil.parseToken(token)).orElseThrow(RuntimeException::new);
        bookMarkRepository.save(
                BookMark.builder()
                .userId(bookMarkRequest.getUserId())
                .storeId(bookMarkRequest.getStoreId())
                .build()
        );
    }

    @Override
    public ApplicationListResponse searchStore(String query, String storeName, Pageable page) {

        Page<Store> storePage = storeRepository
                .findAllByStoreNameContainsOrStoreAddressContainsOrderByCreatedAtDesc(
                        query, query, page
                );

        List<SearchResponse> searchResponse = new ArrayList<>();

        for(Store store : storePage) {
            searchResponse.add(
                    SearchResponse.builder()
                            .build()
            );
        }

        return ApplicationListResponse.builder()
                .totalElements((int)storePage.getTotalElements())
                .totalPages(storePage.getTotalPages())
                .applicationResponses(searchResponse)
                .build();
    }

}
