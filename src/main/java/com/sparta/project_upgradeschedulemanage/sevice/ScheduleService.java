package com.sparta.project_upgradeschedulemanage.sevice;

import com.sparta.project_upgradeschedulemanage.dto.ScheduleRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.entity.ScheduleEntity;
import com.sparta.project_upgradeschedulemanage.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 스케줄 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        // RequestDto to Entity
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleRequestDto);
        //username, todoTitle, todoContents

        // DB에 저장
        scheduleRepository.save(scheduleEntity);

        // Entity to ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(scheduleEntity);
        return scheduleResponseDto;
    }

    public ScheduleResponseDto getIdInfo(Long id) {
        // id를 못찾을경우 Entity가 null이됨
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElse(null);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(scheduleEntity);
        return scheduleResponseDto;
    }

    @Transactional
    public void updateSchedule(Long id, ScheduleRequestDto requestDto){
        // Repository에서 찾은 id데이터를 Entity객체에 넣어주도록함
        ScheduleEntity scheduleEntity = findScheduleEntity(id);
        // Entity객체에 넣은 id데이터를 수정할 수 있는 메서드 호출
        scheduleEntity.update(requestDto);
    }

    // Repository에서 id를 찾을수있도록 메소드를 선언
    private ScheduleEntity findScheduleEntity(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다.")
        );
    }
}
