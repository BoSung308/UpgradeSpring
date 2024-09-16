package com.sparta.project_upgradeschedulemanage.user.controller;


import com.sparta.project_upgradeschedulemanage.config.PasswordEncoder;
import com.sparta.project_upgradeschedulemanage.user.dto.UserRequestDto;
import com.sparta.project_upgradeschedulemanage.user.dto.UserResponseDto;
import com.sparta.project_upgradeschedulemanage.user.dto.UserSaveRequestDto;
import com.sparta.project_upgradeschedulemanage.user.dto.UserSaveResponseDto;
import com.sparta.project_upgradeschedulemanage.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    private UserController(UserService userService){
        this.userService = userService;
    }


    // 단건 조회
    @GetMapping("/user/{id}")
    public UserResponseDto getIdInfo(@PathVariable Long id) {
        return userService.getIdInfo(id);
    }


    // 전체 조회
    @GetMapping("/users")
    public List<UserResponseDto> getUser(){
        return userService.getUser();
    }


    // 유저 삭제
    @DeleteMapping("/user/{id}")
    public Long deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
