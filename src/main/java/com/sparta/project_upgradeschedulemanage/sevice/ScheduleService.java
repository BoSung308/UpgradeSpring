package com.sparta.project_upgradeschedulemanage.sevice;

import com.sparta.project_upgradeschedulemanage.dto.ScheduleRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.dto.UserScheduleRequestDto;
import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import com.sparta.project_upgradeschedulemanage.entity.User;
import com.sparta.project_upgradeschedulemanage.entity.UserSchedule;
import com.sparta.project_upgradeschedulemanage.repository.ScheduleRepository;
import com.sparta.project_upgradeschedulemanage.repository.UserRepository;
import com.sparta.project_upgradeschedulemanage.repository.UserScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final PageableHandlerMethodArgumentResolverCustomizer pageableCustomizer;
    private final UserScheduleRepository userScheduleRepository;
    private final UserRepository userRepository;

    // 스케줄 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        // RequestDto to Entity
        Schedule schedule = new Schedule(scheduleRequestDto);
        //username, todoTitle, todoContents를 schedule에 저장

        // DB에 저장
        scheduleRepository.save(schedule);

        // Entity to ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public void plusUser(UserScheduleRequestDto requestDto) {
        Long scheduleId = requestDto.getScheduleId();

        // 기존 스케줄 조회
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(()
                -> new IllegalArgumentException("유효한 schedule id값이 아닙니다."));

        // 담당 유저 스케줄에 배치
        List<Long> userIds = requestDto.getUserIds();
        for (Long userId : userIds) {
            User user = userRepository.findById(userId).orElseThrow(()
                    -> new IllegalArgumentException("유효한 user id값이 아닙니다."));

            UserSchedule userSchedule = new UserSchedule(user,schedule);
            userScheduleRepository.save(userSchedule);

        }
    }
/////////////////////////////////////////////////////////////////////////////////////////


    // id로 스케줄 조회
    public ScheduleResponseDto getIdInfo(Long id) {
        // id를 못찾을경우 Entity가 null이됨
        Schedule schedule = scheduleRepository.findById(id).orElse(null);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    // 페이징 조회
    public Page<ScheduleResponseDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "modifyDate"));

         return scheduleRepository.findAll(pageable).map(schedule -> new ScheduleResponseDto(schedule));
    }

    // 스케줄 수정
    @Transactional
    public void updateSchedule(Long id, ScheduleRequestDto requestDto){
        // Repository에서 찾은 id데이터를 Entity객체에 넣어주도록함
        Schedule schedule = findSchedule(id);
        // Entity객체에 넣은 id데이터를 수정할 수 있는 메서드 호출
        schedule.update(requestDto);
        System.out.println();
    }

    // 전체 조회
    public Long deleteSchedule(Long id){

        Schedule schedule = findSchedule(id);
        scheduleRepository.delete(schedule);

        return id;
    }


    // Repository에서 id를 찾을수있도록 메소드를 선언
    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다.")
        );
    }
}
