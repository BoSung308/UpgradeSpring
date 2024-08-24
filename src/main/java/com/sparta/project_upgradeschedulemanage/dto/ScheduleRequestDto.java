package com.sparta.project_upgradeschedulemanage.dto;

import com.sparta.project_upgradeschedulemanage.entity.ScheduleEntity;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {

    private String username;
    private String todoTitle;
    private String todoContents;
}
