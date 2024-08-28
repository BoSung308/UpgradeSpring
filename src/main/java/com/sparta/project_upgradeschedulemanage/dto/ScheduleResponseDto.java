package com.sparta.project_upgradeschedulemanage.dto;

import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String username;
    private String todoTitle;
    private String todoContents;
    private Timestamp create_date;
    private Timestamp modify_date;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.todoTitle = schedule.getTodoTitle();
        this.todoContents = schedule.getTodoContents();
        this.create_date = schedule.getCreate_date();
        this.modify_date = schedule.getModifyDate();


    }
}
