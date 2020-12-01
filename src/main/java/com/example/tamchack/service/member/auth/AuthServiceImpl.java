package com.example.tamchack.service.member.auth;

import com.example.tamchack.domain.user.StoreUser;
import com.example.tamchack.domain.user.User;
import com.example.tamchack.exception.ExpiredTokenException;
import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.repository.StoreUserRepository;
import com.example.tamchack.repository.UserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final StoreUserRepository storeUserRepository;
    private final JwtUtil jwtUtil;

    @Override
    public TokenResponse userSignIn(SignInRequest signInRequest) {
        User user = userRepository.findByIdAndPassword(signInRequest.getId(), signInRequest.getPassword());
        if(user == null){
            throw new ExpiredTokenException();
        }
        String accessToken = jwtUtil.getAccessToken(user.getId());
        String refreshToken = jwtUtil.getRefreshToken(user.getId());
        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    public TokenResponse storeUserSignIn(SignInRequest signInRequest) {
        StoreUser storeUser = storeUserRepository.findByIdAndPassword(signInRequest.getId(), signInRequest.getPassword());
        if(storeUser == null){
            throw new ExpiredTokenException();
        }
        String accessToken = jwtUtil.getAccessToken(storeUser.getId());
        String refreshToken = jwtUtil.getRefreshToken(storeUser.getId());
        return new TokenResponse(accessToken, refreshToken);
    }
}

