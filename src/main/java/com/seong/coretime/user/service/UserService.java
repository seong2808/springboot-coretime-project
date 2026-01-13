package com.seong.coretime.user.service;

import com.seong.coretime.user.dto.UserDto;
import com.seong.coretime.user.entity.User;
import com.seong.coretime.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입 로직
     * 1. 이메일 중복 체크
     * 2. 비밀번호 암호화 (BCrypt)
     * 3. DB 저장
     */
    @Transactional
    public Long signup(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalStateException("이미 사용 중인 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(encodedPassword)
                .build();

        userRepository.save(user);
        return user.getId();
    }
}
