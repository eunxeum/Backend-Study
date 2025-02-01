package org.springbootdeveloper2.service;

import lombok.RequiredArgsConstructor;
import org.springbootdeveloper2.domain.User;
import org.springbootdeveloper2.dto.request.AddUserRequest;
import org.springbootdeveloper2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원 정보 추가
    public Long save(AddUserRequest addUserRequest) {
        return userRepository.save(User.builder()
                .email(addUserRequest.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(addUserRequest.getPassword()))
                .build()).getId();
    }
}
