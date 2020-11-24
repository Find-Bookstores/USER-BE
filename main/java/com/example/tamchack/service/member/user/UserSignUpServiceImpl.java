package com.example.tamchack.service.member.user;

import com.example.tamchack.domain.user.User;
import com.example.tamchack.payload.request.UserSignUpRequest;
import com.example.tamchack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpServiceImpl implements UserSignUpService {

    private final UserRepository userRepository;
    //주입받기 위한 final 사용

    @Override
    public void userSignUp(UserSignUpRequest userSignUpRequest) {
        userRepository.save(
                User.builder()
                        .id(userSignUpRequest.getId()) //id 저장
                        .password(userSignUpRequest.getPassword())
                        .name(userSignUpRequest.getName())
                        .build()
        );
    }
}
