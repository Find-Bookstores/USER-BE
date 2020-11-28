package com.example.tamchack.service.member.auth;

import com.example.tamchack.domain.user.User;
import com.example.tamchack.payload.request.SignInRequest;
import com.example.tamchack.payload.response.TokenResponse;
import com.example.tamchack.repository.UserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    @Override
    public TokenResponse userSignIn(SignInRequest signInRequest) {
        User user = userRepository.findByIdAndPassword(signInRequest.getId(), signInRequest.getPassword());
        if(user == null){
            throw new RuntimeException();
        }
        String accessToken = jwtUtil.getAccessToken(user.getId());
        String refreshToken = jwtUtil.getRefreshToken(user.getId());
        return new TokenResponse(accessToken, refreshToken);
    }
}
