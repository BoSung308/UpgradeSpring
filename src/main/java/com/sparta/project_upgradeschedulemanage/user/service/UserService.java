package com.sparta.project_upgradeschedulemanage.user.service;


import com.sparta.project_upgradeschedulemanage.config.JwtUtil;
import com.sparta.project_upgradeschedulemanage.config.PasswordEncoder;
import com.sparta.project_upgradeschedulemanage.user.dto.UserRequestDto;
import com.sparta.project_upgradeschedulemanage.user.dto.UserResponseDto;
import com.sparta.project_upgradeschedulemanage.user.dto.UserSaveRequestDto;
import com.sparta.project_upgradeschedulemanage.user.dto.UserSaveResponseDto;
import com.sparta.project_upgradeschedulemanage.user.entity.User;
import com.sparta.project_upgradeschedulemanage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;


    // 유저 생성
    public UserSaveResponseDto createUser(UserSaveRequestDto requestDto){
        if(userRepository.existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(requestDto.getUsername(), requestDto.getEmail(), encodedPassword);

        User savedUser = userRepository.save(user);

        String bearerToken = jwtUtil.createToken(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getUsername()
        );

        return new UserSaveResponseDto(bearerToken);

    }



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
