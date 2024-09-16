package com.sparta.project_upgradeschedulemanage.auth.service;

import com.sparta.project_upgradeschedulemanage.auth.dto.SignInRequestDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignInResponseDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignupRequestDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignupResponseDto;
import com.sparta.project_upgradeschedulemanage.config.JwtUtil;
import com.sparta.project_upgradeschedulemanage.config.PasswordEncoder;
import com.sparta.project_upgradeschedulemanage.exception.AuthException;
import com.sparta.project_upgradeschedulemanage.user.entity.User;
import com.sparta.project_upgradeschedulemanage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {

        if(userRepository.existsByEmail(signupRequestDto.getEmail())){
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = new User(signupRequestDto.getUsername(), signupRequestDto.getEmail(), encodedPassword);

        User savedUser = userRepository.save(user);

        String bearerToken = jwtUtil.createToken(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getUsername()
        );

        return new SignupResponseDto(bearerToken);

    }

    public SignInResponseDto signin(SignInRequestDto signinRequestDto)  {
        User user = userRepository.findByEmail(signinRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다..")
                );

        // 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401 반환
        if(!PasswordEncoder.matches(signinRequestDto.getPassword(), user.getPassword())) {
            throw new AuthException("잘못된 비밀번호입니다.");
        }

        String bearerToken = jwtUtil.createToken(
                user.getId(),
                user.getEmail(),
                user.getUsername()
        );
        return new SignInResponseDto(bearerToken);


    }

}
