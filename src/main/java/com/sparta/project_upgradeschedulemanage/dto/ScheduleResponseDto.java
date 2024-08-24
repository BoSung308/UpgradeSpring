package com.sparta.project_upgradeschedulemanage.dto;

import com.sparta.project_upgradeschedulemanage.entity.ScheduleEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String username;
    private String todoTitle;
    private String todoContents;
    private Timestamp create_date;
    private Timestamp modify_date;

    public ScheduleResponseDto(ScheduleEntity scheduleEntity) {
        this.id = scheduleEntity.getId();
        this.username = scheduleEntity.getUsername();
        this.todoTitle = scheduleEntity.getTodoTitle();
        this.todoContents = scheduleEntity.getTodoContents();
        this.create_date = scheduleEntity.getCreate_date();
        this.modify_date = scheduleEntity.getModify_date();


    }
}
