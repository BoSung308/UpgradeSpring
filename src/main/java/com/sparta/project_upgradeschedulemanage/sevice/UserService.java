package com.sparta.project_upgradeschedulemanage.sevice;


import com.sparta.project_upgradeschedulemanage.dto.UserRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.UserResponseDto;
import com.sparta.project_upgradeschedulemanage.entity.User;
import com.sparta.project_upgradeschedulemanage.repository.ScheduleRepository;
import com.sparta.project_upgradeschedulemanage.repository.UserRepository;
import com.sparta.project_upgradeschedulemanage.repository.UserScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserScheduleRepository userScheduleRepository;

    // 유저 생성
    public UserResponseDto createUser(UserRequestDto requestDto){
        // Response to Entity
        User user = new User(requestDto);

        // DB 저장
        userRepository.save(user);

        // Entity to ResponseDto
        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;

    }




/*    // 추가 유저 등록
    public UserScheduleResponseDto plusUser(UserScheduleRequsetDto userScheduleRequsetDto) {

        Long scheduleId = userScheduleRequsetDto.getScheduleId();
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(()
                -> new IllegalArgumentException("ScheduleId 값이 존재하지 않습니다."));

        Long userId = userScheduleRequsetDto.getUserId();
        User user = userRepository.findById(userId).orElseThrow(()
                -> new IllegalArgumentException("UserId 값이 존재하지 않습니다."));

        UserSchedule userSchedule = new UserSchedule(user, schedule);
        userScheduleRepository.save(userSchedule);

        UserScheduleResponseDto userScheduleResponseDto = new UserScheduleResponseDto(userSchedule);

        return userScheduleResponseDto;
    }*/


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
