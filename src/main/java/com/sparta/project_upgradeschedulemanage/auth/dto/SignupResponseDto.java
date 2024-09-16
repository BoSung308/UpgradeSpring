package com.sparta.project_upgradeschedulemanage.auth.dto;

import lombok.Getter;

@Getter
public class SignupResponseDto{

    private final String bearerToken;
    public SignupResponseDto(String bearerToken){
        this.bearerToken = bearerToken;
    }
}
