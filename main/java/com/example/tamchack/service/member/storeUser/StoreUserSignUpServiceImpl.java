package com.example.tamchack.service.member.storeUser;

import com.example.tamchack.domain.store.Store;
import com.example.tamchack.domain.user.StoreUser;
import com.example.tamchack.payload.request.StoreUserSignUpRequest;
import com.example.tamchack.repository.StoreRepository;
import com.example.tamchack.repository.StoreUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreUserSignUpServiceImpl implements StoreUserSignUpService {

    private final StoreUserRepository storeuserRepository;
    private final StoreRepository storeRepository;

    @Override
    public void storeUserSignUp(StoreUserSignUpRequest storeUserSignUpRequest) {
        storeuserRepository.findById(storeUserSignUpRequest.getId())
                .ifPresent(storeUser -> {
                    //throw new 유저이미있는예외();
                });
        storeuserRepository.save(
                StoreUser.builder()
                        .id(storeUserSignUpRequest.getId())
                        .password(storeUserSignUpRequest.getPassword())
                        .name(storeUserSignUpRequest.getName())
                        .build()
        );

        storeRepository.save(
                Store.builder()
                        .userId(storeUserSignUpRequest.getId())
                        .name(storeUserSignUpRequest.getStoreName())
                        .address(storeUserSignUpRequest.getAddress())
                        .number(storeUserSignUpRequest.getNumber())
                        .openingHours(storeUserSignUpRequest.getOpeningHours())
                        .build()
        );
        /*
        try {
            Store store = storeRepository.findById(5)
                    .orElseThrow(Exception::new);
            store.update("", "");

            storeRepository.save(store);
        } catch (Exception e) {
            e.printStackTrace();
        }

        */
    }
    //주입받기 위한 final 사용

}
