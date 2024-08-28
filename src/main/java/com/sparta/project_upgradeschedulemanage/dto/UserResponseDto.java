package com.sparta.project_upgradeschedulemanage.dto;


import com.sparta.project_upgradeschedulemanage.entity.User;
import lombok.Getter;

import java.sql.Timestamp;
@Getter
public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private Timestamp createDate;
    private java.sql.Timestamp modifyDate;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createDate = user.getCreateDate();
        this.modifyDate = user.getModifyDate();
    }
}
