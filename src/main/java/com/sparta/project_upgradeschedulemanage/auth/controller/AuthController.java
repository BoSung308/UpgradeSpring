package com.sparta.project_upgradeschedulemanage.auth.controller;

import com.sparta.project_upgradeschedulemanage.auth.dto.SignInRequestDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignupRequestDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignupResponseDto;
import com.sparta.project_upgradeschedulemanage.auth.dto.SignInResponseDto;
import com.sparta.project_upgradeschedulemanage.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public SignupResponseDto signup(@RequestBody SignupRequestDto signupRequestDto){
            return authService.signup(signupRequestDto);
    }

    @PostMapping("/auth/signin")
    public SignInResponseDto singin(@RequestBody SignInRequestDto signinRequestDto){
            return authService.signin(signinRequestDto);
    }
}
