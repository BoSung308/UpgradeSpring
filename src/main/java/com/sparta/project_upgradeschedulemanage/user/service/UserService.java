package com.sparta.project_upgradeschedulemanage.user.service;


import com.sparta.project_upgradeschedulemanage.user.dto.UserResponseDto;
import com.sparta.project_upgradeschedulemanage.user.entity.User;
import com.sparta.project_upgradeschedulemanage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    // id로 스케줄 조회
    public UserResponseDto getIdInfo(Long id) {
        // id를 못찾을경우 Entity가 null이됨
        User user = userRepository.findById(id).orElse(null);

        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;
    }


    // 전체 조회
    public List<UserResponseDto> getUser() {
        // DB 조회
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }


    public Long deleteUser(Long id){

        User user = findUser(id);
        userRepository.delete(user);

        return id;
    }


    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다.")
        );
    }
}
