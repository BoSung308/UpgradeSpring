package com.sparta.project_upgradeschedulemanage.auth.dto;

import lombok.Getter;

@Getter
public class SignInResponseDto {

    private String bearerToken;

    public SignInResponseDto(String bearerToken){
        this.bearerToken = bearerToken;
    }
}
