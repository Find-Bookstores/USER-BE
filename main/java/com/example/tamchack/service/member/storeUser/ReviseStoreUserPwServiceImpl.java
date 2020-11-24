package com.example.tamchack.service.member.storeUser;

import com.example.tamchack.domain.user.StoreUser;
import com.example.tamchack.payload.request.ReviseStoreUserPwRequest;
import com.example.tamchack.repository.StoreUserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviseStoreUserPwServiceImpl implements ReviseStoreUserPwService {
    private final JwtUtil jwtUtil;

    private final StoreUserRepository storeUserRepository;
    @Override
    public void reviseStoreUserPw(ReviseStoreUserPwRequest reviseStoreUserPwRequest, String token) {
        StoreUser storeUser = storeUserRepository.findByPw(jwtUtil.parseToken(token));
        storeUser.update(reviseStoreUserPwRequest.getPassword());
        storeUserRepository.save(storeUser);
    }
}
