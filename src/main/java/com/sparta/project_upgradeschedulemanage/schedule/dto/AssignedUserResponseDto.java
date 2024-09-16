package com.sparta.project_upgradeschedulemanage.schedule.dto;

import lombok.Getter;

@Getter
public class AssignedUserResponseDto {
    private Long id;
    private String username;
    private String email;
    private ScheduleResponseDto scheduleResponseDto;

    public AssignedUserResponseDto(Long id, String email, String username,  ScheduleResponseDto scheduleResponseDto){
        this.id = id;
        this.email = email;
        this.username = username;
        this.scheduleResponseDto = scheduleResponseDto;
    }
}