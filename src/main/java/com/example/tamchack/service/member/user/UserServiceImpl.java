package com.example.tamchack.service.member.user;

import com.example.tamchack.domain.user.User;
import com.example.tamchack.exception.UserAlreadyEsixtsException;
import com.example.tamchack.payload.request.ReviseUserPwRequest;
import com.example.tamchack.payload.request.UserSignUpRequest;
import com.example.tamchack.repository.UserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    //주입받기 위한 final 사용

    @Override
    public void userSignUp(UserSignUpRequest userSignUpRequest) {
        userRepository.findById(userSignUpRequest.getId())
                .ifPresent(u -> {
                    throw new UserAlreadyEsixtsException();
                });

        userRepository.save(
                User.builder()
                        .id(userSignUpRequest.getId())
                        .password(userSignUpRequest.getPassword())
                        .name(userSignUpRequest.getName())
                        .build()
        );
    }

    @Override
    public void reviseUserPassword(ReviseUserPwRequest reviseUserPwRequest, String token) {
        User user = userRepository.findByPassword(jwtUtil.parseToken(token));
        user.update(reviseUserPwRequest.getPassword());
        userRepository.save(user);
    }

}
