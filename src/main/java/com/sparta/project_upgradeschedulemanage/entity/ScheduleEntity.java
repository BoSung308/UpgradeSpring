package com.sparta.project_upgradeschedulemanage.entity;

import com.sparta.project_upgradeschedulemanage.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ScheduleEntity")
public class ScheduleEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "todoTitle", nullable = false)
    private String todoTitle;

    @Column(name = "todoContents", nullable = false)
    private String todoContents;

    public ScheduleEntity(ScheduleRequestDto requestDto){

        this.username = requestDto.getUsername();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContents = requestDto.getTodoContents();
    }

    public void update(ScheduleRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContents = requestDto.getTodoContents();
    }
}