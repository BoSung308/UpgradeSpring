package com.sparta.project_upgradeschedulemanage.controller;

import com.sparta.project_upgradeschedulemanage.dto.ScheduleRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.dto.UserScheduleRequestDto;
import com.sparta.project_upgradeschedulemanage.sevice.ScheduleService;
import com.sparta.project_upgradeschedulemanage.sevice.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {
        private final ScheduleService scheduleService;
        private final UserService userService;

        public ScheduleController(ScheduleService scheduleService, UserService userService){
                this.scheduleService = scheduleService;
                this.userService = userService;
        }


        // 스케줄 생성
        @PostMapping("/createSchedule")
        public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
                return scheduleService.createSchedule(scheduleRequestDto);
        }


        @PostMapping("/plusUser")
        public void plusUser(@RequestBody UserScheduleRequestDto requestDto){
                System.out.println("requestDto.getUserIds().size() = " + requestDto.getUserIds().size());
                System.out.println("requestDto.getScheduleId() = " + requestDto.getScheduleId());
                scheduleService.plusUser(requestDto);
        }


        //스케줄 id로 단건 조회
        @GetMapping("/schedule/{id}")
        public ScheduleResponseDto getIdInfo(@PathVariable Long id) {
                return scheduleService.getIdInfo(id);
        }


        // 댓글 개수, 페이지 조회
        @GetMapping("schedules")
        public ResponseEntity<Page<ScheduleResponseDto>> getSchedules(
                @RequestParam(value = "page", defaultValue = "0") int page,
                @RequestParam(value = "size", defaultValue = "2") int size) {

                return ResponseEntity.ok(scheduleService.getSchedules(page,size));
        }


        // 스케줄 Update
        @PutMapping("/schedule/{id}")
        // Service 클래스에서 Entity클래스를 통하여 update를 호출하도록 void 타입 사용
        public void updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
                scheduleService.updateSchedule(id, requestDto);
        }

        // 스케줄 삭제
        @DeleteMapping("/schedule/{id}")
        public Long deleteSchedule(@PathVariable("id") Long id){
                return scheduleService.deleteSchedule(id);
        }
}
