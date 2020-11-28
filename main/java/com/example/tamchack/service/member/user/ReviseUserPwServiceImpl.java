package com.example.tamchack.service.member.user;

import com.example.tamchack.domain.user.User;
import com.example.tamchack.payload.request.ReviseUserPwRequest;
import com.example.tamchack.repository.UserRepository;
import com.example.tamchack.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviseUserPwServiceImpl implements ReviseUserPwService{
    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    @Override
    public void reviseUserPassword(ReviseUserPwRequest reviseUserPwRequest, String token) {
        User user = userRepository.findByPassword(jwtUtil.parseToken(token));
        user.update(reviseUserPwRequest.getPassword());
        userRepository.save(user);
    }
}