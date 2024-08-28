package com.sparta.project_upgradeschedulemanage.dto;

import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String username;
    private String todoTitle;
    private String todoContents;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.todoTitle = schedule.getTodoTitle();
        this.todoContents = schedule.getTodoContents();
        this.createDate = schedule.getCreateDate();
        this.modifyDate = schedule.getModifyDate();


    }
}
