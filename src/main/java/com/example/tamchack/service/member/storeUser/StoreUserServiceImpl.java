package com.example.tamchack.service.member.storeUser;

import com.example.tamchack.domain.store.Store;
import com.example.tamchack.domain.user.StoreUser;
import com.example.tamchack.exception.UserAlreadyEsixtsException;
import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;
import com.example.tamchack.payload.request.StoreUserSignUpRequest;
import com.example.tamchack.repository.StoreRepository;
import com.example.tamchack.repository.StoreUserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreUserServiceImpl implements StoreUserService {

    private final StoreUserRepository storeuserRepository;
    private final StoreRepository storeRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void storeUserSignUp(StoreUserSignUpRequest storeUserSignUpRequest) {
        storeuserRepository.findById(storeUserSignUpRequest.getId()).ifPresent(u -> {throw new UserAlreadyEsixtsException();});
        storeuserRepository.save(
                StoreUser.builder()
                        .id(storeUserSignUpRequest.getId())
                        .password(storeUserSignUpRequest.getPassword())
                        .build()
        );

        storeRepository.save(
                Store.builder()
                        .userId(storeUserSignUpRequest.getId())
                        .storeName(storeUserSignUpRequest.getStoreName())
                        .storeAddress(storeUserSignUpRequest.getAddress())
                        .number(storeUserSignUpRequest.getNumber())
                        .openingHours(storeUserSignUpRequest.getOpeningHours())
                        .build()
        );
    }

    @Override
    public void reviseStoreUserPassword(ReviseStoreUserPwRequest reviseStoreUserPwRequest, String token) {
        StoreUser storeUser = storeuserRepository.findByPassword(jwtUtil.parseToken(token));
        storeUser.update(reviseStoreUserPwRequest.getPassword());
        storeuserRepository.save(storeUser);
    }
}
