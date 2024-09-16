package com.sparta.project_upgradeschedulemanage.auth.dto;

import lombok.Getter;

@Getter
public class SigninResponseDto {

    private String bearerToken;

    public SigninResponseDto(String bearerToken){
        this.bearerToken = bearerToken;
    }
}
