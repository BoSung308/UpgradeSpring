package com.sparta.project_upgradeschedulemanage.schedule.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserScheduleRequestDto {
    private List<Long> userIds;
    private Long scheduleId;

    }

