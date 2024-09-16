package com.sparta.project_upgradeschedulemanage.schedule.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserScheduleResponseDto {

    private List<Long> userIds;
    private Long schedule;
}
