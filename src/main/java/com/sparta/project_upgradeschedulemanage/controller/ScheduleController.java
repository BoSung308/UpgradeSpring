package com.sparta.project_upgradeschedulemanage.controller;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.sevice.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class ScheduleController {
        private final ScheduleService scheduleService;

        public ScheduleController(ScheduleService scheduleService){
                this.scheduleService = scheduleService;
        }
        // 생성
        @PostMapping("/schedule")
        public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
                return scheduleService.createSchedule(scheduleRequestDto);
        }

        // 단건 조회
        @GetMapping("/schedule/{id}")
        public ScheduleResponseDto getIdInfo(@PathVariable Long id) {
                return scheduleService.getIdInfo(id);
        }

        // Update
        @PutMapping("/schedule/{id}")
        // Service 클래스에서 Entity클래스를 통하여 update를 호출하도록 void 타입 사용
        public void updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
                scheduleService.updateSchedule(id, requestDto);
        }
}
