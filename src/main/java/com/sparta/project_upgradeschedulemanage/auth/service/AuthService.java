/*
package com.sparta.project_upgradeschedulemanage.auth.service;

import com.sparta.project_upgradeschedulemanage.auth.dto.SigninRequestDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SigninResponseDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignupRequestDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignupResponseDto;
import com.sparta.project_upgradeschedulemanage.config.JwtUtil;
import com.sparta.project_upgradeschedulemanage.config.PasswordEncoder;
import com.sparta.project_upgradeschedulemanage.user.entity.User;
import com.sparta.project_upgradeschedulemanage.user.repository.UserRepository;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {

        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = new User(signupRequestDto.getUsername(), signupRequestDto.getEmail(), encodedPassword);

        User savedUser = userRepository.save(user);

        String bearerToken = jwtUtil.createToken(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());

        return new SignupResponseDto(bearerToken);
    }

    public SigninResponseDto signin(SigninRequestDto signinRequestDto) throws AuthException {
        User user = userRepository.findByEmail(signinRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다."));

        if (!passwordEncoder.matches(signinRequestDto.getPassword(), user.getPassword())) {
            throw new AuthException("잘못된 비밀번호입니다.");
        }
        String bearerToken = jwtUtil.createToken(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
        return new SigninResponseDto(bearerToken);


    }

}*/
